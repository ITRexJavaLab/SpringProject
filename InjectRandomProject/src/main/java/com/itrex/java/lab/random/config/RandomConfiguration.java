package com.itrex.java.lab.random.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.itrex.java.lab.random")
@PropertySource("classpath:application.properties")
public class RandomConfiguration {

}
