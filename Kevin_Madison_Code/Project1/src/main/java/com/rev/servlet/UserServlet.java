package com.rev.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.rev.pojo.User;
import com.rev.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(loadOnStartup = 1, urlPatterns = { "/users", "/users/*" })
public class UserServlet extends HttpServlet {

	private static Logger logger = Logger.getLogger(UserServlet.class);
	static UserService service = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// based on url, /users = getAll, /users/? --> ? = id
		logger.info("--/USERS DO GET--");

		String path = req.getServletPath();
		if (path.equals("/users") || path.equals("/users/")) {
			logger.info("--get all--");
			List<User> users = service.getAll();
			if (users != null) {
				resp.setHeader("Content-Type", "application/json");
				resp.setStatus(HttpServletResponse.SC_OK);
				resp.getWriter().write(new ObjectMapper().writeValueAsString(users));
				return;
			} else {
				logger.warn("--No Content Found--");
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
		} else {
			int id = Integer.parseInt(path.substring(7));
			logger.info("ID:" + id);
			User u = service.getById(id);
			if (u != null) {
				resp.setHeader("Content-Type", "application/json");
				resp.setStatus(HttpServletResponse.SC_OK);
				resp.getWriter().write(new ObjectMapper().writeValueAsString(u));
				return;
			} else {
				logger.warn("--No Content Found--");
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Stream<String> text = req.getReader().lines();
		String json = text.collect(Collectors.joining("")).toString();

		logger.debug(json);
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(json, User.class);
		logger.info("POST - user " + u.toString());

		u = service.addUser(u.getUsername(), u.getPassword(), u.getFirstname(), u.getLastname(), u.getEmail(), u.getUserRoleId());

		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");

		String outJSON = mapper.writeValueAsString(u);
		out.write(outJSON);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Stream<String> text = req.getReader().lines();
		String json = text.collect(Collectors.joining("")).toString();
		ObjectMapper mapper = new ObjectMapper();
		User u = mapper.readValue(json, User.class);
		u = service.updateUser(u);
		logger.info(u.toString());

		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");

		String outJSON = mapper.writeValueAsString(u);
		out.write(outJSON);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// delete user
	}

}
