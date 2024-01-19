package com.app.fizbuzz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class RequestHandlerInterceptorAppConfig implements WebMvcConfigurer {
	@Autowired
	RequestHandlerInterceptor requestHandlerInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestHandlerInterceptor);
	}

}
