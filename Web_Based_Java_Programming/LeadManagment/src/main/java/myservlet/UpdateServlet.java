package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
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
		// TODO Auto-generated method stub
		// doGet(request, response);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession hs = request.getSession(false);
		int eid = Integer.parseInt((String) hs.getAttribute("employeeid"));
		// int eid = Integer.parseInt(request.getParameter("uid"));
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		int i = DbService.updateInfo(eid, name, pass);
		if (i > 0) {
			out.println("Data is updated");
			RequestDispatcher rd = request.getRequestDispatcher("ViewAllStudentServlet");
			rd.include(request, response);
		} else {
			out.println("Update Failed");
		}

	}

}
