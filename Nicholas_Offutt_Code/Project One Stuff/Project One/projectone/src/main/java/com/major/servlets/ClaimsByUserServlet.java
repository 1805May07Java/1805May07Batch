package com.major.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.major.pojos.ErsUser;
import com.major.pojos.FullView;
import com.major.pojos.IdHolder;
import com.major.pojos.Reimbursement;
import com.major.util.ReimbursementService;
import com.major.util.UserService;
import com.major.util.ViewService;

@WebServlet("/claimsbyid")
public class ClaimsByUserServlet extends HttpServlet
{
	private static Logger logger = Logger.getLogger(ClaimsByUserServlet.class);
	static UserService useServe = new UserService();
	static ReimbursementService ReimbServe = new ReimbursementService();
	static ViewService viewServe = new ViewService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("attempting to obtain user records by id");
		HttpSession session = req.getSession(false);
		if(session == null) 
		{
			resp.sendRedirect("index.html");
		}
		else
		{
			ArrayList<FullView>  outList = new ArrayList<FullView>();
			FullView temp = new FullView();
			IdHolder id = new IdHolder();
			
			//set up a dummy
			ErsUser dummyRes = new ErsUser();
			dummyRes.setId(0);
			dummyRes.setFirstName("");
			dummyRes.setLastName("");
			
			
			
			ObjectMapper mapper = new ObjectMapper();
			id = mapper.readValue("json", IdHolder.class);
			int x = id.getId();
			
			ErsUser emp = useServe.getById(x);
			
			List<Reimbursement> full = ReimbServe.getByAuthor(emp);
			for(Reimbursement r : full) 
			{
				if(r.getResolverId()==0)
				{
					temp = viewServe.assembleFullView(useServe.getById(r.getRequesterId()), dummyRes, r);
				}
				else 
				{
					temp = viewServe.assembleFullView(useServe.getById(r.getRequesterId()), useServe.getById(r.getResolverId()), r);
				}
				outList.add(temp);
			}
			
			String outJSON = "";
			outJSON = mapper.writeValueAsString(outList);
			PrintWriter write = resp.getWriter();
			resp.setContentType("application/json");
			write.write(outJSON);
		}
	}
}
