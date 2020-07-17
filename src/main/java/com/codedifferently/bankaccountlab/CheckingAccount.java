package com.codedifferently.bankaccountlab;

public class CheckingAccount extends BankAccount{
    private String name;

    public CheckingAccount(){
        super();
        name = "";
    }

    public String getName(){
        return name;
    }

    public void setName(String n){
        name = n;
    }
}
