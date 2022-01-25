package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbService;

/**
 * Servlet implementation class ValidateSevlet
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
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
		String user = request.getParameter("user");
		String password = request.getParameter("pass");
		boolean check = request.getParameter("rememberme") != null;
		ResultSet rs = DbService.validate(user, password);
		try {
			if (rs.next()) {
				if (check == true) {
					// Set cookie only when remember me checkbox is checked
					// store name and password in cookie objects so that
					// if the user again login within 12 hours then
					// username and password is already filled in input boxes
					Cookie name = new Cookie("username", user);
					Cookie pass = new Cookie("password", password);
					// set max age for 12 hours
					name.setMaxAge(60 * 60 * 12);
					pass.setMaxAge(60 * 60 * 12);
					response.addCookie(name);
					response.addCookie(pass);
				}
				response.sendRedirect("ViewStudent.jsp");
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				request.setAttribute("msg", "Invalid username or password");
				rd.forward(request, response);
			}
		} catch (SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}

	}

}
