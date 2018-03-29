package util;

import java.sql.*;

import pojo.User;

public class DBUtil {
	static {
		try {
			//加载数据库驱动程序
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","076249");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//注册方法
	public static int register(String regName,String regPwd) {
		int count = 0;
		Connection conn = getConnection();
		PreparedStatement ps = null;
		if(conn != null) {
			String sql = "insert into user(name,pass)values(?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1,regName);
				ps.setString(2,regPwd);
				count = ps.executeUpdate();//执行插入语句，返回影响行数
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.cancel();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return count;
	}
	
	//登录方法
	public static User login(String logName,String logPwd) {
		User user = null;
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		if(conn != null) {
			String sql = "select u_id,name,pass from user where name=? and pass=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1,logName);
				ps.setString(2,logPwd);
				rs = ps.executeQuery();//查询，返回结果集
				if(rs.next()) {
					int id = rs.getInt("u_id");
					String name = rs.getString("name");
					String pass = rs.getString("pass");
					user = new User(id,name,pass);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					ps.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}
}
