package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	// public Welcome() {
	// // TODO Auto-generated constructor stub
	// }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		String u = "faraz";
		int pass = 1234;
		// getParameter always returns String object
		String user = request.getParameter("uname");
		String password = request.getParameter("upass").trim();
		int p = Integer.parseInt(password);
		// stream to write the data
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Welcome to SERVLET </h1>");
		out.println("<h2>");
		out.println("Welcome user " + user);
		out.println("Your Password is " + password);
		out.println("</h2>");
		out.println("</body>");
		out.println("</html>");
		if (u.equals(user) && (pass == p)) {
			RequestDispatcher rd = request.getRequestDispatcher("ProfileServlet");
			rd.include(request, response);
		} else
			response.sendRedirect("https://www.linkedin.com");
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
