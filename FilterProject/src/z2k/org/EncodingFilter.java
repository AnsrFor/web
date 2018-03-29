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
		System.out.println("EncodingFilter��ʼ����...");
		this.encode = filterConfig.getInitParameter("encode");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("����EncodingFilter��doFilter...");
		request.setCharacterEncoding(encode);//�����������
		chain.doFilter(request, response);//���´�������
		System.out.println("��Ҫ�뿪EncdingFilter��doFilter...");
	}

	@Override
	public void destroy() {
		System.out.println("EncodingFiler��������...");
	}

}
