package com.rev.servlets;

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
import com.rev.pojos.User;
import com.rev.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		ObjectMapper mapper = new ObjectMapper();
		
		String json = br.readLine();
		
		User u = mapper.readValue(json, User.class);
		
		UserService service = new UserService();
		u = service.login(u.getUserName(), u.getPassword());
		if((u != null) /*&& u.getUserID() != -1*/) { // if user exists, store them in session
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			String outJSON = mapper.writeValueAsString(u);
			out.write(outJSON);
			
		}
		/*else if(u.getUserID() == -1) {
			
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			u = null;
			String outJSON = mapper.writeValueAsString(u);
			out.write(outJSON);
			
		}*/
		else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			u = null;
			String outJSON = mapper.writeValueAsString(u);
			out.write(outJSON);
		}
		
		
	}
}
