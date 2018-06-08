package com.major.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.major.pojos.ErsUser;
import com.major.pojos.IdHolder;
import com.major.util.UserService;

@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet
{
	private static Logger logger = Logger.getLogger(FullTableServlet.class);
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		logger.info("Attempting to register user.");
		//services
		UserService useServe = new UserService();
		
		//get a reader
		BufferedReader br = req.getReader();
		//sanitize input
		String json = "";
		
			json = br.readLine();
	
	
		//get an object mapper
		ObjectMapper mapper = new ObjectMapper();
		ErsUser created = mapper.readValue(json, ErsUser.class);
		System.out.println(created.toString());
		if(useServe.available(created.getUserName(), created.getEmail()))
		{
			ErsUser out = useServe.create(created);
			
			String outJSON = "";
			outJSON = mapper.writeValueAsString(out);
			PrintWriter write = resp.getWriter();
			resp.setContentType("application/json");
			write.write(outJSON);
		}
		else 
		{
			IdHolder fail = new IdHolder(0);
			String outJSON = "";
			outJSON = mapper.writeValueAsString(fail);
			PrintWriter write = resp.getWriter();
			resp.setContentType("application/json");
			write.write(outJSON);
		}
		
		
	}
}
