package com.krce.pages;

import com.krce.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    WebDriver driver;
    By searchBox = By.name("search");
    By searchButton = By.cssSelector("button.btn.btn-default");
    By addToCart = By.xpath("(//button[contains(@onclick,'cart.add')])[1]");
    By cartButton = By.id("cart-total");
    By viewCart = By.linkText("View Cart");
    By quantityBox = By.xpath("//input[contains(@name,'quantity')]");
    By updateButton = By.xpath("//button[@data-original-title='Update']");
    By removeButton = By.xpath("//button[@data-original-title='Remove']");
    By emptyMessage = By.xpath("//div[@id='content']/p");

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Search Product
    public void searchProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }

    // Add Product
    public void addProductToCart() {
        driver.findElement(addToCart).click();
    }

    // Open Cart
    public void openCart() {
       // driver.findElement(cartButton).click();
        //driver.findElement(viewCart).click();

            driver.navigate().refresh();
            driver.findElement(By.id("cart-total")).click();
            driver.findElement(By.linkText("View Cart")).click();
        }


    // Update Quantity
    public void updateQuantity(String qty) {
        driver.findElement(quantityBox).clear();
        driver.findElement(quantityBox).sendKeys(qty);
        driver.findElement(updateButton).click();
    }

    // Remove Product
    public void removeProduct() {
        driver.findElement(removeButton).click();
    }

    // Empty Cart Message
    public String getEmptyMessage() {
        return driver.findElement(emptyMessage).getText();
    }
}
