package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Employeelogin2 extends BaseTest {

    SoftAssert softAssert = new SoftAssert();


    @Test
    public void EmpLogin() {

        driver.get("https://vetanwala.com/login");

        // Enter credentials
        driver.findElement(By.id("email")).sendKeys("abhishekvaish@thesileo.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("submit-login")).click();

        String currentUrl = driver.getCurrentUrl();
        System.out.println("After Login URL: " + currentUrl);

        //Assert.assertTrue(currentUrl.contains("dashboard"), "Login failed - Dashboard not loaded");
        softAssert.assertEquals(currentUrl.contains("dashboard"), "Login failed - Dashboard not loaded");

        System.out.println("✔ Login successful");
    }

}
