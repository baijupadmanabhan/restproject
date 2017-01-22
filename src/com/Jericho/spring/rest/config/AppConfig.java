package com.Jericho.spring.rest.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.Jericho.spring.rest.dao.CompanyDao;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.Jericho.spring.rest")

public class AppConfig {
	@Autowired 
	DataSource dataSource;
	
	@Bean
	@Autowired
    public DataSource dataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        DataSource dataSource = dsLookup.getDataSource("jdbc/CompanyDB");
        return dataSource;
    } 

	@Bean
	public CompanyDao CompanyDao() throws NamingException {
	    JndiTemplate jndiTemplate = new JndiTemplate();
	    DataSource dataSource
	            = (DataSource) jndiTemplate.lookup("java:comp/env/jdbc/CompanyDB");
	    return new CompanyDao(dataSource);
	}
	
}
