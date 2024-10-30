package com.blog.controllers;

import com.blog.models.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;


@WebServlet("/login")  // URL pattern mapped to the LoginServlet
public class LoginServlet extends HttpServlet 
{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		
		User user = Database.getUserByUsernameAndPassword(Username, Password);
		
		if (user != null) 
		{
			 	HttpSession session = request.getSession();
	            session.setAttribute("user", user);
	            response.sendRedirect("Dashboard.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp?error=Invalid credentials");
		}
	}

}
