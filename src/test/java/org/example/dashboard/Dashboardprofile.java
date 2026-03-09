package org.example.dashboard;

import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dashboardprofile extends BaseTest {
@BeforeMethod
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
    }

    @Test
    public void DashboardMyProfile(){

        WebElement myProfileLink = driver.findElement(By.xpath("//*[@id=\"fullscreen\"]/div[4]/button[2]"));
        myProfileLink.click();
        String variable = myProfileLink.getText();
        softAssert.assertTrue(variable.contains("Profile"),"My profile title is present not on Dashboard page");
        System.out.println("Profile Page Open Successfully");

    }
    @Test
    public void ProfileVerification(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ProfileText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[normalize-space()='Work Place']")));
        ProfileText.isDisplayed();

        String variable = ProfileText.getText();
        softAssert.assertTrue(variable.contains("Work Place"),"Work Place text is present not on Dashboard page");
        System.out.println("Profile Page Open Successfully");
        softAssert.assertAll();
    }




}
