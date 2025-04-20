package com.demoshop.tests;

import com.demoshop.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void newUserRegistrationPositiveTest() {
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User().setFistName("Name11").setLastName("LastName11").setEmail("n1ln2" + i + "@gm.com").setPassword("123123").setConfirmPassword("123123"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isLinkLogOutPresent());
        Assert.assertTrue(app.getUser().isTextRegistrationCompletedPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User().setFistName("Name11").setLastName("LastName11").setEmail("n1ln2@gm.com").setPassword("123123").setConfirmPassword("123123"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isTextEmailExistsPresent());
    }

}
