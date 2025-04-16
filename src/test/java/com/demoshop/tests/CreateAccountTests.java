package com.demoshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void newUserRegistrationPositiveTest() {
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        clickOnRegistrationLink();
        fillRegistrationForm(new User().setFistName("Name11").setLastName("LastName11").setEmail("n1ln2" + i + "@gm.com").setPassword("123123").setConfirmPassword("123123"));
        clickOnRegistrationButton();
        Assert.assertTrue(isLinkLogOutPresent());
        Assert.assertTrue(isTextRegistrationCompletedPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        clickOnRegistrationLink();
        fillRegistrationForm(new User().setFistName("Name11").setLastName("LastName11").setEmail("n1ln2@gm.com").setPassword("123123").setConfirmPassword("123123"));
        clickOnRegistrationButton();
        Assert.assertTrue(isTextEmailExistsPresent());
    }

}
