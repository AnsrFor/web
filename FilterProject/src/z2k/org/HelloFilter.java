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
		System.out.println("HelloFIlter初始化了...");
		String admin = filterConfig.getInitParameter("admin");
		System.out.println("接收到传递给HelloServlet过滤器的初始化参数：" + admin);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("进入HelloServlet的doFilter方法了...");
		chain.doFilter(request, response);
		System.out.println("准备离开HelloFilter的doFilter方法了...");
	}

	@Override
	public void destroy() {
		System.out.println("HelloFilter被销毁了...");
	}

}
