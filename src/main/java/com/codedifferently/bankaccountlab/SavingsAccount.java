package com.codedifferently.bankaccountlab;

public class SavingsAccount extends BankAccount{

    private double rate;
    private String name;

    public SavingsAccount(){
        super();
        name = "";
        rate = 10 * Math.random() + 1;
    }

    public double getRate(){
        return rate;
    }

    public void setRate(double r){
        rate = r;
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }

}
