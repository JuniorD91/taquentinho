package com.indra.taquentinho.util.configuration;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class ServletContextConfigurator implements ServletContextInitializer {

	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
        servletContext.setInitParameter("primefaces.THEME", "bootstrap");
    }
}
