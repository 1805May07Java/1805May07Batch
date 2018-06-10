package ers.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ers.pojos.Reimbursement;
import ers.pojos.Type;
import ers.pojos.User;
import ers.service.ReimbursementService;
import ers.service.TypeService;
import ers.service.UserService;

@WebServlet("/ViewRequestsManager")
public class ViewRequestManagerServlet extends HttpServlet{
static ReimbursementService rService = new ReimbursementService();
static UserService uService = new UserService();
static TypeService tService = new TypeService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		PrintWriter out = resp.getWriter();
		// Might not be necessary
		Enumeration<String> s = session.getAttributeNames();
		String s1 = s.nextElement();
		User u = (User) session.getAttribute("user");
		resp.setContentType("text/html");
		out.write(generateTypeFilter() + generateTable() + generateModal());
		
	}
	
	public static String generateTypeFilter() {
		String filter = "<div class=\"container\">"
				+ "<div id=\"options\">\r\n"
				+ "Filter by Type: <select id=\"reimbursementType\">"
				+ "<option id=\"0\">Show all</option>";
		for(Type t: tService.getAll()) {
			filter += "<option id=\"" + t.getId() + "\">" + t.getType() + "</option>";
		}
		filter += "</select>";
		return filter;
		
	}

	/* As a manager, I want to see ALL requests in table format */
	public static String generateTable() {
		String table = "<table class=\"table\" id=\"allReimbursements\">\r\n" + 
				"			<thead>\r\n" + 
				"				<tr>\r\n" + 
				"					<th>AMOUNT</th>\r\n" + 
				"					<th>DATE SUBMITTED</th>\r\n" + 
				"					<th>DATE RESOLVED</th>\r\n" + 
				"					<th>DESCRIPTION</th>\r\n" + 
				"					<th>REQUEST AUTHOR</th>\r\n" + 
				"					<th>RESOLVER</th>\r\n"+
				"					<th>STATUS</th>\r\n" + 
				"					<th>REQUEST TYPE</th>\r\n" + 
				"				</tr>\r\n" + 
				"			</thead>\r\n" +
				"           <tbody>";
		List<Reimbursement> reimbs = rService.getAll();
		for (Reimbursement r: reimbs) {
			int idOfReimb = r.getId();
			if (r.getStatusId() == 1) { //pending 
				table += "<tr class=\"pending\">";
			} else if (r.getStatusId() == 2) //approve
				table += "<tr class=\"approved\">";
			else {
				table += "<tr class=\"denied\">";
			}
			String[] columns = r.toString().split("[|]");  //columns is an array of delimited String entries of each reimbursement
			/* 
			 * 0 - REIMBURSEMENT ID
			 * 1 - AMOUNT
			 * 2 - DATE SUBMITTED
			 * 3 - DATE RESOLVED
			 * 4 - DESCRIPTION
			 *   - RECEIPT
			 * 5 - AUTHOR
			 * 6 - RESOLVER
			 * 7 - STATUS ID
			 * 8 - TYPE ID
			 * 
			 */
			String amount = columns[1];
			String submitted = columns[2];
			String resolved = columns[3].equals("0") ? "" : columns[3];
			String description = columns[4].equals("0") ? "" : columns[4];
			String author = uService.getNameById(Integer.parseInt(columns[5]));
			String resolver = columns[6].equals("0") ? "" : uService.getNameById(Integer.parseInt(columns[6]));
			String status = rService.getStatus(Integer.parseInt(columns[7]));
			String type = tService.getById(Integer.parseInt(columns[8]));
			table += "<td>$" +  amount + "</td><td>" + submitted + "</td><td>" + resolved + "</td><td>" + description + 
					"</td><td>" + author + "</td><td>" + resolver + "</td><td class=\"updateStatus\" id=\""+ idOfReimb + "\">" + status + 
					"</td><td>" + type + "</td>";
			table += "</tr>";
		}
		table += "</tbody></table>";
		return table;
	}
	
	public static String generateModal() {
		return  "<div class=\"modal fade\" id=\"myModal\" role=\"dialog\">\r\n" + 
				"		<div class=\"modal-dialog\">\r\n" + 
				"\r\n" + 
				"			<!-- Modal content-->\r\n" + 
				"			<div class=\"modal-content\">\r\n" + 
				"				<div class=\"modal-header\">\r\n" + 
				"					<h5> Accept or deny reimbursement </h5>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"modal-body\">\r\n" + 
				"					<p>To update request status, please select <b>approve</b> or <b>deny</b> on request.</p>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"modal-footer\">\r\n" + 
				"					<button id=\"approveButton\" type=\"button\" class=\"btn btn-success\" data-dismiss=\"modal\">APPROVE</button>\r\n" + 
				"					<button id=\"denyButton\" type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">DENY</button>\r\n" + 
				"					<button id=\"closeButton\" type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</div>";
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User u = (User) session.getAttribute("user");
		PrintWriter out = resp.getWriter();
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = br.readLine();
		String trimmedJson = json.substring(1, json.length()-1);
		String[] params = trimmedJson.split(",");
		int reimbId = Integer.parseInt(params[0]);
		int newStatus = Integer.parseInt(params[1]);
		int resolverId = u.getId();
		rService.modifyStatus(reimbId, resolverId, newStatus);
		resp.setContentType("text/html");
		out.write(generateTypeFilter() +  generateTable() + generateModal());
		
		}
}
