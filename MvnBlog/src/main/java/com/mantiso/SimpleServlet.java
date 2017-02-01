package com.mantiso;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/home", "*.dot" }, initParams = {
		@WebInitParam(name = "ProductName", value = "Welcome Application, server=...") })
public class SimpleServlet extends HttpServlet {
	String appName = "My Application";

	@Override
	public void init() throws ServletException {
		appName = getServletContext().getInitParameter("ProductName");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// param names are case sensitive
		String name = req.getParameter("name");
		// resp.getWriter().write("Hello World Test");

		/*
		 * If statement will be true using
		 * http://localhost:8080/simple-1.0-SNAPSHOT/home?name=Morris
		 */
		if (name != null) {
			resp.setContentType("text/xml");
			resp.getWriter().printf("<application> <name>Hello %s</name> <product>%s</product> </application>", name,
					appName);
		} else {
			//resp.getWriter().write("Please enter a name");
			throw new ServletException("A name should be entered.");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// param names are case sensitive
		String name = req.getParameter("name");
		// resp.getWriter().write("Hello World Test");

		if (name != null && !name.isEmpty())
			resp.getWriter().printf("Hello %s", name);
		else
			resp.sendRedirect("index.jsp");
	}

}
