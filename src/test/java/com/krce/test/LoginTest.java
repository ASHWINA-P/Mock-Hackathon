
package com.krce.test;
import com.krce.utils.ConfigReader;
import com.krce.base.BaseTest;
import com.krce.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    String myAccount = "ashu30@gmail.com";

    // Valid Login Test
    @Test(priority = 1)
    public void validLoginTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login(myAccount, "test123");
        Assert.assertTrue(driver.getPageSource().contains("My Account"));
        System.out.println("Login Successful");
    }

    // Registration Test
    @Test(priority = 2)
    public void registerTest() {
        LoginPage lp = new LoginPage(driver);
        String email = "ash" + System.currentTimeMillis()+ "@gmail.com";
        lp.registerUser("Ash", "P", email, "9876543210", "test123");
        Assert.assertTrue(driver.getPageSource().contains("Your Account Has Been Created!"));
        System.out.println("Registration Successful");
    }

    // Invalid Login Test
    @Test(priority = 3)
    public void invalidLoginTest() {
        LoginPage lp =new LoginPage(driver);
        lp.login("wrong@gmail.com", "wrong123");
        String error = lp.getErrorMessage();
        Assert.assertTrue(error.contains("Warning"));
        System.out.println("Invalid Login Verified");
    }

    // Logout Test
    @Test(priority = 4)
    public void logoutTest() {
        LoginPage lp = new LoginPage(driver);
        lp.login(myAccount, "test123");
        driver.navigate().refresh();
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Logout")).click();
        Assert.assertTrue(driver.getPageSource().contains("Account Logout"));
        System.out.println("Logout Successful");
    }
}