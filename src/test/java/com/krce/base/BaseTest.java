package com.krce.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.krce.utils.ConfigReader;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    protected WebDriverWait wait;


    @BeforeMethod
    public void setup(){
        driver=new ChromeDriver();
        driver.get(
                ConfigReader.getProperty("baseUrl"));
        wait =new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


