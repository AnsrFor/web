package com.z2k.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    private static String DRIVERCLASS = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/javaweb?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
    private static String USERNAME = "root";
    private static String PASSWORD = "076249";

    public static Connection getConnection(){
        try {
            Class.forName(DRIVERCLASS);
            Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
