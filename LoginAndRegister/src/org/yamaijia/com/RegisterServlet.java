package org.yamaijia.com;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBUtil;

public class RegisterServlet extends HttpServlet {
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
		String username = req.getParameter("rname");
		String userpass = req.getParameter("rpwd");
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		String path = "jdbc:mysql://localhost:3306/mydb";
		Connection conn = DBUtil.getDBConnection(path);
		try {
			String sql1 = "insert into user(u_name,u_pass)values(?,?)";
			String sql2 = "select u_name from user where u_name="+"'"+username+"'";
			stmt = conn.createStatement();//创建操作对象
			rs = stmt.executeQuery(sql2);
			if(rs.next()) {
				String uname = rs.getString("u_name");
				if(username.equals(uname)) {
					req.getRequestDispatcher("/hello/fail2.html").forward(req, resp);
				}
			}else {
				//将SQL发送到DBMS中，进行预编译，将预编译好的SQL语句存储在DBMS缓冲区中
				ps = conn.prepareStatement(sql1);
				ps.setString(1,username);
				ps.setString(2,userpass);
				ps.executeUpdate();
				req.getRequestDispatcher("/hello/welcome2.html").forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
