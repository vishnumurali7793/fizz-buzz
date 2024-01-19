package com.app.fizbuzz.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.app.fizbuzz.config.entities.RequestDetails;
import com.app.fizbuzz.config.service.RequestDetailsService;

@Component
public class RequestHandlerInterceptor implements HandlerInterceptor {

	@Autowired
	RequestDetailsService requestDetailsService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		try {
			RequestDetails requestDetails = new RequestDetails();
			requestDetails.setRemoteIp(request.getRemoteAddr());
			requestDetails.setRequestMethod(request.getMethod());
			requestDetails.setRequestUri(request.getRequestURI());
			return requestDetailsService.saveRequestDetails(requestDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
