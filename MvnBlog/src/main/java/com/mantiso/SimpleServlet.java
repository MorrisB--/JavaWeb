package com.mantiso;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/home", "*.dot" })
public class SimpleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// param names are case sensitive
		String name = req.getParameter("name");
		// resp.getWriter().write("Hello World Test");
		
		/*
		 * If statement will be true using 
		 * http://localhost:8080/simple-1.0-SNAPSHOT/home?name=Morris 
		 */
		if (name != null)
			resp.getWriter().printf("Hello %s", name);
		else
			resp.getWriter().write("Please enter a name");
	}

}
