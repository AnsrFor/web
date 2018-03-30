package session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SessionStateListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
	   HttpSession session=se.getSession();
	  // session.setMaxInactiveInterval(30);
	   MySessionUtil.addSession(session);   // 将新创建的session添加到工具类的Map集合中
       String sessionid=session.getId(); 	
       System.out.println("新的session创建了，sessionID是："+sessionid);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		String sessionid=se.getSession().getId(); 	
	    System.out.println("session销毁了，sessionID是："+sessionid);
	}

}
