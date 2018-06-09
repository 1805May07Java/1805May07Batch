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

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.major.pojos.ClaimDecision;
import com.major.pojos.ErsUser;
import com.major.pojos.IdHolder;
import com.major.pojos.Reimbursement;
import com.major.util.LookupService;
import com.major.util.ReimbursementService;
import com.major.util.UserService;
import com.major.util.ViewService;

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
		HttpSession session = req.getSession();
		if(session.getAttribute("user") == null) 
		{
			resp.sendRedirect("index.html");
		}
		else 
		{
			logger.info("Attempting to decide claim");
			//get a reader
			BufferedReader br = req.getReader();
			ViewService viewServe = new ViewService();
			//sanitize input
			String json = "";
			
			json = br.readLine();

			ObjectMapper mapper = new ObjectMapper();
			ClaimDecision decide = mapper.readValue(json, ClaimDecision.class);
			Reimbursement changed = ReimbServe.getById(decide.getId());
			ErsUser x = (ErsUser) session.getAttribute("user");
			if(changed.getStatusId() == 1) 
			{
				changed.setStatusId(looker.getStatusId(decide.isDecision()));
				changed.setResolverId(x.getId());
				Reimbursement out = ReimbServe.update(changed);
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
}
