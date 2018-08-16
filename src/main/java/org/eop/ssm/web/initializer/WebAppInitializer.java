package org.eop.ssm.web.initializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.eop.common.filter.RequestResponseLoggingFilter;
import org.eop.ssm.config.RootConfig;
import org.eop.ssm.web.config.WebConfig;
import org.eop.ssm.web.config.security.WebSecurityConfig;
import org.eop.ssm.web.env.EnvUtils;
import org.eop.ssm.web.rootac.initializer.ProfileApplicationContextInitializer;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



/**
 * @author lixinjie
 * @since 2017-08-08
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	static {
		EnvUtils.setLog4j2ConfigurationFileProgrammatic();
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class, WebSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
		DispatcherServlet dispatcherServlet = (DispatcherServlet)super.createDispatcherServlet(servletAppContext);
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		return dispatcherServlet;
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		RequestResponseLoggingFilter requestResponseLoggingFilter = new RequestResponseLoggingFilter();
		return new Filter[] {characterEncodingFilter, requestResponseLoggingFilter};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(null, 1024 * 1024 * 10, 1024 * 1024 * 100, 0));
	}
	
	@Override
	protected ApplicationContextInitializer<?>[] getRootApplicationContextInitializers() {
		return new ApplicationContextInitializer<?>[] {new ProfileApplicationContextInitializer()};
	}
}
