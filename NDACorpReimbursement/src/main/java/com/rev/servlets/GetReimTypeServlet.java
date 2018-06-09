package com.rev.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojos.ReimTypes;
import com.rev.pojos.User;
import com.rev.service.ReimburseService;


@WebServlet("/getreimtypes")
public class GetReimTypeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReimburseService service = new ReimburseService();
		ArrayList<ReimTypes> r = service.getReimTypes();
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		String outJSON = mapper.writeValueAsString(r);
		out.write(outJSON);
	}
}
