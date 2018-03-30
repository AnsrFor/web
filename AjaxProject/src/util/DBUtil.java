package util;

import java.sql.*;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	private static ComboPooledDataSource ds;
	static {
		ds = new ComboPooledDataSource();
	}
	
	//����Ƿ���ڴ�ע����
	public static boolean checkRegisterName(String regName) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();//��ȡ���ݿ�����
			String sql = "select * from user where name=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,regName);
			rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;//����Ѿ����ڴ��û�������falg��Ϊtrue
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
