package com.major.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.major.pojos.ErsUser;
import com.major.util.UserService;

@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//services
		UserService useServe = new UserService();
		
		//get a reader
		BufferedReader br = req.getReader();
		//sanitize input
		String json = "";
		while(br!=null)
		{
			json += br.readLine();
		}
		
		//get an object mapper
		ObjectMapper mapper = new ObjectMapper();
		ErsUser created = mapper.readValue(json, ErsUser.class);
		
		ErsUser out = useServe.create(created);
		
		String outJSON = "";
		outJSON = mapper.writeValueAsString(out);
		PrintWriter write = resp.getWriter();
		resp.setContentType("application/json");
		write.write(outJSON);
		
	}
}
