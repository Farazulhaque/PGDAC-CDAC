package myservlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DbFactory;
import dao.IDbService;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("sid");
		String pass=request.getParameter("spass");
		System.out.println("sid: "+sid);
		//System.out.println("pwd: "+pass);
		IDbService service=DbFactory.getDbService();
		
		try {
		//authenticate student
		ResultSet rs=service.fetchData("Select id,name from student where id="+sid+" and password='"+pass+"'");
				
			if(rs.next()) {
			    System.out.println("Authenticated");
			    //create session and store data in session
				HttpSession hs=	request.getSession();
				hs.setAttribute("id", rs.getString(1));
				hs.setAttribute("name", rs.getString(2));
				//response.sendRedirect("ViewStudent");
			}
			else
			{
				response.setContentType("text/html");
				response.getWriter().println("Invalid Username/Password");
			}
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}	
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
