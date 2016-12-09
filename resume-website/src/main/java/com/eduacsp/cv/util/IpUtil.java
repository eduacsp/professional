package com.eduacsp.cv.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;

public class IpUtil {

	public static String getUserAgent(HttpServletRequest request){
		return request.getHeader("User-Agent");
	}

	public static String getReferer(HttpServletRequest request){
		return request.getHeader(HttpHeaders.REFERER);
	}

	public static String getIpAddr(HttpServletRequest request) {      
		String ipAddress = request.getRemoteAddr();  
		//if (ipAddress == null) {  
		//	ipAddress = request.getRemoteAddr();  
		//}   
		return ipAddress;      
	} 

}
