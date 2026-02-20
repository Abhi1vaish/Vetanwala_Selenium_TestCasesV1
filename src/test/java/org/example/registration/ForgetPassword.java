package org.example.registration;

import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ForgetPassword extends BaseTest {

    @Test
    public void forgetPass() {


        // Navigate to login page
        driver.get("https://vetanwala.com/login");

        // Enter email
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("abhishekvaish@thesileo.com");
        softAssert.assertEquals(emailField.getAttribute("value"), "abhishekvaish@thesileo.com", "User ID is matched");

        // Enter invalid password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("987654321");

        // Click login
        driver.findElement(By.id("submit-login")).click();

        // Wait for error message to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='help-block with-errors']"))
        );

        String actualMsg = errorMsg.getText();
        String expectedMsg = "These credentials do not match our records.";
        System.out.println("✔ Captured Validation Message: " + actualMsg);

        softAssert.assertEquals(actualMsg, expectedMsg, "Validation message for invalid credentials");

        // Click on Forgot password link
        driver.findElement(By.linkText("Forgot password")).click();

        // Enter email on forgot password page
        WebElement forgotEmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        forgotEmailField.sendKeys("rupendra@thesileo.com");

        // Click submit (assuming the button ID is still 'submit-login', otherwise update it)
         // After clicking submit on forgot password page
        driver.findElement(By.id("submit-login")).click();

        // Wait for the confirmation message
        WebElement confirmationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"success-msg\"]") // Adjust selector to match your site
        ));

        String actualConfirmation = confirmationMsg.getText();
        String expectedConfirmation = "We have emailed your password reset link.";

        softAssert.assertEquals(actualConfirmation, expectedConfirmation, "Forgot password email sent confirmation");
        System.out.println("✔ Confirmation message: " + actualConfirmation);



        softAssert.assertAll();
    }
}
