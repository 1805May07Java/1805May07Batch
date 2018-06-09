package com.major.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.major.pojos.ErsUser;
import com.major.pojos.LoginCredentials;

import com.major.util.UserService;


@WebServlet("/userlogin")
public class NormalLoginServelet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		UserService useServe = new UserService();
		
		//get a reader
		BufferedReader br = req.getReader();
		
		String json = "";
		json = br.readLine();
		
		//get an object mapper
		ObjectMapper mapper = new ObjectMapper();
		LoginCredentials cred = mapper.readValue(json, LoginCredentials.class);
		ErsUser log = useServe.getUserByName(cred.getUserName());
		//validating credentials
		if(log.getUserName() != null)
		{
			System.out.println("User name is not null.");
			if(useServe.validate(log.getUserName(), log.getPassword()))
			{
				System.out.println("We validated.");
				HttpSession session = req.getSession(true);
				session.setAttribute("user", log);
			}
		}
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		String outJSON = mapper.writeValueAsString(log);
		out.write(outJSON);
	}
}
