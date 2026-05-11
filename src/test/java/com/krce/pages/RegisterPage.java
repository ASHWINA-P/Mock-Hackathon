// RegisterPage.java

package com.krce.pages;

import com.krce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    WebDriver driver;
    By myAccount = By.linkText("My Account");
    By register = By.linkText("Register");
    By firstName = By.id("input-firstname");
    By lastName = By.id("input-lastname");
    By email = By.id("input-email");
    By phone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By agree = By.name("agree");
    By continueBtn = By.xpath("//input[@value='Continue']");

    public RegisterPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void registerUser(String fname, String lname, String userEmail, String mobile,
                             String pass){

        driver.findElement(myAccount).click();
        driver.findElement(register).click();
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(phone).sendKeys(mobile);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        driver.findElement(agree).click();
        driver.findElement(continueBtn).click();
    }
}