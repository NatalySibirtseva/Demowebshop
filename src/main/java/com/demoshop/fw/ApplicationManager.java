package com.demoshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ApplicationManager {

    WebDriver driver;

    UserHelper user;

    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UserHelper getUser() {
        return user;
    }
}
