package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbService;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");

		// getParameter always returns String object
		String user = request.getParameter("uname");
		String password = request.getParameter("upass");
		// stream to write the data
		PrintWriter out = response.getWriter();
		try {
			ResultSet rs = DbService.showData(user, password);
			if (rs.next()) {
				// http session creation
				HttpSession hs = request.getSession();
				// setting values in session object
				hs.setAttribute("name", user);
				hs.setAttribute("pass", password);

				RequestDispatcher rd = request.getRequestDispatcher("ProfileServlet");
				rd.include(request, response);
			} else {
				// response.sendRedirect("https://www.linkedin.com");
				RequestDispatcher rd = request.getRequestDispatcher("/");
				request.setAttribute("msg", "invalid username or password");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			System.err.println("Error");
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
