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
		PrintWriter out = response.getWriter();
		String fullname = (String) request.getParameter("fullname") + "%";
		String username = (String) request.getParameter("username") + "%";
		String state = (String) request.getParameter("state") + "%";
		String city = (String) request.getParameter("city") + "%";
		// System.out.println("hello");
		// System.out.println(fullname);

		String query = "select ud.fullname, ud.username, sm.state_name, cm.city_name "
				+ "from user_details ud inner join state_master sm on ud.state_id=sm.state_id "
				+ "inner join city_master cm on ud.city_id=cm.city_id where ud.fullname like '" + fullname
				+ "' and ud.username like '" + username + "' and sm.state_name like '" + state
				+ "' and cm.city_name like '" + city + "'";
		
		// To show nothing when user entered nothing
		if (fullname.equals("%") && username.equals("%") && state.equals("%") && city.equals("%")) {
			query = "select ud.fullname, ud.username, sm.state_name, cm.city_name "
					+ "from user_details ud inner join state_master sm on ud.state_id=sm.state_id "
					+ "inner join city_master cm on ud.city_id=cm.city_id where 1!=1";
		}
		System.out.println(query);

		IDbService service = DbFactory.getDbService();
		try {
			ResultSet rs = service.fetchData(query);
			StringBuilder sb = new StringBuilder();
			while (rs.next()) {
				sb.append("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
						+ "</td><td>" + rs.getString(4) + "</td></tr>");
			}
			out.println(sb.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
