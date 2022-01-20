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
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int sid = Integer.parseInt(request.getParameter("sroll").trim());
		String uname = request.getParameter("sname");
		String upass = request.getParameter("spass");
		String dept = request.getParameter("sdept");
		int status = Integer.parseInt(request.getParameter("status").trim());

		// HttpSession hs = request.getSession(false);
		// hs.setAttribute("sid",
		// Integer.parseInt(request.getParameter("sroll").trim()));
		// hs.setAttribute("uname", request.getParameter("sname"));
		// hs.setAttribute("upass", request.getParameter("spass"));
		// hs.setAttribute("dept", request.getParameter("sdept"));
		// hs.setAttribute("status",
		// Integer.parseInt(request.getParameter("status").trim()));

		int i = DbService.updateData(sid, uname, upass, dept, status);
		if (i > 0) {
			out.println("Data Updated Successfully");
			try {
				ResultSet rs = DbService.showData(uname, upass);
				out.print("<fieldset>");
				while (rs.next()) {
					out.print("<form action=UpdateStudent>");
					out.print("Roll No: ");
					out.print("<input type=number name=sroll value=" + rs.getInt(1) + " readonly>");
					out.print("<br>Name: ");
					out.println("<input type=text name=sname value=" + rs.getString(2) + ">");
					out.print("<br>Password: ");
					out.println("<input type=text name=spass value=" + rs.getString(3) + ">");
					out.print("<br>Department: ");
					out.println("<input type=text name=sdept value=" + rs.getString(4) + ">");
					out.print("<br>Status: ");
					out.println("<input type=text name=status value=" + rs.getString(5) + ">");
					out.print("<br><br>");

					out.println("<input type=submit value=Update>");
					out.println("<a href=LoginServlet>Go To Login</a>");
					out.print("</form>");

				}
				out.print("</fieldset>");

			} catch (SQLException e) {
				out.println("Error");
			}

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
