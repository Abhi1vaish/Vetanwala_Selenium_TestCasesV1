package org.example.registration;

import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewSignUp extends BaseTest {

    @Test(priority = 1)
    public void NewSignup() {
        driver.get("https://vetanwala.com/login");
        driver.findElement(By.xpath("//a[normalize-space()='Sign up']")).click();
        driver.manage().window().maximize();

        boolean isDisplayed1 = driver.findElement(By.xpath("//img[@alt='logo']")).isDisplayed();
        boolean isDisplayed2 = driver.findElement(By.xpath("//h1[@class='h3 text-center']")).isDisplayed();
        if (isDisplayed1) {
            softAssert.assertEquals(!isDisplayed1, "Logo is NOT displayed on Sign up page!");
        } else if (isDisplayed2) {
            softAssert.assertEquals(isDisplayed2, "SignUp Logo is NOT displayed on Sign up page!");
        }
    }

    @Test
    public void CheckFields() {


        driver.get("https://vetanwala.com/login");
        driver.findElement(By.xpath("//a[normalize-space()='Sign up']")).click();
        driver.manage().window().maximize();

        WebElement companyName = driver.findElement(By.xpath("//input[@id='company_name']"));
        boolean isDisplayedCompany = companyName.isDisplayed();
        softAssert.assertEquals(isDisplayedCompany, " Company Name field is visible");
        String fieldValueCompanyName = companyName.getAttribute("value");
        if (fieldValueCompanyName.isEmpty()) {
            companyName.sendKeys("TestAutomation Pvt Ltd");
        }


        WebElement yourName = driver.findElement(By.xpath("//input[@id='name']"));
        boolean isDisplayedYourName = yourName.isDisplayed();
        softAssert.assertEquals(isDisplayedYourName, "Your Name field is visible");
        String fieldvalue = yourName.getAttribute("value");
        if (fieldvalue.isEmpty()) {
            yourName.sendKeys("Abhishek_Test");
        }

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        boolean isDisplayedEmail = email.isDisplayed();
        softAssert.assertEquals(isDisplayedEmail, "Email field is visible");
        String fieldValueEmail = email.getAttribute("value");
        if (fieldvalue.isEmpty()) {
            email.sendKeys("abhishekvaish@thesileo.com");
        }

        WebElement phone = driver.findElement(By.xpath("//input[@id='company_phone']"));
        boolean isDisplayedphone = phone.isDisplayed();
        softAssert.assertEquals(isDisplayedphone, "Company phone field is visible");
        String fieldValuePhone = phone.getAttribute("value");
        if (fieldvalue.isEmpty()) {
            phone.sendKeys("8853900220");
        }

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        boolean isDisplayedpassword = password.isDisplayed();
        softAssert.assertEquals(isDisplayedpassword, "Password field is displayed");
        String fieldValuepassword = password.getAttribute("value");
        if (fieldvalue.isEmpty()) {
            password.sendKeys("Test@123");
        }

        WebElement confpassword = driver.findElement(By.xpath("//input[@id='password_confirmation']"));
        boolean isDisplayedconfpassword = confpassword.isDisplayed();
        softAssert.assertEquals(!isDisplayedconfpassword, " Confirm Password field is displayed");

        String fieldValue = confpassword.getAttribute("value");
        if (fieldValue.isEmpty()) {
            confpassword.sendKeys("Test@123");
        }

    }
}
