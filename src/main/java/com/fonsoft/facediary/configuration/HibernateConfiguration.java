package com.fonsoft.facediary.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:application.properties")
public class HibernateConfiguration {
    private final Environment environment;

    public HibernateConfiguration(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.fonsoft.facediary.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driverClassName"));
        dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
        dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
        dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        addPropertiesWithMessage(properties, "spring.jpa.database-platform");
//        addPropertiesWithMessage(properties, "hibernate.format_sql");
//        addPropertiesWithMessage(properties, "hibernate.show_sql");
//        addPropertiesWithMessage(properties, "hibernate.hbm2ddl.auto");
//        addPropertiesWithMessage(properties, "hibernate.hbm2ddl.import_files");

        return properties;
    }


    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

    private void addPropertiesWithMessage(Properties properties, String messageKey) {
        properties.put(messageKey, environment.getRequiredProperty(messageKey));
    }
}