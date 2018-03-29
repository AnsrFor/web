package z2k.org;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("HelloFIlter��ʼ����...");
		String admin = filterConfig.getInitParameter("admin");
		System.out.println("���յ����ݸ�HelloServlet�������ĳ�ʼ��������" + admin);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("����HelloServlet��doFilter������...");
		chain.doFilter(request, response);
		System.out.println("׼���뿪HelloFilter��doFilter������...");
	}

	@Override
	public void destroy() {
		System.out.println("HelloFilter��������...");
	}

}
