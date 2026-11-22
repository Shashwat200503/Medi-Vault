package com.medivault.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MediVaultWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // Loads AppConfig: DataSource, Hibernate, Transactions
        return new Class<?>[]{ AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Loads WebConfig: Controllers, JSON converters, etc.
        return new Class<?>[]{ WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        // DispatcherServlet will handle everything under /api/
        return new String[]{ "/api/*" };
    }
}
