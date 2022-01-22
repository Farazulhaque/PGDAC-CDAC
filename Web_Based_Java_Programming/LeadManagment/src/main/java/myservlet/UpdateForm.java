package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateForm
 */
@WebServlet("/UpdateForm")
public class UpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession hs = request.getSession();
		if (!hs.isNew() && hs != null) {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			String eid = request.getParameter("id");
			String name = request.getParameter("name");
			hs.setAttribute("employeeid", eid);

			out.println("<html>");
			out.println("<body>");
			out.println("<form action=UpdateServlet method=post>");
			// out.println("<input type =text name=uid value=" + eid + " hidden > <br>");
			out.println("<input type =text name=uname placeholder=Name value=" + name + "> <br>");
			out.println("<input type =password name=upass placeholder=Passwrd> <br>");
			out.println("<input type =submit value=Update > <br>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		} else {
			response.sendRedirect("index.html");
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
