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
 * Servlet implementation class ReadCookie
 */
@WebServlet("/ReadCookie")
public class ReadCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie mycookie = null;
		Cookie[] mycookies = null;

		// get array of cookies
		mycookies = request.getCookies();
		out.println("<html>");
		out.println("<head><title>Reading Cookie</title></head>");
		out.println("<body>");
		if (mycookies != null) {
			out.println("<h4>Found cookies</h4>");
			for (int i = 0; i < mycookies.length; i++) {
				mycookie = mycookies[i];
				out.println("Name  : " + mycookie.getName());
				out.println("Value : " + mycookie.getValue());
			}
		} else {
			out.println("<h4> No cookies found</h4>");
		}
		out.println("</body>");
		out.println("</html>");
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
