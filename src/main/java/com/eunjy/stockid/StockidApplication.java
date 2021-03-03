package com.eunjy.stockid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.eunjy.stockid.config.SiteMeshConfig;

@SpringBootApplication
public class StockidApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockidApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<SiteMeshConfig> siteMeshFilter() { 
		FilterRegistrationBean<SiteMeshConfig> filter = new FilterRegistrationBean<SiteMeshConfig>(); 
		filter.setFilter(new SiteMeshConfig()); 
		return filter; 
	}

}
