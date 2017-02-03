package com.eduacsp.cv.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class MyFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request,
			ServletResponse response, FilterChain chain)
					throws IOException, ServletException {

		//BlackListIP blackListIP = new BlackListIP();

		HttpServletRequest requestHttp = (HttpServletRequest) request;
		
		//String ipAddress = request.getRemoteAddr();

		System.out.println("ipAddress:"+GetIP.getIP(requestHttp));

		try {
			//if(blackListIP.isIPBlocked(ipAddress)){
			chain.doFilter(request, response);
			//}else{
			//	request.setAttribute("errorMessage", "You're unable to see this page!");
			//	request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
			//}
		} catch (Exception ex) {
			request.setAttribute("errorMessage", ex);
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		}

	}

}