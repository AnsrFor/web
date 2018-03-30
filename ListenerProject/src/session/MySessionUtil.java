package session;

import java.util.*;

import javax.servlet.http.HttpSession;

public class MySessionUtil {
    private static Map<String,HttpSession> map=new HashMap<String,HttpSession>();  // ����װsession��
    
    public static void addSession(HttpSession session){
    	map.put(session.getId(),session);
    }
    
    // ͨ��sessionid��ѯsession
    public static HttpSession getSessionById(String sessionId){
    	return map.get(sessionId);
    }
    
    
}
