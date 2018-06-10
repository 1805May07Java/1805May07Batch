package ers.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ers.pojos.Reimbursement;
import ers.pojos.Type;
import ers.service.ReimbursementService;
import ers.service.TypeService;

@WebServlet("/loadSubmitRequest")
public class LoadSubmitRequestServlet extends HttpServlet {
	public static ReimbursementService rService = new ReimbursementService();
	public static TypeService tService = new TypeService();
	public ObjectMapper mapper = new ObjectMapper();
	
	/* Retreieves all of the reimbursement types, sends List out as a response */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Type> reimbs = tService.getAll();
		String s = mapper.writeValueAsString(reimbs);
		PrintWriter out = resp.getWriter();
		out.write(s);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String json = br.readLine();
		
		Reimbursement reimb = mapper.readValue(json, Reimbursement.class);
		System.out.println(reimb);
		rService.insertRequest(reimb);
	}

}
