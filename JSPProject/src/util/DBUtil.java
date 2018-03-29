package util;

import java.sql.*;

import pojo.User;

public class DBUtil {
	static {
		try {
			//�������ݿ���������
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
	
	//ע�᷽��
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
				count = ps.executeUpdate();//ִ�в�����䣬����Ӱ������
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
	
	//��¼����
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
				rs = ps.executeQuery();//��ѯ�����ؽ����
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
