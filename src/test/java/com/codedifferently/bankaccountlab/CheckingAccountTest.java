package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckingAccountTest {
    CheckingAccount acc;

    @Before
    public void initialize(){
        acc = new CheckingAccount();
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals("", acc.getName());
    }
    @Test
    public void setNameTest(){
        acc.setName("Bruce");
        Assert.assertEquals("Bruce", acc.getName());
    }
}
