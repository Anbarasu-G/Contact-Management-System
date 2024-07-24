package com.practise.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practise.config.DaoSingleton;
import com.practise.entity.Contact;


@WebServlet("/update-Contact")
public class FindContact extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int contactId = Integer.parseInt(req.getParameter("contactId"));

		Contact contact = DaoSingleton.getContactDao().findContact(contactId);

		req.setAttribute("contact", contact);
		req.getRequestDispatcher("edit.jsp").forward(req, resp);

	}
}
