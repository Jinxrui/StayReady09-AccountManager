package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

    BankAccount acc;

    @Before
    public void initialize(){
        acc = new BankAccount();
    }

    @Test
    public void setAccountNumberTest(){
        acc.setAccountNumber(1234);
        Assert.assertEquals(1234, acc.getAccountNumber());
    }

    @Test
    public void getFeesTest(){
    Assert.assertEquals(0.0, acc.getFees(), .2);
    }

    @Test
    public void setFeesTest(){
        acc.setFees(400.00);
        Assert.assertEquals(400.00, acc.getFees(), .2);
    }

    @Test
    public void getBalanceTest(){
        Assert.assertEquals(0.0, acc.getBalance(), .2);
    }

    @Test
    public void depositTest(){
        acc.deposit(100);
        Assert.assertEquals(100.0, acc.getBalance(), .2);
    }

    @Test
    public void withdrawTest(){
        acc.withdraw(100);
        Assert.assertEquals(-100.0, acc.getBalance(), .2);
    }

    @Test
    public void getPasswordTest(){
        Assert.assertEquals(0, acc.getPassword());
    }

    @Test
    public void setPasswordTest(){
        acc.setPassword(1234);
        Assert.assertEquals(1234, acc.getPassword());
    }

    @Test
    public void lockedTest(){
        Assert.assertEquals(true, acc.locked());
    }

    @Test
    public void toStringTest(){
        String exp = String.format("Account Number: %d\nBalance: %.2f", acc.getAccountNumber(), acc.getBalance());
        Assert.assertEquals(exp, acc.toString());
    }
}
