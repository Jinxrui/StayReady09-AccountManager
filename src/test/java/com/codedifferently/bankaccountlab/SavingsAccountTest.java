package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SavingsAccountTest {

    SavingsAccount acc;

    @Before
    public void initialize(){
        acc = new SavingsAccount();
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals("", acc.getName());
    }
    @Test
    public void setNameTest(){
        acc.setName("Clark");
        Assert.assertEquals("Clark", acc.getName());
    }
    @Test
    public void setRateTest(){
        acc.setRate(10.0);
        Assert.assertEquals(10.0, acc.getRate(), .1);
    }
}
