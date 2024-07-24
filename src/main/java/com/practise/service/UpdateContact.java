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

@WebServlet("/edit")
public class UpdateContact extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int contactId = Integer.parseInt(req.getParameter("contactId"));
		String contactname = req.getParameter("contactname");
		Long contactNumber = Long.parseLong(req.getParameter("contactNumber"));

		Contact contact = DaoSingleton.getContactDao().findContact(contactId);
		contact.setContactName(contactname);
		contact.setContactNumber(contactNumber);

		boolean result = DaoSingleton.getContactDao().updateContact(contact);

		if (result) {
			HttpSession session = req.getSession();	
			User user = (User)session.getAttribute("user");
			user= DaoSingleton.getUserDao().findUser(user.getId());
			session.setAttribute("user", user);
			resp.sendRedirect("show_contact");
		}
		else {
			req.setAttribute("failure", "failed to update");
			req.getRequestDispatcher("edit.jsp").forward(req, resp);
		}
	}
}
