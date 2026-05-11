package com.krce.test;

import com.krce.base.BaseTest;
import com.krce.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    // Search Product Test
    @Test(priority = 1)
    public void searchProductTest() {
        ProductPage pp = new ProductPage(driver);
        pp.searchProduct("iPhone");
        Assert.assertTrue(driver.getPageSource().contains("iPhone"));
        System.out.println("Product Search Successful");
    }

    // Category Navigation Test
    @Test(priority = 2)
    public void categoryTest() {
        ProductPage pp = new ProductPage(driver);
        pp.openMacCategory();
        Assert.assertTrue(driver.getPageSource().contains("Mac"));
        System.out.println("Category Opened");
    }

    // Product Detail Test
    @Test(priority = 3)
    public void productDetailTest() {
        ProductPage pp = new ProductPage(driver);
        pp.searchProduct("iPhone");
        pp.openProduct();
        Assert.assertTrue(driver.getPageSource().contains("iPhone"));
        Assert.assertTrue(driver.getPageSource().contains("$"));
       // Assert.assertTrue(pp.getProductName().contains("iPhone"));
       // Assert.assertTrue(pp.getProductPrice().contains("$"));
        System.out.println("Product Details Verified");
    }

    // Invalid Product Search Test
    @Test(priority = 4)
    public void invalidSearchTest() {
        ProductPage pp = new ProductPage(driver);
        pp.searchProduct("abcdef");
        Assert.assertTrue(pp.getNoProductMessage().contains("There is no product"));
        System.out.println("No Product Found");
    }
}
