package util;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DBUtil {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//获取数据库连接对象
	public static Connection getDBConnection(String url) {
		Properties pro = new Properties();
		InputStream input = null;
		Connection conn = null;
		try {
			input = DBUtil.class.getClassLoader().getResourceAsStream("db.Properties");
			pro.load(input);
			conn = DriverManager.getConnection(url,pro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
