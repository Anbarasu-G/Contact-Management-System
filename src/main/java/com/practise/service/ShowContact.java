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

@WebServlet("/show_contact")
public class ShowContact extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user =(User) session.getAttribute("user");
      
		
		List<Contact> contacts = user.getContacts();
		
		req.setAttribute("contacts", contacts);
		req.getRequestDispatcher("show_contact.jsp").forward(req, resp);
	}
}
