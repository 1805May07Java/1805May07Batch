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
import com.major.pojos.UserView;
import com.major.util.UserService;
import com.major.util.ViewService;

@WebServlet("/userlogin")
public class NormalLoginServelet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		UserService useServe = new UserService();
		
		//get a reader
		BufferedReader br = req.getReader();
		ViewService viewServe = new ViewService();
		//sanitize input
		String json = "";
		while(br!=null) {

			json += br.readLine();

		}
		
		//get an object mapper
		ObjectMapper mapper = new ObjectMapper();
		
		LoginCredentials cred = mapper.readValue(json, LoginCredentials.class);
		ErsUser log = useServe.getUserByName(cred.getUserName());
		UserView ses = viewServe.assembleUserView(log);
		if(log.getUserName() != null)
		{
			if(useServe.validate(log.getUserName(), log.getPassword()))
			{
				HttpSession session = req.getSession();
				session.setAttribute(ses.getUserName(), ses);
			}
		}
		
		PrintWriter out = resp.getWriter();

		resp.setContentType("application/json");

		String outJSON = mapper.writeValueAsString(ses);

		out.write(outJSON);
		
		
		
		
	}
}
