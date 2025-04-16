package com.demoshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    protected boolean isTextRegistrationCompletedPresent() {
        return isElementPresent(By.xpath("//div[contains(text(),'Your registration completed')]"));
    }

    protected boolean isLinkLogOutPresent() {
        return isElementPresent(By.xpath("//a[@class='ico-logout']"));
    }

    protected void fillRegistrationForm(User user) {
        type(By.name("FirstName"), user.getFistName());
        type(By.name("LastName"), user.getLastName());
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
        type(By.name("ConfirmPassword"), user.getConfirmPassword());
    }

    protected void clickOnRegistrationLink() {
        click(By.cssSelector("[href='/register']"));
    }

    protected boolean isTextEmailExistsPresent() {
        return isElementPresent(By.xpath("//li[text() = 'The specified email already exists']"));
    }

    protected void clickOnRegistrationButton() {
        click(By.name("register-button"));
    }

    protected void fillLoginForm(User user) {
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
    }

    protected void clickOnLoginButton() {
        click(By.cssSelector("input.login-button"));
    }

    protected void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    protected boolean isTextValidationErrorsPresent() {
        return isElementPresent(By.cssSelector("div.validation-summary-errors"));
    }
}
