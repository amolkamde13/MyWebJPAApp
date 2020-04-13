//package com.amonicks.demo.db;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//
//@PropertySource(value = {"classpath:application.properties"})
//@Configuration
//public class HibernateConfig {
//	@Value("${db.driver}")
//	private String DRIVER;
// 
//	@Value("${db.password}")
//	private String PASSWORD;
// 
//	@Value("${db.url}")
//	private String URL;
// 
//	@Value("${db.username}")
//	private String USERNAME;
// 
//	@Value("${hibernate.dialect}")
//	private String DIALECT;
// 
//	@Value("${hibernate.show_sql}")
//	private String SHOW_SQL;
// 
//	@Value("${hibernate.hbm2ddl.auto}")
//	private String HBM2DDL_AUTO;
// 
//	@Value("${entitymanager.packagesToScan}")
//	private String PACKAGES_TO_SCAN;
//	
//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(DRIVER);
//		dataSource.setUrl(URL);
//		dataSource.setUsername(USERNAME);
//		dataSource.setPassword(PASSWORD);
//		System.out.println("DataSource "+dataSource);
//		return dataSource;
//	}
// 
//	private Properties hibernateProperties() {
//		Properties hibernateProperties = new Properties();
//		hibernateProperties.put("hibernate.dialect", DIALECT);
//		hibernateProperties.put("hibernate.show_sql", SHOW_SQL);
//		hibernateProperties.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
//		return hibernateProperties;
//	}
//	
//	@Bean
//	public LocalSessionFactoryBean sessionFactory() {
//		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource());
//		sessionFactory.setPackagesToScan(PACKAGES_TO_SCAN);
//		
//		sessionFactory.setHibernateProperties(hibernateProperties());
//		System.out.println("Session Factory "+sessionFactory);
//		return sessionFactory;
//	}
// 
//	@Bean
//	@Autowired
//	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//		transactionManager.setSessionFactory(sessionFactory);
//		System.out.println("Transaction "+transactionManager);
//		return transactionManager;
//	}
//}
