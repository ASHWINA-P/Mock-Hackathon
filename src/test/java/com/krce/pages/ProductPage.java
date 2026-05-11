package com.krce.pages;

import com.krce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    WebDriver driver;
    By searchBox = By.name("search");
    By searchButton =By.cssSelector("button.btn.btn-default");
    By productResult =By.linkText("iPhone");
    By noProductMessage =By.xpath("//p[contains(text(),'There is no product')]");
    By desktops =By.linkText("Desktops");
    By mac =By.linkText("Mac (1)");
    By productName =By.xpath("//h1");
    //By productPrice =By.xpath("//h2");

    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Search Product
    public void searchProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }

    // Open Product
    public void openProduct() {
        driver.findElement(productResult).click();
    }

    // Navigate Category
    public void openMacCategory() {
        driver.findElement(desktops).click();
        driver.findElement(mac).click();
    }

    // Get Product Name
    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    // Get Product Price
    public String getProductPrice() {
        return driver.findElement(By.tagName("h2")).getText();
    }

    // No Product Message
    public String getNoProductMessage() {
        return driver.findElement(noProductMessage).getText();
    }
}