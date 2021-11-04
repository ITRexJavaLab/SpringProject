package com.itrex.java.lab.quoter.javaconfprop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TerminatorQuoter4 implements Quoter4 {

    @Value("${message}")
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
