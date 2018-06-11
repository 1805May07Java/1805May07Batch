package com.ex.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ex.dao.DaoImpl;
import com.ex.pojos.Reimbursement;
import com.ex.pojos.User;
import com.ex.service.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;



//@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hello! in register servlet");

		String name = req.getParameter("username");
		String pass = req.getParameter("password");

		System.out.println("-- IN LOGIN POST --");

		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String json = br.readLine();
		System.out.println(json);

		// 2. instantiate object mapper
		ObjectMapper mapper = new ObjectMapper();

		// 3. convert json string to object
		User u = mapper.readValue(json, User.class);

		// now that we have our request info, let's talk to our backend
		// using none other than our service aka business logic layer
		ReimbursementService service = new ReimbursementService();

		//u = service.insertUser(u.getUsername(), u.getPassword());
		if (u != null) { // if user exists, store them in session
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			//resp.sendRedirect("ReimbursementService");//Changed from hello
		}

		System.out.println(u);

		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");

		String outJSON = mapper.writeValueAsString(u);
		out.write(outJSON);

	}

}
