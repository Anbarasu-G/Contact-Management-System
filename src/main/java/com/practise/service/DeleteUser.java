package com.practise.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.practise.config.DaoSingleton;
import com.practise.entity.User;
@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        
        boolean result = DaoSingleton.getUserDao().deleteUser(user.getId());
        
        if (result) 
			req.setAttribute("success", "Deleted Successfully !!!");
        else 
        	req.setAttribute("failure", "Failed to delete !!!");
        req.getRequestDispatcher("manageAccount.jsp").forward(req, resp);
	}
}
