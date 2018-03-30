package application;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
//监听Web容器状态的监听器
public class ContextStateListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		String contextPath = sce.getServletContext().getContextPath();
		System.out.println("容器启动了...，上下文路径是：" + contextPath);
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		String contextPath = sce.getServletContext().getContextPath();
		System.out.println("容器销毁了...，上下文路径是：" + contextPath);
	}

}
