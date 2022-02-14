package com.eunjy.stockid.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.eunjy.stockid.StockidApplication;
import com.eunjy.stockid.interceptor.LoginInterceptor;

/**
 * @author YunJi
 * WebMvcConfigurer
 */
// LoginInterceptor 클래스를 빈(Bean)으로 등록하기
@Configuration
// @ComponentScan(basePackageClasses = StockidApplication.class)
public class MvcConfig implements WebMvcConfigurer {

	@Autowired
	LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/**/*.do")
		.excludePathPatterns("/css/*", "/image/*", "/js/*", "/swagger-ui/*");
	}
	
	
}
