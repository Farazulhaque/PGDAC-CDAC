package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloForm
 */
@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public HelloForm() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");

		// Enumeration<String> pnames = request.getAttributeNames();
		// while (pnames.hasMoreElements()) {
		// String params = pnames.nextElement();
		// out.println("Parameter values " + request.getParameter(params));
		// }

		// Creating cookie
		Cookie ncookie = new Cookie("username", name);
		Cookie pcookie = new Cookie("password", pass);

		// set expiry date after 12 hours
		ncookie.setMaxAge(60 * 60 * 12);

		pcookie.setMaxAge(60 * 60 * 12);

		// adding cookie in response
		response.addCookie(ncookie);
		response.addCookie(pcookie);
		String title = "Setting cookie";
		out.println("<html> <head> <title> " + title + "</title>");
		out.println("<link rel=stylesheet href=./style.css type=text/css>");
		out.println("</head><body bgcolor=\"#ff9988\">");
		out.println("<h1> Hello </h1>");
		out.println("<ul>");
		out.println("<li>" + name + "</li>");
		out.println("<li>" + pass + "</li>");
		out.println("</ul>");

		out.println("</body>");
		out.println("</html>");

	}

}
