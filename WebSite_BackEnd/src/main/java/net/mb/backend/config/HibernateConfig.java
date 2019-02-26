package net.mb.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages=("net.mb.backend.dto"))
@EnableTransactionManagement
public class HibernateConfig {
	private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/WebSite2";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "sa";
	private final static String DATABASE_PASSWORD = "";
	
	
	@Bean
	public DataSource getDataSource(){
		BasicDataSource dataSouce = new BasicDataSource();
		dataSouce.setDriverClassName(DATABASE_DRIVER);
		dataSouce.setUrl(DATABASE_URL);
		dataSouce.setUsername(DATABASE_USERNAME);
		dataSouce.setPassword(DATABASE_PASSWORD);
		
		return dataSouce;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dateSource){
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dateSource);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("net.mb.backend.dto");
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactiory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactiory);
		return transactionManager;
	}
}
