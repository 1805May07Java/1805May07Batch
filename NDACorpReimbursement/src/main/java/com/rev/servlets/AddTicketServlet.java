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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.Reimburse;
import com.rev.service.ReimburseService;

@WebServlet("/addticket")
public class AddTicketServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		ObjectMapper mapper = new ObjectMapper();

		String json = br.readLine();
		
		Reimburse r = mapper.readValue(json, Reimburse.class);
		//r.setResolver(0);
		ReimburseService service = new ReimburseService();
		boolean t = service.add(r); 
		if((t == true)) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/text");
			out.write("true");
		}
		else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/text");
			out.write("false");
		}
	}
}
