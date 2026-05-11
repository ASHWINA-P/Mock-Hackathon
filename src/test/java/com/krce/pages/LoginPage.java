// LoginPage.java

package com.krce.pages;

import com.krce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    WebDriver driver;

    By myAccount = By.linkText("My Account");
    By login = By.linkText("Login");
    By register = By.linkText("Register");

    By email = By.id("input-email");
    By password = By.id("input-password");

    By loginButton =
            By.xpath("//input[@value='Login']");

    By logout =
            By.linkText("Logout");

    By continueAccount =
            By.linkText("Continue");

    By errorMessage =
            By.xpath("//div[contains(@class,'alert-danger')]");

    // Register Locators
    By firstName =
            By.id("input-firstname");

    By lastName =
            By.id("input-lastname");

    By phone =
            By.id("input-telephone");

    By confirmPassword =
            By.id("input-confirm");

    By agree =
            By.name("agree");

    By continueBtn =
            By.xpath("//input[@value='Continue']");

    public LoginPage(WebDriver driver) {

        super(driver);

        this.driver = driver;
    }

    // Login Method
    public void login(String userEmail,
                      String userPassword) {

        driver.findElement(myAccount).click();

        driver.findElement(login).click();

        driver.findElement(email)
                .sendKeys(userEmail);

        driver.findElement(password)
                .sendKeys(userPassword);

        driver.findElement(loginButton).click();
    }

    // Logout Method
    public void logout() {

        driver.findElement(myAccount).click();

        driver.findElement(logout).click();
    }

    // Error Message
    public String getErrorMessage() {

        return driver.findElement(errorMessage)
                .getText();
    }

    // Registration Method
    public void registerUser(String fname,
                             String lname,
                             String userEmail,
                             String mobile,
                             String pass) {

        driver.findElement(myAccount).click();

        driver.findElement(register).click();

        driver.findElement(firstName)
                .sendKeys(fname);

        driver.findElement(lastName)
                .sendKeys(lname);

        driver.findElement(email)
                .sendKeys(userEmail);

        driver.findElement(phone)
                .sendKeys(mobile);

        driver.findElement(password)
                .sendKeys(pass);

        driver.findElement(confirmPassword)
                .sendKeys(pass);

        driver.findElement(agree).click();

        driver.findElement(continueBtn).click();
    }
}