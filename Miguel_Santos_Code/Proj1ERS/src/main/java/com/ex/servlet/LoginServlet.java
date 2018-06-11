package com.ex.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ex.pojos.ERSUser;
import com.ex.service.ERSUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(value="/login", loadOnStartup=1)
public class LoginServlet extends HttpServlet{
	private static org.apache.log4j.Logger log = Logger.getLogger(LoginServlet.class);
	
	static {
		log.debug("Bootin up");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		session.invalidate();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		Stream<String> text = req.getReader().lines(); 
		String json = text.collect(Collectors.joining("")).toString();
		
		ObjectMapper mapper = new ObjectMapper();

		ERSUser u = mapper.readValue(json, ERSUser.class);

		ERSUserService us = new ERSUserService();

		u = us.validUnPw(u.getUsername(), u.getPassword());
		if(u != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("userId", u.getId());
			session.setAttribute("userRoleId", u.getRoleId());
		}

		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");

		String outJSON = mapper.writeValueAsString(u);
		out.write(outJSON);
	}

}
