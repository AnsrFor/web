package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="LoginServlet",urlPatterns= {"/loginServlet"})
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String logName = req.getParameter("loginName");
		String logPwd = req.getParameter("loginPwd");
		if("tom".equals(logName) && "123456".equals(logPwd)) {
			req.getSession().setAttribute("user",logName);
			req.getRequestDispatcher("/success/welcome.jsp").forward(req,resp);
		}else {
			req.getSession().setAttribute("msg","用户名或密码错误，请重新输入");
			req.getRequestDispatcher("/login/login.jsp").forward(req, resp);
		}
	}
}
