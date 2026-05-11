package com.krce.test;

import com.krce.base.BaseTest;
import com.krce.pages.ValidationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationTest extends BaseTest {

    // Empty Registration Validation
    @Test(priority = 1)
    public void emptyFieldValidationTest() {
        ValidationPage vp =new ValidationPage(driver);
        vp.openRegisterPage();
        vp.submitEmptyForm();
        Assert.assertTrue(driver.getPageSource().contains("First Name"));
        System.out.println("Empty Field Validation Passed");
    }

    // Invalid Email Validation
    @Test(priority = 2)
    public void invalidEmailValidationTest() {
        ValidationPage vp =new ValidationPage(driver);
        vp.openRegisterPage();
        vp.invalidEmail();
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));
        System.out.println("Invalid Email Validation Passed");
    }

    // Checkout Address Validation
    @Test(priority = 3)
    public void checkoutAddressValidationTest() {
        ValidationPage vp =new ValidationPage(driver);
        vp.openCheckoutPage();
        Assert.assertTrue(driver.getPageSource().contains("Login"));
        System.out.println("Checkout Validation Passed");
    }
}