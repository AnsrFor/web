package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;
@WebServlet(name="CheckNameServlet",urlPatterns= {"/checkServlet"})
public class CheckNameServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("content-type","application/x-www-form-urlencoded");
		resp.setCharacterEncoding("utf-8");
		PrintWriter pw = resp.getWriter();
		String regName = req.getParameter("registerName");
		System.out.println("后台接收到的注册名为：" + regName);
		boolean flag = DBUtil.checkRegisterName(regName);
		if(flag) {
			pw.println("sorry！该用户名已被注册，请选择其他用户名！");
		}else {
			pw.println("恭喜！可以使用该用户名~~~");
		}
		pw.flush();
		pw.close();
	}
}
