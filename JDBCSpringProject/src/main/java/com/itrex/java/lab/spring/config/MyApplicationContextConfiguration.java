package com.itrex.java.lab.spring.config;

import org.h2.jdbcx.JdbcConnectionPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static com.itrex.java.lab.spring.properties.Properties.H2_PASSWORD;
import static com.itrex.java.lab.spring.properties.Properties.H2_URL;
import static com.itrex.java.lab.spring.properties.Properties.H2_USER;

@Configuration
@ComponentScan("com.itrex.java.lab.spring")
public class MyApplicationContextConfiguration {
    @Bean
    public DataSource dataSource() {
        return JdbcConnectionPool.create(H2_URL, H2_USER, H2_PASSWORD);
    }
}
