package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstServlet extends GenericServlet {
	public static int i;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		String param = "";
		ServletConfig cfg = getServletConfig();
		/*
		 * String user = cfg.getInitParameter("user");
		 * i=Integer.parseInt(cfg.getInitParameter("default"));
		 * System.out.println("servlet is intialiased"+i);
		 * System.out.println("default user name is"+user);
		 */
		Enumeration<String> e = cfg.getInitParameterNames();
		while (e.hasMoreElements()) {
			param = e.nextElement();
			System.out.println(param);
			System.out.println("VALUE FOR " + param + "=" + cfg.getInitParameter(param));
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		++i;
		out.println("service method is invoked" + i);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("servlet destroy...");

	}

}
