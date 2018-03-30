package session;

import java.util.*;

import javax.servlet.http.HttpSession;

public class MySessionUtil {
    private static Map<String,HttpSession> map=new HashMap<String,HttpSession>();  // 用来装session的
    
    public static void addSession(HttpSession session){
    	map.put(session.getId(),session);
    }
    
    // 通过sessionid查询session
    public static HttpSession getSessionById(String sessionId){
    	return map.get(sessionId);
    }
    
    
}
