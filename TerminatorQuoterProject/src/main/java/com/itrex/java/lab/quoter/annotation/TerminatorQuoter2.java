package com.itrex.java.lab.quoter.annotation;

import org.springframework.stereotype.Component;

@Component
public class TerminatorQuoter2 implements Quoter2 {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
