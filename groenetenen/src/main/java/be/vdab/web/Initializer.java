package be.vdab.web;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import be.vdab.aop.CreateAOPBeans;
import be.vdab.dao.CreateDAOBeans;
import be.vdab.datasource.CreateDataSourceBean;
import be.vdab.mail.CreateMailBeans;
import be.vdab.restclients.CreateRestClientBeans;
import be.vdab.restservices.CreateRestControllerBeans;
import be.vdab.security.CreateSecurityFilter;
import be.vdab.services.CreateServiceBeans;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {   
	@Override 
	protected String[] getServletMappings() {     
		return new String[] { "/" };   
	} 
  
	@Override 
	protected Class<?>[] getRootConfigClasses() {     
		return new Class<?>[] {CreateDataSourceBean.class, CreateDAOBeans.class, CreateServiceBeans.class, CreateRestClientBeans.class, CreateMailBeans.class
			,CreateSecurityFilter.class, CreateAOPBeans.class };
	} 
  
	@Override
	protected Class<?>[] getServletConfigClasses() {     
		return new Class<?>[] {CreateControllerBeans.class, CreateRestControllerBeans.class};   
	} 
    
	@Override
	protected Filter[] getServletFilters() {
	  return new Filter[] {new OpenEntityManagerInViewFilter()};
	} 
	/*@Override
	protected Filter[] getServletFilters() {     
		CharacterEncodingFilter utf8Filter = new CharacterEncodingFilter();     
		utf8Filter.setEncoding("UTF-8");     
		return new Filter[] { utf8Filter, new OpenEntityManagerInViewFilter() }; 
	} versie voor spring security*/
	
	@Override 
	protected void customizeRegistration(Dynamic registration) { // Dynamic uit package javax.servlet.ServletRegistration
	  registration.setInitParameter("dispatchOptionsRequest", "true"); //De-activate standard spring response for allowed requests
	} 
} 