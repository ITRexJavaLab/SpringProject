package com.itrex.java.lab.random;

import com.itrex.java.lab.random.config.RandomConfiguration;
import com.itrex.java.lab.random.service.Quoter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectRandomApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RandomConfiguration.class);
        context.getBean(Quoter.class).sayQuote();
    }
}


