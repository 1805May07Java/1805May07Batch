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
		
		//sanitize input
		String json = "";
		while(br!=null) {

			json += br.readLine();

		}
		
		//get an object mapper
		ObjectMapper mapper = new ObjectMapper();
		
		LoginCredentials cred = mapper.readValue(json, LoginCredentials.class);
		ErsUser log = useServe.getUserByName(cred.getUserName());
		if(log.getUserName() != null)
		{
			if(useServe.validate(log.getUserName(), log.getPassword()))
			{
				HttpSession session = req.getSession();
				session.setAttribute(log.getUserName(), log);
			}
		}
		PrintWriter out = resp.getWriter();

		resp.setContentType("application/json");

		String outJSON = mapper.writeValueAsString(log);

		out.write(outJSON);
		
		
		
		
	}
}
