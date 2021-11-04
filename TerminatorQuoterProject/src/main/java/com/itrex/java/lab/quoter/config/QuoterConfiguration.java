package com.itrex.java.lab.quoter.config;

import com.itrex.java.lab.quoter.javaconf.Quoter3;
import com.itrex.java.lab.quoter.javaconf.TerminatorQuoter3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.itrex.java.lab.quoter")
@PropertySource("classpath:application.properties")
public class QuoterConfiguration {
    @Bean
    public Quoter3 quoter() {
        TerminatorQuoter3 quoter = new TerminatorQuoter3();
        quoter.setMessage("I'll be back3");
        return quoter;
    }
}
