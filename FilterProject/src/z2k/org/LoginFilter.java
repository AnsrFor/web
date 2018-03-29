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
		System.out.println("LoginFilter��ʼ����...");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("����LoginFilter��doFilter����...");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		if(session.getAttribute("user") != null) {//���session���Է�Χ��user����Ϊ�գ���˵���Ѿ���¼
			chain.doFilter(request, response);
		}else {
			request.setAttribute("msg","����δ��¼�����ȵ�¼��");
			request.getRequestDispatcher("/login/login.jsp").forward(request,response);
		}
		System.out.println("��Ҫ�뿪LoginFilter��doFilter����...");
	}

	@Override
	public void destroy() {
		
	}
}
