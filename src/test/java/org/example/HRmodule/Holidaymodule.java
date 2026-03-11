package org.example.HRmodule;

import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Holidaymodule extends BaseTest {

    @BeforeMethod
    public void setup() {

        driver.get("https://vetanwala.com/login");
        driver.findElement(By.id("email")).sendKeys("abhishekvaish@thesileo.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("submit-login")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard"));

        String currentUrl = driver.getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("dashboard"), "Dashboard not open after login");

        System.out.println("Dashboard Open Successfully");

        WebElement HR = driver.findElement(By.xpath("//a[@title='HR']"));
        HR.click();

        String variable = HR.getText();
        softAssert.assertTrue(variable.contains("HR"),"HR Module is Present in the Menu bar");
        System.out.println("HR Page Open Successfully");
    }

    @Test
    public void Holidays () throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        By holiday = By.xpath("//a[normalize-space()='Holiday']");

        wait.until(ExpectedConditions.elementToBeClickable(holiday)).click();

        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(holiday)).getText();

        softAssert.assertTrue(text.contains("Holiday"), "Holiday sub Module is Present in the Menu bar");

        System.out.println("Holiday Page Open Successfully");
        Thread.sleep(3000);
    }
}
