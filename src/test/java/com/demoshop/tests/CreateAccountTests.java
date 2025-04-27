package com.demoshop.tests;

import com.demoshop.data.UserData;
import com.demoshop.models.User;
import com.demoshop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        if(!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void newUserRegistrationPositiveTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User().setFistName(UserData.FIRSTNAME).setLastName(UserData.LASTNAME).setEmail(UserData.NEWREGESTRATIONEMAIL).setPassword(UserData.PASSWORD).setConfirmPassword(UserData.CONFIRMPASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isLinkLogOutPresent());
        Assert.assertTrue(app.getUser().isTextRegistrationCompletedPresent());
    }



    @Test(dataProvider = "addNewUserWithCsv", dataProviderClass = DataProviders.class)
    public void newUserRegistrationPositiveFromDataProviderWithCsvFileTest(User user) {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isLinkLogOutPresent());
        Assert.assertTrue(app.getUser().isTextRegistrationCompletedPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User().setFistName(UserData.FIRSTNAME).setLastName(UserData.LASTNAME).setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD).setConfirmPassword(UserData.CONFIRMPASSWORD));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isTextEmailExistsPresent());
    }

}
