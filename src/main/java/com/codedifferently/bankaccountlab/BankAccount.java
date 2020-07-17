package com.codedifferently.bankaccountlab;

public class BankAccount {

     protected int accountNumber;
     protected double fees;
     protected double balance;
     private int password;
     protected boolean locked;

     public BankAccount(){
        accountNumber = (int) (8888 *Math.random()+1000);
        fees = 0;
        balance = 0;
        password = 0;
        locked = true;
     }
     public int getAccountNumber(){
         return accountNumber;
     }

    public void setAccountNumber(int ac){
         accountNumber = ac;
    }

    public double getFees(){
        return fees;
    }

    public void setFees(double f){
        fees += f;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double b){
             balance += b;
    }

    public void withdraw(double b){
        if(balance >= b) {
            balance -= b;
        }
    }

    public int getPassword(){
        return password;
    }

    public void setPassword(int p){
        password = p;
    }

    public boolean locked(){
         return locked;
    }
    public void lock(){
         locked = true;
    }
    public void unlock(){
        locked = false;
    }
    public void payFees(double p){
         if(balance >= p) {
             fees -= p;
         }
    }

    public String toString(){
         return String.format("Account Number: %d\nBalance: %.2f", getAccountNumber(), getBalance());
    }
}
