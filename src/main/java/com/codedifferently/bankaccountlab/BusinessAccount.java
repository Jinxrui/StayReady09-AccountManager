package com.codedifferently.bankaccountlab;

public class BusinessAccount extends BankAccount{
    private int taxID;
    private String company;

    public BusinessAccount(){
        super();
        company = "";
        taxID = (int) (88888888 * Math.random() + 1000000000);
    }

    public int getTaxID(){
        return taxID;
    }

    public void setTaxID(int t){
        taxID = t;
    }

    public String getCompany(){
        return company;
    }

    public void setCompany(String c){
        company = c;
    }
}
