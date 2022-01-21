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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			// get current session
			HttpSession hs = request.getSession(false);
			if (hs != null) {
				// getting value from session object
				String uname = (String) hs.getAttribute("name");
				String upass = (String) hs.getAttribute("pass");
				// getting session id
				out.println("Session Id is" + hs.getId());
				ResultSet rs = DbService.fetchProfile(uname, upass);
				out.println("<table>");

				while (rs.next()) {
					out.println("<tr>");
					out.println("<td>" + rs.getInt(1) + "</td>");
					out.println("<td>" + rs.getString(2) + "</td>");
					out.println("<td>" + rs.getString(3) + "</td>");
					out.println("<td>" + rs.getString(4) + "</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("</body> ");
				out.println("</html> ");
			}
		} catch (SQLException e) {
			System.err.println("sql exception in profie" + e);
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
