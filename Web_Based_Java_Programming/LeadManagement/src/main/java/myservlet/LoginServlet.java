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

import dao.DbService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("uname");
		String password = request.getParameter("upass");

		boolean valid = DbService.validateData(name, password);
		if (valid) {
			try {
				ResultSet rs = DbService.showData(name, password);
				out.print("<table border=2 cellspacing=0 cellpadding=2>");
				out.print("<caption>====================Student Details=====================</caption>");
				out.println("<tr>");
				out.println("<th> Roll No </th>");
				out.println("<th> Student Name </th>");
				out.println("<th> Student Password </th>");
				out.println("<th> Student Department </th>");
				out.println("<th> Student Status </th>");
				out.println("</tr");
				while (rs.next()) {
					out.println("<tr>");
					out.println("<td>" + rs.getInt(1) + "</td>");
					out.println("<td>" + rs.getString(2) + "</td>");
					out.println("<td>" + rs.getString(3) + "</td>");
					out.println("<td>" + rs.getString(4) + "</td>");
					out.println("<td>" + rs.getString(5) + "</td>");
					out.println("<td><a href=RemoveStudent?id=" + rs.getInt(1) + ">Delete </a></td>");
					out.println("<td><a href=ViewStudentDetails?uname=" + rs.getString(2) + "&upass=" + rs.getString(3)
							+ ">Update </a></td>");
					out.println("</tr");
				}
				out.print("</table>");

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
