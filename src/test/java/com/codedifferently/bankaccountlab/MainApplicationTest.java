package com.codedifferently.bankaccountlab;

import org.junit.Assert;
import org.junit.Test;

public class MainApplicationTest {

    @Test
    public void selectAccountTest(){
        Assert.assertEquals(null, MainApplication.selectAccount());
    }

    @Test
    public void safeLock(){
        Assert.assertEquals(false, MainApplication.selectAccount());
    }
}
