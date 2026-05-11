package com.krce.test;

import com.krce.base.BaseTest;
import com.krce.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    String myAccount = "ashu30@gmail.com";
    // Checkout As Logged In User
    @Test(priority = 1)
    public void checkoutTest() {
        CheckoutPage cp =new CheckoutPage(driver);
        cp.login(myAccount, "test123");
        cp.addProduct();
        cp.openCheckout();
        Assert.assertTrue(driver.getPageSource().contains("Checkout"));
        System.out.println("Checkout Opened");
    }

    // Confirm Order
    @Test(priority = 2)
    public void confirmOrderTest() {
        CheckoutPage cp =new CheckoutPage(driver);
        cp.login(myAccount, "test123");
        cp.addProduct();
        cp.openCheckout();
        Assert.assertTrue(driver.getPageSource().contains("Checkout"));
        System.out.println("Order Confirmed");
    }

    // Checkout Without Login
    @Test(priority = 3)
    public void checkoutWithoutLoginTest() {
        CheckoutPage cp = new CheckoutPage(driver);
        cp.addProduct();
        cp.openCheckout();
        Assert.assertTrue(driver.getPageSource().contains("Login"));
        System.out.println("Redirected To Login");
    }
}