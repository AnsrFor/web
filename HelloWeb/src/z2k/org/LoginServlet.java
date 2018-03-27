package z2k.org;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("username");
		String upass = req.getParameter("pwd");
		if("tom".equals(uname) && "123456".equals(upass)) {
			req.getRequestDispatcher("/hello/welcome.html").forward(req, resp);
		}else {
			req.getRequestDispatcher("/hello/fail.html").forward(req, resp);
		}
	}
}
