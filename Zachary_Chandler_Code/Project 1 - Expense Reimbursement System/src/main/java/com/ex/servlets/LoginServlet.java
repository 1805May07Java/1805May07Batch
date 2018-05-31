package com.ex.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.pojo.User;
import com.ex.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 2526413196181031457L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BufferedReader body = req.getReader();
		String username = null;
		String password = null;
		User user;
		String s;

		while ((s = body.readLine()) != null) {
			if (s.startsWith("username:")) {
				username = s.substring(9);
			} else if (s.startsWith("password:")) {
				password =  s.substring(9);
			}
		}
		
		if (username == null || password == null || (user = UserService.login(username, password)) == null) {
			failLogin(req, resp);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
//			session.setMaxInactiveInterval(36 * 60 * 60);

			PrintWriter t = resp.getWriter();
			t.write("logged in");
		}
	}

	private void failLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		out.write("false");
	}

}
