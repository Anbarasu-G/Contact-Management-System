package com.practise.service;

import java.io.IOException;
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

@WebServlet("/deleteContact")
public class DeleteContact extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user =(User) session.getAttribute("user");

		int contactId = Integer.parseInt(req.getParameter("contactId"));

		List<Contact> contacts = user.getContacts();

		for (Contact contact : contacts) {
			if(contact.getContactId()==contactId) {
				contacts.remove(contact);
				break;
			}
		}
		user.setContacts(contacts);
		DaoSingleton.getUserDao().updateUser(user);

		boolean result = DaoSingleton.getContactDao().deleteContact(contactId);

		user= DaoSingleton.getUserDao().findUser(user.getId());
		session.setAttribute("user", user);
		
		if (result) {
			resp.sendRedirect("index.jsp");
		} else {
           
		}
	}    
}
