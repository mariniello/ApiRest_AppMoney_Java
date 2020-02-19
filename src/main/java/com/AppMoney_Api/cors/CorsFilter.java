package com.AppMoney_Api.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.AppMoney_Api.config.property.AppMoneyApiProperty;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter{
	
	@Autowired
	private AppMoneyApiProperty appMoneyApiProperty;

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		
        
        if ("OPTIONS".equals(request.getMethod())) {
        	response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
        	response.setHeader("Access-Control-Allow-Headers", 
        			"Authorization, Access-Control-Allow-Headers, Origin,Accept, "
        					+ "X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
        	response.setHeader("Access-Control-Max-Age", "3600");
        	
        	
        	
            response.setStatus(HttpServletResponse.SC_OK);
          } else {
            chain.doFilter(req, resp);
          }
        
        
//		if ("OPTIONS".equals(request.getMethod()) && appMoneyApiProperty.getOriginPermitida().equals(request.getHeader("Origin"))) {
//			
//			response.setStatus(HttpServletResponse.SC_OK);
//		} else {
//			chain.doFilter(req, resp);
//		}
		
	}

	@Override
	public void destroy() {
		
	}
	
	public void ini(FilterConfig arg0) throws ServletException{
		
	}
	
}
