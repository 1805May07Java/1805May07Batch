package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ex.pojos.ReimbStatus;
import com.ex.pojos.Reimbursement;
import com.ex.pojos.User;
import com.ex.service.ReimbRolesService;
import com.ex.service.ReimbStatusService;
import com.ex.service.ReimbTypeService;
import com.ex.service.ReimbursementService;
import com.ex.service.UserService;

/**
 * Servlet implementation class GetReimbursementsServlet
 */
@WebServlet("/getReimb")
public class GetReimbursementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static ReimbTypeService rs;
	static UserService us;
	static ReimbStatusService st;
	
	List<String> typeList;
	List<String> statusList;
	
	static{
	    rs = new ReimbTypeService();
	    us = new UserService();
	    st = new ReimbStatusService();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entering getReimb doGet");
		User currUser;
		if((currUser = (User) request.getSession(false).getAttribute("user")) == null) {
			return;
		}
		System.out.println("currUser has been retrieved");
	    ReimbursementService service = new ReimbursementService();
	    ReimbRolesService roles = new ReimbRolesService();
	    
	    List<Reimbursement> reimList = new ArrayList<Reimbursement>();
		System.out.println("Performing Employee vs Manager Request");
	    if(roles.getRoleByID(currUser.getRole()).equals("EMPLOYEE"))
	    {
	    	reimList = service.getReimbursementByUser(currUser);
	    }
	    else
	    {
	    	reimList = service.getAllReimb();
	    }
	    
	    typeList = rs.getAllTypes();
	    statusList = st.getAllStatus();
	    
		System.out.println("Beginning JSon Write");
	    String json = "{ \"reimlist\": [";
	    for(int i = 0; i < reimList.size(); i++)
	    {
	    	json = json + toJSONString(reimList.get(i));
	    	if(i != reimList.size()-1)
	    	{
	    		json = json + ",";
	    	}
	    }
	    json = json + "]}";
	    
		System.out.println("Returning JSON response");
		System.out.println("JSON String: " + json);
		
		PrintWriter out = response.getWriter();
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    out.print(json);
	    out.flush();
	}
	
	private String toJSONString(Reimbursement r) {	
		
	    User user = us.findUserByID(r.getAuthor());
	    User res = us.findUserByID(r.getResolver());
	    
	    Date submitTime = r.getSubmitTime();
	    Date resolveTime = r.getResolveTime();
	    String reciept_64 = r.getReciept();
	    
	    String opt1 = resolveTime != null ? resolveTime.toString() : "";
	    String opt2 = reciept_64 != null ? reciept_64 : "";
	    
	    String opt3 = res != null ? res.getLn() + ", " + res.getFn() : "";
	    
		return     ("{" +
					"\"ID\":\"" + r.getID() + "\"," +
					"\"Amount\":\"" + String.format("%.2f", r.getAmount()) + "\"," +
					"\"Submission\":\"" + submitTime.toString() + "\"," + 
					"\"Resolved\":\"" + opt1 + "\"," + 
					"\"Description\":\"" + r.getDescription() + "\"," + 
					"\"Receipt\":\"" + opt2 + "\"," + 
					"\"Requester\":\"" + user.getLn() + ", " + user.getFn() + "\"," + 
					"\"Resolver\":\"" + opt3 + "\"," + 
					"\"Status\":\"" + statusList.get(r.getStatus()) + "\"," + 
					"\"Type\":\"" + typeList.get(r.getType()-1)+ "\"" +
					"}");
	}
}
