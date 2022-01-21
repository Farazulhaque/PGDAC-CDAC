package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbService;

/**
 * Servlet implementation class Welcome
 */

public class Welcome extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		// stream to write the data

		String user = request.getParameter("uname");
		// getParameter(param name) it return string object
		String password = request.getParameter("upass");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Welcome to SERVLET  </h1> ");
		out.println("<h2> Welcome User" + user + "</h2>");
		out.println("<h2> Password is" + password + "</h2>");
		out.println("</body> ");
		out.println("</html> ");
		try {
			ResultSet rs = DbService.validate(user, password);
			if (rs.next()) {
				// http session creation
				HttpSession hs = request.getSession();
				// setting values in session object
				hs.setAttribute("name", user);
				hs.setAttribute("pass", password);
				RequestDispatcher rd = request.getRequestDispatcher("ViewAllStudentServlet");
				rd.forward(request, response);
			} else {
				// response.sendRedirect("index.html");
				RequestDispatcher rd = request.getRequestDispatcher("");
				request.setAttribute("msg", "invaid user name or password");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			System.err.println("exception in fetching in valid servlet" + e);
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
