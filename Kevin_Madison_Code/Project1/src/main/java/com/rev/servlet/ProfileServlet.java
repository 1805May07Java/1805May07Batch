package com.rev.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojo.User;
import com.rev.service.UserService;

@WebServlet("/editProfile")
public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 2. instantiate object mapper
		ObjectMapper mapper = new ObjectMapper();

		

		HttpSession session = req.getSession(false);

		User u = (User) session.getAttribute("user");
		

		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");

		
		String outJSON = mapper.writeValueAsString(u);
		out.write(outJSON);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		json += br.readLine();
		
		System.out.println(json);

		// 2. instantiate object mapper
		ObjectMapper mapper = new ObjectMapper();

		// 3. convert json string to object
		User r = mapper.readValue(json, User.class);

		HttpSession session = req.getSession(false);
		
		User u = (User)session.getAttribute("user");
		r.setUserId(u.getUserId());
		System.out.println(r.toString());
		
		
		
		// now that we have our request info, let's talk to our backend
		// using none other than our service aka business logic layer
		UserService service = new UserService();
		
		//service.
		User updatedUser = service.updateUser(r);
		
		session.setAttribute("user", updatedUser);
		
	}
}
