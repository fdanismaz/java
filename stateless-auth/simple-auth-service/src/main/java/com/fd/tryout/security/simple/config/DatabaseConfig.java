package com.fd.tryout.security.simple.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.beans.PropertyVetoException;
import java.util.Properties;

/**
 * @author fdanismaz
 * date: 10/7/18 1:59 PM
 */
@Configuration
@PropertySource("database.properties")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "${hibernate.repositories_scan}")
public class DatabaseConfig {

    @Autowired
    private Environment environment;

    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(this.environment.getProperty("hibernate.driver"));
        dataSource.setJdbcUrl(this.environment.getProperty("hibernate.db_url"));
        dataSource.setUser(this.environment.getProperty("hibernate.db_user"));
        dataSource.setPassword(this.environment.getProperty("hibernate.db_password"));

        // C3P0 Connection Pool Settings
        dataSource.setAcquireIncrement(Integer.parseInt(this.environment.getProperty("hibernate.c3p0.acquire_increment")));
        dataSource.setInitialPoolSize(Integer.parseInt(this.environment.getProperty("hibernate.c3p0.initialPoolSize")));
        dataSource.setMinPoolSize(Integer.parseInt(this.environment.getProperty("hibernate.c3p0.minPoolSize")));
        dataSource.setMaxPoolSize(Integer.parseInt(this.environment.getProperty("hibernate.c3p0.maxPoolSize")));
        dataSource.setMaxIdleTime(Integer.parseInt(this.environment.getProperty("hibernate.c3p0.maxIdleTime")));
        dataSource.setIdleConnectionTestPeriod(Integer.parseInt(this.environment.getProperty("hibernate.c3p0.idleConnectionTestPeriod")));
        dataSource.setMaxStatements(Integer.parseInt(this.environment.getProperty("hibernate.c3p0.maxStatements")));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(this.environment.getProperty("hibernate.entities_scan"));
        factory.setDataSource(this.dataSource());
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factory.setJpaProperties(this.hibernateProperties());

        return factory;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public JpaTransactionManager transactionManager() throws PropertyVetoException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(this.entityManagerFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", this.environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", this.environment.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", this.environment.getProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", this.environment.getProperty("hibernate.hbm2ddl_auto"));
        return properties;
    }
}
