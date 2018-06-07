package com.major.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.major.pojos.ReimbType;
import com.major.util.LookupService;

@WebServlet("/loadtypes")
public class TypeLoaderServlet extends HttpServlet
{
	static LookupService looker = new LookupService();
	private static Logger logger = Logger.getLogger(TypeLoaderServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		logger.info("Attempting to return all types");
		ArrayList<ReimbType> types = looker.getAllTypes();
		String outJSON = "";
		ObjectMapper mapper = new ObjectMapper();
		outJSON = mapper.writeValueAsString(types);
		PrintWriter write = resp.getWriter();
		resp.setContentType("application/json");
		write.write(outJSON);
	}
	
}
