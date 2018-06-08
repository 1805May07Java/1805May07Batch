package com.major.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.major.pojos.ClaimDecision;
import com.major.pojos.Reimbursement;
import com.major.util.LookupService;
import com.major.util.ReimbursementService;
import com.major.util.UserService;

@WebServlet("/decideclaim")
public class ApprovalServlet extends HttpServlet
{
	private static Logger logger = Logger.getLogger(FullTableServlet.class);
	static ReimbursementService ReimbServe = new ReimbursementService();
	static UserService useServe = new UserService();
	static LookupService looker = new LookupService();
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session = req.getSession(false);
		if(session == null) 
		{
			resp.sendRedirect("index.html");
		}
		else 
		{
			logger.info("Attempting to decide claim");
			ObjectMapper mapper = new ObjectMapper();
			
			ClaimDecision decide = mapper.readValue("json", ClaimDecision.class);
			
			Reimbursement changed = ReimbServe.getById(decide.getId());
			
			changed.setStatusId(looker.getStatusId(decide.isDecision()));
			
			Reimbursement out = ReimbServe.update(changed);
			
			String outJSON = "";
			outJSON = mapper.writeValueAsString(out);
			PrintWriter write = resp.getWriter();
			resp.setContentType("application/json");
			write.write(outJSON);
			
		}
	}
}
