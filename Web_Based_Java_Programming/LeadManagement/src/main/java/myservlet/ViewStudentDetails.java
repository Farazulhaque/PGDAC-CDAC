package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbService;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/ViewStudentDetails")
public class ViewStudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// String name = request.getParameter("uname");
		// String password = request.getParameter("upass");

		HttpSession hs = request.getSession(false);
		String name = (String) hs.getAttribute("uname");
		String password = (String) hs.getAttribute("upass");

		boolean valid = DbService.validateData(name, password);
		if (valid) {
			try {
				ResultSet rs = DbService.showData(name, password);
				out.print("<fieldset>");
				while (rs.next()) {
					out.print("<form action=UpdateStudent>");
					out.print("Roll No: ");
					out.print("<input type=number name=sroll value=" + rs.getInt(1) + " readonly>");
					out.print("<br>Name: ");
					out.println("<input type=text name=sname value=" + rs.getString(2) + ">");
					out.print("<br>Password: ");
					out.println("<input type=text name=spass value=" + rs.getString(3) + ">");
					out.print("<br>Department: ");
					out.println("<input type=text name=sdept value=" + rs.getString(4) + ">");
					out.print("<br>Status: ");
					out.println("<input type=text name=status value=" + rs.getString(5) + ">");
					out.print("<br><br>");

					out.println("<input type=submit value=Update>");
					out.print("</form>");

				}
				out.print("</fieldset>");

			} catch (SQLException e) {
				out.println("Error");
			}
		} else {
			response.sendRedirect("login.html");
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
