package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BusinessAccountTest {
    BusinessAccount acc;

    @Before
    public void initialize(){
        acc = new BusinessAccount();
    }

    @Test
    public void getCompanyTest(){
        Assert.assertEquals("", acc.getCompany());
    }
    @Test
    public void setCompanyTest(){
        acc.setCompany("Martha Corporation");
        Assert.assertEquals("Martha Corporation", acc.getCompany());
    }
    @Test
    public void setTaxIdTest(){
        acc.setTaxID(30);
        Assert.assertEquals(30, acc.getTaxID());
    }
}
