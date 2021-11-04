package com.itrex.java.lab.quoter.javaconf;

public class TerminatorQuoter3 implements Quoter3 {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        System.out.println(message);
    }
}
