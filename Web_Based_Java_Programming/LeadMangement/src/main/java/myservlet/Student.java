package myservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Student")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String query="insert into student values("+request.getParameter("sid")+","
				+ "'"+request.getParameter("sname")+"',"
						+ "'"+request.getParameter("spass")+"',"
								+ "'"+request.getParameter("sdept")+"',0,"
										+ "'"+request.getParameter("type")+"')";
	   dao.IDbService service=dao.DbFactory.getDbService();
	   try {
		if( service.excecuteNonQuery(query)>0) {
			
			//response.getWriter().println("Sign Up successfully");
			response.sendRedirect("index.html");
			   
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
