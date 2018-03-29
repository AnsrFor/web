package z2k.org.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;
import util.DBUtil;
@WebServlet(name="LoginServlet",urlPatterns= {"/loginServlet"})
public class LoginServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String logName = req.getParameter("logName");
		String logPwd = req.getParameter("logPwd");
		User user = DBUtil.login(logName, logPwd);
		if(user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user",user);//只有登录成功后，才设置该sesison属性
			req.getRequestDispatcher("/transaction/welcome.jsp").forward(req, resp);
		}else {
			req.setAttribute("msg", "用户名或密码错误");
			req.getRequestDispatcher("/transaction/fail.jsp").forward(req, resp);
		}
	}
}
