package com.itlize.joole.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;  

import com.itlize.joole.config.PersistenceJPAConfig;
import com.itlize.joole.config.WebMvcConfig;


public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { PersistenceJPAConfig.class, WebSecurityConfig.class };
	}
 
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}
 
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
 
}