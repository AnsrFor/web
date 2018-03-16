package org.yamaijia.com;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Statement stmt = null;
		ResultSet rs = null;
		String path = "jdbc:mysql://localhost:3306/mydb";
		Connection conn = DBUtil.getDBConnection(path);
		String username = req.getParameter("uname");
		String pass = req.getParameter("upwd");
		try {
			stmt = conn.createStatement();//创建操作对象
			String sql = "select u_name,u_pass from user";
			rs = stmt.executeQuery(sql);//执行查询SQL，返回结果集
			while(rs.next()) {
				String uname = rs.getString("u_name");
				String upass = rs.getString("u_pass");
				if(username.equals(uname) && pass.equals(upass)) {
					req.getRequestDispatcher("/hello/welcome1.html").forward(req,resp);
				}else {
					req.getRequestDispatcher("/hello/fail1.html").forward(req, resp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
}


