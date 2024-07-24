package com.practise.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practise.config.DaoSingleton;
import com.practise.entity.User;
@WebServlet("/register")
public class RegisterUser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user=new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);

		boolean result = DaoSingleton.getUserDao().saveUser(user);
		if (result) {
			resp.sendRedirect("login.jsp");
		} else {
			req.setAttribute("failure", "fail");
			req.getRequestDispatcher("/register.jsp").forward(req, resp);
		}
		
	}
}
