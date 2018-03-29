package z2k.org;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

	private String encode;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("EncodingFilter初始化了...");
		this.encode = filterConfig.getInitParameter("encode");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("进入EncodingFilter的doFilter...");
		request.setCharacterEncoding(encode);//设置请求编码
		chain.doFilter(request, response);//向下传递请求
		System.out.println("将要离开EncdingFilter的doFilter...");
	}

	@Override
	public void destroy() {
		System.out.println("EncodingFiler被销毁了...");
	}

}
