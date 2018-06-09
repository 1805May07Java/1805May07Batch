package reimburse.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NiceServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("REACHED THE GET METHOD");
		
//		Enumeration enumeration = req.getParameterNames();
//        while (enumeration.hasMoreElements()) {
//            String parameterName = (String) enumeration.nextElement();
//            System.out.println("Parameter = " + parameterName);
//        }
		
		String topicname = req.getParameter("topic");
		if(topicname != null) {
			res.setContentType("text/html");
			res.getWriter().write(generateJSONData(topicname));
		}
	}
	
	public String generateJSONData(String topicname) {
		StringBuffer returnData = null;
		
		if(topicname.equals("java")) {
			returnData = new StringBuffer("{\"topic\":{");
			returnData.append("\"name\": \"JAVA\", ");
			returnData.append("\"tutorial\": [");
			returnData.append("{\"name\": \"Introduction to java sockets\"},");
			returnData.append("{\"name\": \"Introduction to RMI\"},");
			returnData.append("{\"name\": \"equals method\"}]");
			returnData.append("}}");
		}
		else if(topicname.equals("oodp")) {
			returnData = new StringBuffer("{\"topic\":{");
			returnData.append("\"name\": \"oodp\", ");
			returnData.append("\"tutorial\": [");
			returnData.append("{\"name\": \"Factory\"},");
			returnData.append("{\"name\": \"Abstract\"},");
			returnData.append("{\"name\": \"singleton\"}]");
			returnData.append("}}");
		}
		else {
			returnData = new StringBuffer("{\"topic\":{");
			returnData.append("\"name\": \"topic: " + topicname + "\", ");
			returnData.append("\"tutorial\": [");
			returnData.append("{\"name\": \"No tutorials found\"}],");
			returnData.append("}}");
		}
		System.out.println("INSIDE generateJSONData(), ABOUT TO PRINT returnData");
		System.out.println(returnData);
		return returnData.toString();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("STARTING POST METHOD");
		String topicname = req.getParameter("topic");
		if(topicname != null) {
			res.setContentType("text/html");
			res.getWriter().write(generateJSONData(topicname));
		}
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started");
	}
	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped");
	}
}
