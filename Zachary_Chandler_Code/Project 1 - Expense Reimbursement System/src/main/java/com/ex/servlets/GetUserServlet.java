package com.ex.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.ex.pojo.User;

@WebServlet("/getUser")
public class GetUserServlet extends HttpServlet {

	private static final long serialVersionUID = -4823108446754096214L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		User u = (User) req.getSession().getAttribute("user");
		resp.getWriter().write(u != null ? new JSONObject(u).toString() : "null");
	}

}
