package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextDemoServlet
 */
@WebServlet("/ServletContextDemoServlet")
public class ServletContextDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// getting servlet context object
		ServletContext context = getServletContext();

		// getting value of Driver parameter from web.xml
		String drivername = context.getInitParameter("Driver");

		// setting value in context object
		context.setAttribute("portno", 3306);

		// getting all parameter names from web.xml
		Enumeration<String> parameternames = context.getInitParameterNames();

		out.println("<html>");
		out.println("<body>");
		out.println("<h4>" + drivername + "</h4>");

		while (parameternames.hasMoreElements()) {
			// getting parameter name from enumeration
			String name = parameternames.nextElement();
			out.println("<h4>" + name + "</h4>");
		}

		out.println("</body>");
		out.println("</html>");

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
