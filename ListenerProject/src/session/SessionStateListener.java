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
	   MySessionUtil.addSession(session);   // ���´�����session��ӵ��������Map������
       String sessionid=session.getId(); 	
       System.out.println("�µ�session�����ˣ�sessionID�ǣ�"+sessionid);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		String sessionid=se.getSession().getId(); 	
	    System.out.println("session�����ˣ�sessionID�ǣ�"+sessionid);
	}

}
