package application;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
//����Web����״̬�ļ�����
public class ContextStateListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String contextPath = sce.getServletContext().getContextPath();
		System.out.println("����������...��������·���ǣ�" + contextPath);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		String contextPath = sce.getServletContext().getContextPath();
		System.out.println("����������...��������·���ǣ�" + contextPath);
	}

}
