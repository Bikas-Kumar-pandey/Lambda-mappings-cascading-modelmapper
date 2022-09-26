//package com.list.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//@Configuration
////@PropertySource("classpath:properties/Student/${spring.profiles.active}/datasource.properties")
//@EnableTransactionManagement
//
//@EnableJpaRepositories(entityManagerFactoryRef = "studentEntityManagerFactory", basePackages = {
//        "com.list.multiDbConfig.repo" },transactionManagerRef = "studentTransactionManager")
//public class StudentConfig {
//
//    @Bean(name = "studentDataSource")
//    @ConfigurationProperties(prefix = "student.datasourece1")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//    @Bean(name = "studentEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
//                                                                           @Qualifier("studentDataSource") DataSource dataSource) {
//        return builder.dataSource(dataSource).packages("com.list.multiDbConfig.entity").build();
//    }
//
//    @Bean("studentTransactionManager")
//    public PlatformTransactionManager transactionManager(@Autowired @Qualifier("studentEntityManagerFactory") EntityManagerFactory entityManagerFactory){
//        return new JpaTransactionManager(entityManagerFactory);
//}
//
//}
