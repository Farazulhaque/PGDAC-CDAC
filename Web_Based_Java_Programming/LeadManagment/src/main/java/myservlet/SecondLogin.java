package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondLogin
 */
@WebServlet("/SecondLogin")
public class SecondLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String name = "faraz";
		String pass = "1234";
		PrintWriter out = response.getWriter();
		String user = request.getParameter("uname");
		// getParameter(param name) it return string object
		String password = request.getParameter("upass");
		if (user.equals(name) && pass.equals(password)) {
			out.println("Successfull Login");
			// Creating cookie
			Cookie cookie = new Cookie("name", user);
			cookie.setDomain("www.cdac.com");
			cookie.setHttpOnly(true);
			// cookie.setMaxAge(0);

			// Sending cookie in response
			response.addCookie(cookie);
		} else {
			out.println("Invalid usrname or password");
		}
	}

}
