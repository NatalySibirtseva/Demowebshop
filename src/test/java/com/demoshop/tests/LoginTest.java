package com.demoshop.tests;

import com.demoshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void precondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void loginPositiveTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail("n1ln2@gm.com").setPassword("123123"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isLinkLogOutPresent());
    }

    @Test
    public void loginNegativeWithoutEmailTest(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setPassword("123123"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isTextValidationErrorsPresent());
    }

}
