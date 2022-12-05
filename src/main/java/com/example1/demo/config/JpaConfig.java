package com.example1.demo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {

//    @Bean
//    public DataSource getDataSource()
//    {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.postgresql.Driver");
//        dataSourceBuilder.url("jdbc:postgresql://localhost:5431/start-up");
//        dataSourceBuilder.username("postgres");
//        dataSourceBuilder.password("postgres");
//        return dataSourceBuilder.build();
//    }
}
