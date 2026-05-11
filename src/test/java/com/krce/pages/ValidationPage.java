package com.krce.pages;

import com.krce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidationPage extends BasePage {
    WebDriver driver;
    By myAccount = By.linkText("My Account");
    By register = By.linkText("Register");
    By continueBtn = By.xpath("//input[@value='Continue']");
    By email = By.id("input-email");

    public ValidationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Open Register Page
    public void openRegisterPage() {
        driver.findElement(myAccount).click();
        driver.findElement(register).click();
    }

    // Empty Form Submit
    public void submitEmptyForm() {
        driver.findElement(continueBtn).click();
    }

    // Invalid Email
    public void invalidEmail() {
        driver.findElement(email).sendKeys("abc@gmail");
        driver.findElement(continueBtn).click();
    }

    // Open Checkout Page
    public void openCheckoutPage() {
        driver.get("https://tutorialsninja.com/demo/index.php?route=checkout/checkout");
    }
}