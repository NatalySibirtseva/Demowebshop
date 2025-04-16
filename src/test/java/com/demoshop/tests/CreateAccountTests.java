package com.demoshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test
    public void newUserRegistrationPositiveTest() {

        int i = (int)((System.currentTimeMillis()/1000)%3600);

        click(By.cssSelector("[href='/register']"));

        type(By.name("FirstName"), "Name11");

        type(By.name("LastName"), "LastName11");

        type(By.name("Email"), "n1ln2"+i+"@gm.com");

        type(By.name("Password"), "123123");

        type(By.name("ConfirmPassword"), "123123");

        click(By.name("register-button"));

        Assert.assertTrue(isElementPresent(By.xpath("//a[@class='ico-logout']")));
        Assert.assertTrue(isElementPresent(By.xpath("//div[contains(text(),'Your registration completed')]")));

    }

    @Test
    public void existedUserRegistrationNegativeTest() {

        click(By.cssSelector("[href='/register']"));

        type(By.name("FirstName"), "Name11");

        type(By.name("LastName"), "LastName11");

        type(By.name("Email"), "n1ln2@gm.com");

        type(By.name("Password"), "123123");

        type(By.name("ConfirmPassword"), "123123");

        click(By.name("register-button"));

        Assert.assertTrue(isElementPresent(By.xpath("//li[text() = 'The specified email already exists']")));

    }

}
