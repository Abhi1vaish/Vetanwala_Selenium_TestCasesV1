package org.example;


import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VetanwalaLoginTest extends BaseTest {

    private final String URL = "https://vetanwala.com/login";

    @Test(priority = 1)
    public void verifyLoginPageLoads() {

        driver.get(URL);

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        Assert.assertTrue(title.contains("Log In"), "Login page not loaded properly");
    }

    @Test(priority = 2)
    public void verifyLoginElementsPresent() {

        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit-login"));

        Assert.assertTrue(emailField.isDisplayed(), "Email field not visible");
        Assert.assertTrue(passwordField.isDisplayed(), "Password field not visible");
        Assert.assertTrue(loginButton.isDisplayed(), "Login button not visible");
    }

    @Test(priority = 3)
    public void verifyShowPasswordToggle() throws InterruptedException {

        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement toggleIcon = driver.findElement(By.id("showPasswordToggle"));

        // Default type should be password
        Assert.assertEquals(passwordField.getAttribute("type"), "password");

        toggleIcon.click();
        Thread.sleep(1000);

        // After click, should change to text
        Assert.assertEquals(passwordField.getAttribute("type"), "text");

        toggleIcon.click();
        Thread.sleep(1000);

        // Back to password
        Assert.assertEquals(passwordField.getAttribute("type"), "password");
    }

    @Test(priority = 4)
    public void verifyRequiredFieldValidation() {

        WebElement loginButton = driver.findElement(By.id("submit-login"));
        loginButton.click();

        WebElement emailField = driver.findElement(By.id("email"));
        String validationMessage = emailField.getAttribute("validationMessage");

        Assert.assertTrue(validationMessage.length() > 0, "Required validation not working");
    }
}
