package z2k.org.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;
@WebServlet(name="RegisterServlet",urlPatterns={"/registerServlet"})
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String regName = req.getParameter("regName");
		String regPwd  = req.getParameter("regPwd");
		int count = DBUtil.register(regName, regPwd);
		if(count > 0) {
			//重定向到登录页面
			resp.sendRedirect("/JSPProject/transaction/login.jsp");
		}
	}
}
