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
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try {

			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			HttpSession hs = request.getSession(false);
			if (hs != null) {
				// getting value from session object
				String uname = (String) hs.getAttribute("name");
				String upass = (String) hs.getAttribute("pass");
				out.println("Session id is " + hs.getId());
				ResultSet rs = DbService.fetchProfile(uname, upass);
				out.print("<table border=2 cellspacing=0 cellpadding=2>");
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

				out.println("</body>");
				out.println("</html>");

			}

		} catch (SQLException e) {
			System.err.println("SQL Exception in profile");
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
