package com.lm.app;

// Import necessary libraries
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication

@EnableAutoConfiguration(exclude = { //  
        DataSourceAutoConfiguration.class, // Exclude the default data source auto-configuration
        DataSourceTransactionManagerAutoConfiguration.class, // Exclude the default transaction manager auto-configuration
        HibernateJpaAutoConfiguration.class }) // Exclude the default Hibernate JPA auto-configuration

public class LorganMauserSalesApplication {
	
    // Autowired Environment to get property values from application.properties file
    @Autowired
    private Environment env;

    // Main method that boots up the application
	public static void main(String[] args) {
		SpringApplication.run(LorganMauserSalesApplication.class, args);
	}
	
	// Define a Bean for DataSource, which can be reused wherever a DataSource is required
	@Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
 
        // Set properties for the DataSource from application.properties file
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
 
        // Logging to console for debugging purpose
        System.out.println("## getDataSource: " + dataSource);
 
        return dataSource;
    }
 
    // Autowired SessionFactory Bean that takes DataSource as an argument
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
        Properties properties = new Properties();
 
        // Set Hibernate properties from application.properties file
        properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        properties.put("current_session_context_class", //
                env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
 
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
 
        // Specify the package containing entity classes
        factoryBean.setPackagesToScan(new String[] { "" });
        factoryBean.setDataSource(dataSource);
        factoryBean.setHibernateProperties(properties);
        factoryBean.afterPropertiesSet();
        
        // Get the SessionFactory object
        SessionFactory sf = factoryBean.getObject();

        // Logging to console for debugging purpose
        System.out.println("## getSessionFactory: " + sf);
        return sf;
    }
 
    // Autowired TransactionManager Bean that takes SessionFactory as an argument
    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
 
        return transactionManager;
    }
}
