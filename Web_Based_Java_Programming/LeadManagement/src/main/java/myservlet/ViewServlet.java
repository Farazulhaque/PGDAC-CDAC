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

import dao.DbService;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {

			ResultSet rs = DbService.fetchData();
			out.print("<table border=1>");
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
				out.println("<td>" + rs.getString(1) + "</td>");
				out.println("<td>" + rs.getString(2) + "</td>");
				out.println("<td>" + rs.getString(3) + "</td>");
				out.println("<td>" + rs.getString(4) + "</td>");
				out.println("<td><a href=RemoveStudent?id=" + rs.getInt(1) + "&name=" + rs.getString(1)
						+ ">Delete </a></td>");
				out.println("</tr");
			}
			out.print("</table>");
		} catch (SQLException e) {
			out.println("Error");
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
