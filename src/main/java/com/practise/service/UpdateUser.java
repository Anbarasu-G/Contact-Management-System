package com.practise.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.practise.config.DaoSingleton;
import com.practise.dao.UserDao;
import com.practise.entity.User;


@WebServlet("/update")
public class UpdateUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId=Integer.parseInt(req.getParameter("userId"));
		String username =req.getParameter("username");
		String email =req.getParameter("email");
		String password =req.getParameter("password");

		HttpSession session = req.getSession();
		User  user= (User)session.getAttribute("user");
		user.setId(userId);
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);;

		boolean result = DaoSingleton.getUserDao().updateUser(user);
		if (result) 
			req.setAttribute("success", "Updated Successfully !!!");
		else 
			req.setAttribute("failure", "Failed to Update  !!!");
		req.getRequestDispatcher("update.jsp").forward(req, resp);
	}   
}
