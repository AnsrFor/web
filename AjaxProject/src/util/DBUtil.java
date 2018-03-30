package util;

import java.sql.*;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	private static ComboPooledDataSource ds;
	static {
		ds = new ComboPooledDataSource();
	}
	
	//检查是否存在此注册名
	public static boolean checkRegisterName(String regName) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();//获取数据库连接
			String sql = "select * from user where name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,regName);
			rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;//如果已经存在此用户名，则将falg设为true
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
		return flag;
	}
}
