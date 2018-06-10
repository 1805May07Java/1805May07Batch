package ers.server;

import java.io.IOException;
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
import ers.pojos.User;
import ers.service.ReimbursementService;
import ers.service.TypeService;
import ers.service.UserService;

@WebServlet("/ViewRequestsEmp")
public class ViewRequestEmpServlet extends HttpServlet{
	static ReimbursementService rService = new ReimbursementService();
	static UserService uService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		PrintWriter out = resp.getWriter();
		Enumeration<String> s = session.getAttributeNames();
		String s1 = s.nextElement();
		User u = (User) session.getAttribute("user");
		resp.setContentType("text/html");
		out.write(generateTable(u.getId()));

	}

	public static String generateTable(int userId) {
		String table = "<table class=\"table\">\r\n" + 
				"			<thead>\r\n" + 
				"				<tr>\r\n" + 
				"					<th>AMOUNT</th>\r\n" + 
				"					<th>DATE SUBMITTED</th>\r\n" + 
				"					<th>DATE RESOLVED</th>\r\n" + 
				"					<th>DESCRIPTION</th>\r\n" + 
				"					<th>MANAGER</th>\r\n" + 
				"					<th>STATUS</th>\r\n" + 
				"					<th>REQUEST TYPE</th>\r\n" + 
				"				</tr>\r\n" + 
				"			</thead>\r\n";
		List<Reimbursement> reimbs = rService.getAllById(userId);
		for (Reimbursement r: reimbs) {
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
			String resolver = columns[6].equals("0") ? "" : uService.getNameById(Integer.parseInt(columns[6]));
			String statusId = rService.getStatus(Integer.parseInt(columns[7]));
			String typeId = new TypeService().getById(Integer.parseInt(columns[8]));

			table += "<td>$" +  amount + "</td><td>" + submitted + "</td><td>" + resolved + "</td><td>" + description + 
					"</td><td>" + resolver + "</td><td>" + statusId + "</td><td>" + typeId + "</td>";
			table += "</tr>";
		}
		table += "</table>";
		return table;
	}

}
