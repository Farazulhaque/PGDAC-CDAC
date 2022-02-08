package myservlet;

import java.io.IOException;
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
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fullname = request.getParameter("fname");
		String username = request.getParameter("txtUser");
		String passwd = request.getParameter("txtPass");
		String stateid = request.getParameter("ddlState");
		String cityid = request.getParameter("ddlCity");
		if (fullname == "" || username == "" || passwd == "" || stateid == "-1" || cityid == "-1") {
			RequestDispatcher rd = request.getRequestDispatcher("CascadeDropDown.jsp");
			rd.include(request, response);
		} else {
			String query = "insert into user_details values('" + fullname + "', '" + username + "', '" + passwd + "', "
					+ stateid + "," + cityid + ")";
			IDbService service = DbFactory.getDbService();
			try {
				service.excecuteNonQuery(query);
				HttpSession hs = request.getSession();
				// setting values in session object
				hs.setAttribute("msg", "User Registered Successfully");
				RequestDispatcher rd = request.getRequestDispatcher("CascadeDropDown.jsp");
				rd.include(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
