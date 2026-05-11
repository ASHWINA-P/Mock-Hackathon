package com.krce.test;

import com.krce.base.BaseTest;
import com.krce.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    // Add Product To Cart
    @Test(priority = 1)
    public void addProductTest() {
        CartPage cp =new CartPage(driver);
        cp.searchProduct("iPhone");
        cp.addProductToCart();
        cp.openCart();
        Assert.assertTrue(driver.getPageSource().contains("iPhone"));
        System.out.println("Product Added To Cart");
    }

    // Update Quantity
    @Test(priority = 2)
    public void updateQuantityTest() {
        CartPage cp =new CartPage(driver);
        cp.searchProduct("iPhone");
        cp.addProductToCart();
        cp.openCart();
        cp.updateQuantity("2");
        Assert.assertTrue(driver.getPageSource().contains("2"));
        System.out.println("Quantity Updated");
    }

    // Remove Product
    @Test(priority = 3)
    public void removeProductTest() {
        CartPage cp =new CartPage(driver);
        cp.searchProduct("iPhone");
        cp.addProductToCart();
        cp.openCart();
        cp.removeProduct();
        driver.navigate().refresh();
        Assert.assertTrue(driver.getPageSource().contains("shopping cart is empty"));
        System.out.println("Product Removed");

    }

    // Cart Count Test
    @Test(priority = 4)
    public void cartCountTest() {
        CartPage cp =new CartPage(driver);
        cp.searchProduct("iPhone");
        cp.addProductToCart();
        Assert.assertTrue(driver.getPageSource().contains("item(s)"));
        System.out.println("Cart Count Verified");
    }
}