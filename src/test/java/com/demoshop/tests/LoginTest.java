package com.demoshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginPositiveTest(){
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("n1ln2@gm.com").setPassword("123123"));
        clickOnLoginButton();
        Assert.assertTrue(isLinkLogOutPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest(){
        clickOnLoginLink();
        fillLoginForm(new User().setPassword("123123"));
        clickOnLoginButton();
        Assert.assertTrue(isTextValidationErrorsPresent());
    }

}
