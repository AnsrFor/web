package z2k.org;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("LoginFilter初始化了...");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("进入LoginFilter的doFilter方法...");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if(session.getAttribute("user") != null) {//如果session属性范围的user对象不为空，则说明已经登录
			chain.doFilter(request, response);
		}else {
			request.setAttribute("msg","您还未登录，请先登录！");
			request.getRequestDispatcher("/login/login.jsp").forward(request,response);
		}
		System.out.println("将要离开LoginFilter的doFilter方法...");
	}

	@Override
	public void destroy() {
		
	}
}
