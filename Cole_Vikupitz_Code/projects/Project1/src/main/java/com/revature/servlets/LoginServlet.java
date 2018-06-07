package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;
import com.revature.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader br = new BufferedReader(
				new InputStreamReader(request.getInputStream()));

		String json = "";
		json = br.readLine();

		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(json, User.class);

		User temp = UserService.authenticate(user.getEmail(), user.getPassword());
		HttpSession session = request.getSession();
		session.setAttribute("user", temp);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		String outJSON = mapper.writeValueAsString(temp);
		out.write(outJSON);
	}

}
