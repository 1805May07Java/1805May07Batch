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
import com.major.pojos.ClaimData;
import com.major.pojos.ErsUser;
import com.major.pojos.Reimbursement;
import com.major.util.LookupService;
import com.major.util.ReimbursementService;

@WebServlet("/submitclaim")
public class SubmitClaimServlet extends HttpServlet
{
		static LookupService looker = new LookupService();
		static ReimbursementService ReimbServe = new ReimbursementService();
		private static Logger logger = Logger.getLogger(SubmitClaimServlet.class);
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				
			HttpSession session = req.getSession(false);
			if(session == null) 
			{
				resp.sendRedirect("index.html");
			}
			else 
			{
				logger.info("Submitting claim");
				ObjectMapper mapper = new ObjectMapper();
				ErsUser user = (ErsUser) session.getAttribute("user");
				ClaimData claim = mapper.readValue("json", ClaimData.class);
				Reimbursement entry = new Reimbursement();
				
				entry.setAmount(claim.getAmount());
				entry.setDescription(claim.getDescription());
				entry.setRequesterId(user.getId());
				entry.setTypeId(looker.getTypeId(claim.getType()));
				
				Reimbursement out = ReimbServe.create(entry);
				
				String outJSON = "";
				outJSON = mapper.writeValueAsString(out);
				PrintWriter write = resp.getWriter();
				resp.setContentType("application/json");
				write.write(outJSON);
			}
			
			
		}
}
