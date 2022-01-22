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
 * Servlet implementation class SecondProfile
 */
@WebServlet("/SecondProfile")
public class SecondProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie c[] = request.getCookies();
		if (c != null) {
			// for (Cookie cookie : c) {
			// String cookiename = cookie.getName();
			// String domain = cookie.getDomain();
			//// boolean secure = cookie.getSecure();
			// out.println("cookie name" + cookiename);
			// out.println("domain is " + domain);
			// }
			String name = c[0].getValue();
			if (name != null || !name.equals("")) {
				out.println("Welcome user " + name);
			}
		} else {
			response.sendRedirect("home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
