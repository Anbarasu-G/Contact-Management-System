package com.practise.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.practise.config.DaoSingleton;
import com.practise.entity.Contact;
import com.practise.entity.User;

@WebServlet("/addContact")
public class AddContact extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user=(User)session.getAttribute("user");

		String contactname = req.getParameter("contactname");
		Long contactNumber = Long.parseLong(req.getParameter("contactNumber"));

		Contact contact = new Contact();
		contact.setContactName(contactname);
		contact.setContactNumber(contactNumber);
		contact.setUser(user);

		//List<Contact> contacts=new ArrayList<Contact>();
		
		List<Contact> contacts = user.getContacts();
		contacts.add(contact);
		user.setContacts(contacts);

//		boolean resultuser = DaoSingleton.getUserDao().updateUser(user);
		boolean result = DaoSingleton.getContactDao().saveContact(contact);

		if (result) 
//			req.setAttribute("success", "success");
			resp.sendRedirect("index.jsp");
		else {
			req.setAttribute("failure", "failed");
			req.getRequestDispatcher("addContact.jsp").forward(req, resp);
		}
	}
}
