package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("uid"));
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		String dept = request.getParameter("udept");
		int i = DbService.updateInfo(id, name, pass, dept);
		if (i > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("ViewStudent.jsp");
			String info = "Data successfully updated for id=" + id;
			request.setAttribute("msg", info);
			rd.forward(request, response);
		} else {
			out.println("Update Failed");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			String info = "Data updation failed for id=" + id;
			request.setAttribute("msg", info);
			rd.forward(request, response);
		}
	}

}
