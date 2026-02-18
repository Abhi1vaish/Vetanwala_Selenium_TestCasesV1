package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Employeelogin {

        WebDriver driver;

        @BeforeMethod
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            driver.manage().window().maximize();
        }

        @Test
        public void EmpLogin() {
            driver.get("https://vetanwala.com/login");

            driver.findElement(By.id("email")).sendKeys("abhishekvaish@thesileo.com");
            driver.findElement(By.id("password")).sendKeys("123456789");
            driver.findElement(By.id("submit-login")).click();

            //  Assertion (example: check if dashboard/logo appears after login)

            boolean isLogoDisplayed = driver.findElement(By.xpath("//h1[@class='mb-0 f-16 f-w-500 text-white-shade mt-0']//img")).isDisplayed();
            Assert.assertTrue(isLogoDisplayed, " Login Passes, logo displayed");
            // softAssert
            System.out.println("✔ Login attempt completed.");
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();  //
        }
    }


