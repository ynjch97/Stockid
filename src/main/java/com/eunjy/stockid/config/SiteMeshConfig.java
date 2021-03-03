package com.eunjy.stockid.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SiteMeshConfig extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration (SiteMeshFilterBuilder builder) {
		builder
		// Map decorators to path patterns.
		.addDecoratorPath("/login", "/WEB-INF/views/decorator/emptyLayout.jsp")
		.addDecoratorPath("/*", "/WEB-INF/views/decorator/defaultLayout.jsp") 
		// Exclude path from decoration. 
		.addExcludedPath("/html/*") 
		.addExcludedPath(".json") 
		.setMimeTypes("text/html");
	}
	
}
