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

import dao.DbFactory;
import dao.IDbService;

/**
 * Servlet implementation class DisplayData
 */
@WebServlet("/DisplayData")
public class DisplayData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
//		out.println("hello");
//		System.out.println("hello");
		String query = "select ud.fullname, ud.username, sm.state_name, cm.city_name "
				+ "from user_details ud inner join state_master sm on ud.state_id=sm.state_id "
				+ "inner join city_master cm on ud.city_id=cm.city_id";

		IDbService service = DbFactory.getDbService();
		try {
			ResultSet rs = service.fetchData(query);
			out.println("<table align=center width=70% border=1>");
			out.println("<tr><th>Full Name</th>");
			out.println("<th>User Name</th>");
			out.println("<th>State Name</th>");
			out.println("<th>City Name</th></tr>");
			while (rs.next()) {
				out.println("<tr><td>" + rs.getString(1) + "</td>");
				out.println("<td>" + rs.getString(2) + "</td>");
				out.println("<td>" + rs.getString(3) + "</td>");
				out.println("<td>" + rs.getString(4) + "</td></tr>");
			}
			out.println("</table>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
