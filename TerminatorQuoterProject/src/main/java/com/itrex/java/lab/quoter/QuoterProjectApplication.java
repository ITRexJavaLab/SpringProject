package com.itrex.java.lab.quoter;

import com.itrex.java.lab.quoter.annotation.Quoter2;
import com.itrex.java.lab.quoter.config.QuoterConfiguration;
import com.itrex.java.lab.quoter.javaconf.Quoter3;
import com.itrex.java.lab.quoter.javaconfprop.Quoter4;
import com.itrex.java.lab.quoter.xml.Quoter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuoterProjectApplication {

    public static void main(String[] args) {
        xmlConfig();
        annotationConfig();
        javaConfig();
        javaConfigProperties();
    }

    public static void xmlConfig() {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(Quoter.class).sayQuote();
    }

    public static void annotationConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.itrex.java.lab.quoter.annotation");
        context.getBean(Quoter2.class).sayQuote();
    }

    public static void javaConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(QuoterConfiguration.class);
        context.getBean(Quoter3.class).sayQuote();
    }

    public static void javaConfigProperties() {
        ApplicationContext context = new AnnotationConfigApplicationContext(QuoterConfiguration.class);
        context.getBean(Quoter4.class).sayQuote();
    }
}


