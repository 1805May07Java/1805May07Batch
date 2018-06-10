package ers.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import ers.pojos.User;
import ers.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	static UserService service = new UserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

		String json = br.readLine();

		//2. instantiate object mapper 
		ObjectMapper mapper = new ObjectMapper();

		//3. convert json string to object
		User u = mapper.readValue(json, User.class);
		
		u = service.login(u.getUsername(), u.getPassword());
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		
		String outJSON = mapper.writeValueAsString(u);
		out.write(outJSON);
		if (u != null) { 
			HttpSession session = req.getSession();
			session.setAttribute("user", u);		
		}
	}
}
