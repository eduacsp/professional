package com.eduacsp.cv.config;


import java.util.Properties;

import javax.servlet.Filter;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.eduacsp.cv.util.MyFilter;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eduacsp.cv.controller","com.eduacsp.cv.service","com.eduacsp.cv.config","com.eduacsp.cv.modelo"})
@EnableJpaRepositories(basePackages = {"com.eduacsp.cv.repository"}, entityManagerFactoryRef = "emf")
@PropertySource(value = { "classpath:application.properties" })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class Application extends SpringBootServletInitializer {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/eduacspcom");
		dataSource.setUsername("root");
		dataSource.setPassword("Augusto1977");
		return dataSource;
	}

	@Bean(name = "transactionManager")
	public JpaTransactionManager jpaTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return transactionManager;
	}

	@Bean(name = "emf")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan("com.eduacsp.cv.modelo");
		entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());

		return entityManagerFactoryBean;
	}

	private HibernateJpaVendorAdapter vendorAdaptor() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		return vendorAdapter;
	}

	private Properties jpaHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.max_fetch_depth", env.getProperty("hibernate.max_fetch_depth"));
		properties.put("hibernate.jdbc.fetch_size", env.getProperty("hibernate.jdbc.fetch_size"));
		properties.put("hibernate.jdbc.batch_size", env.getProperty("hibernate.jdbc.batch_size"));
		properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.put("hibernate.hbm2ddl.auto", "validate");
		return properties;
	}

	@Bean
	public FilterRegistrationBean someFilterRegistration() {
	    FilterRegistrationBean registration = new FilterRegistrationBean();
	    registration.setFilter(someFilter());
	    registration.addUrlPatterns("/*");
	    //registration.addInitParameter("paramName", "paramValue");
	    registration.setName("myFilter");
	    registration.setOrder(1);
	    return registration;
	} 

	@Bean(name = "myFilter")
	public Filter someFilter() {
	    return new MyFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
