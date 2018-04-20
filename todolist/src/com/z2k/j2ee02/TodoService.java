package com.z2k.j2ee02;

import com.z2k.util.Util;

import java.sql.*;
import java.util.*;

public class TodoService {
    public boolean save(Integer id,String content){
        PreparedStatement ps = null;
        Connection conn = Util.getConnection();
        String sql = "insert into todo(id,content) values(?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setString(2,content);
            boolean result = ps.execute();
            if(!conn.getAutoCommit()){
                conn.commit();
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if(ps != null){ps.close();}
                if(conn != null) {conn.close();}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Map<String,Object>> list(){
        Connection conn = Util.getConnection();
        List<Map<String,Object>> result  = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select id,content from todo order by id asc";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                Map amap = new HashMap();
                amap.put("id",rs.getInt("id"));
                amap.put("content",rs.getString("content"));
                result.add(amap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
               if(rs != null) {rs.close();}
               if(ps != null) {ps.close();}
               if(conn != null) {conn.close();}
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
