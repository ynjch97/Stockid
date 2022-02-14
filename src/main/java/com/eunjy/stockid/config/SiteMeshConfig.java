package com.eunjy.stockid.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SiteMeshConfig extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration (SiteMeshFilterBuilder builder) {
		builder
		// Map decorators to path patterns.
		.addDecoratorPath("/", "/WEB-INF/views/decorator/loginLayout.jsp")
		.addDecoratorPath("/login/*.do", "/WEB-INF/views/decorator/loginLayout.jsp")
		.addDecoratorPath("/user/*.do", "/WEB-INF/views/decorator/loginLayout.jsp")
		.addDecoratorPath("/grp/*.do", "/WEB-INF/views/decorator/loginLayout.jsp")
		.addDecoratorPath("/*/*.do", "/WEB-INF/views/decorator/defaultLayout.jsp") 
		// Exclude path from decoration. 
		.addExcludedPath("/html/*") 
		.addExcludedPath(".json") 
		.addExcludedPath("/swagger-ui/*") 
		.setMimeTypes("text/html");
	}
	
}
