package com.krce.pages;

import com.krce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    WebDriver driver;
    By myAccount = By.linkText("My Account");
    By login = By.linkText("Login");
    By email = By.id("input-email");
    By password = By.id("input-password");
    By loginButton = By.xpath("//input[@value='Login']");
    By searchBox = By.name("search");
    By searchButton = By.cssSelector("button.btn.btn-default");
    By addToCart = By.xpath("(//button[contains(@onclick,'cart.add')])[1]");
    By cartButton = By.id("cart-total");
    By checkout =By.xpath("//strong[contains(text(),'Checkout')]");
    By continueBtn =By.id("button-payment-address");
    By confirmOrder = By.id("button-confirm");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Login
    public void login(String userEmail, String userPassword) {
        driver.findElement(myAccount).click();
        driver.findElement(login).click();
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(password).sendKeys(userPassword);
        driver.findElement(loginButton).click();
    }

    // Add Product
    public void addProduct() {
        driver.findElement(searchBox).sendKeys("iPhone");
        driver.findElement(searchButton).click();
        driver.findElement(addToCart).click();
    }

    public void openCheckout() {
        driver.get("https://tutorialsninja.com/demo/index.php?route=checkout/cart");
            driver.findElement(By.linkText("Checkout")).click();
        }

    // Confirm Order
    public void confirmOrder() {
        driver.findElement(confirmOrder).click();
    }
}