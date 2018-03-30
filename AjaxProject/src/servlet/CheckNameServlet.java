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
		System.out.println("��̨���յ���ע����Ϊ��" + regName);
		boolean flag = DBUtil.checkRegisterName(regName);
		if(flag) {
			pw.println("sorry�����û����ѱ�ע�ᣬ��ѡ�������û�����");
		}else {
			pw.println("��ϲ������ʹ�ø��û���~~~");
		}
		pw.flush();
		pw.close();
	}
}
