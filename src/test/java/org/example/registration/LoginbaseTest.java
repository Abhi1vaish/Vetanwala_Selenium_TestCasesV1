package org.example.registration;

import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginbaseTest extends BaseTest {

    @BeforeMethod
    @Parameters("browser")

    public void setup(){

        driver.get("https://vetanwala.com/login");

        driver.findElement(By.id("email")).sendKeys("abhishekvaish@thesileo.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("submit-login")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard"));

        String currentUrl = driver.getCurrentUrl();

        softAssert.assertTrue(currentUrl.contains("dashboard"), "Dashboard not open after login");

        System.out.println("Dashboard Open Successfully");

        softAssert.assertAll();
    }
}