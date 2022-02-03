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

@WebServlet(asyncSupported = true, urlPatterns = { "/ViewStudent" })
public class ViewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get current session
		HttpSession hs=	request.getSession(false);
		if(hs!=null) {
			//fetching all students data from database
			String qry="select * from student";
			dao.IDbService service=dao.DbFactory.getDbService();
			response.setContentType("text/html");
			//to clear cache
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.	       
			PrintWriter out= response.getWriter();
			StringBuilder sb=new StringBuilder();
			//sb.append("<link href="+request.getContextPath()+"/css/mycss.css type=text/css rel=stylesheet />");
			sb.append("<body><table align=center width=70% border=1>");
			sb.append("<tr><td colspan=5>Welcome:<b>"+hs.getAttribute("name")+" <a href='LogOut'> Logout</a></b></td>");
			sb.append("<td><a href='SaveStudent.html'>Add New Studnet</a></td></tr>");
			sb.append("<tr><td>ID</td><td>Name</td>");
			sb.append("<td>Password</td><td>Department</td>");
			sb.append("<td>Status</td><td>Type</td></tr>");
			try {
				ResultSet rs=service.fetchData(qry);				
				while(rs.next()) {
					sb.append("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td>");
					sb.append("<td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td>");
					sb.append("<td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");
				}
				sb.append("</body><table>");				
			} catch (SQLException e) {				
				e.printStackTrace();
			}		
			out.println(sb.toString());		
		}
		else
		{
			response.sendRedirect("login.html");
		}
      	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
