package org.example.dashboard;
import org.example.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DashboardVerification extends BaseTest {

        @BeforeMethod
        public void setUp() {

            driver.get("https://vetanwala.com/login");
            driver.findElement(By.id("email")).sendKeys("abhishekvaish@thesileo.com");
            driver.findElement(By.id("password")).sendKeys("12345678");
            driver.findElement(By.id("submit-login")).click();
        }

        @Test(enabled = false)
        public void DashboardVerificationMySpace() throws InterruptedException {

            //Check all the menus and button are present or clickable.
            try{
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement hrLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='HR']")));
                hrLink.click();
                System.out.println("Hr button is present and clicked successfully");
                Thread.sleep(2000);

                WebElement HolidayLink = driver.findElement(By.xpath("//a[@title='Holiday']"));
                HolidayLink.click();
                System.out.println("Holiday button is present and clicked successfully");
                Thread.sleep(2000);

                WebElement AppreciationLink = driver.findElement(By.xpath("//a[@title='Appreciation']"));
                AppreciationLink.click();
                System.out.println("Appreciation button is present and clicked successfully");
                Thread.sleep(2000);

                WebElement AnnualPerformanceLink = driver.findElement(By.xpath("//span[normalize-space()='Annual Performance']"));
                AnnualPerformanceLink.click();
                System.out.println("Annual Performance button is present and clicked successfully");
                Thread.sleep(2000);

                WebElement SelfAssesmentLink = driver.findElement(By.xpath("//a[@title='Self Assessment Form']"));
                SelfAssesmentLink.click();
                System.out.println("SelfAssesment button is present and clicked successfully");
                Thread.sleep(2000);

                WebElement AtendenceLink = driver.findElement(By.xpath("//span[@class='pl-2'][normalize-space()='Attendance']"));
                AtendenceLink.click();
                WebElement AtendenceLink2 = driver.findElement(By.xpath("//a[contains(text(),'Attendance')]"));
                AtendenceLink2.click();
                System.out.println("Attendance button is present and clicked successfully");
                Thread.sleep(2000);

                WebElement LeaveLink = driver.findElement(By.xpath("//span[normalize-space()='Leaves']"));
                LeaveLink.click();
                WebElement LeaveLink2 = driver.findElement(By.xpath("//a[contains(text(),'Leaves')]"));
                LeaveLink2.click();
                System.out.println("Leave button is present and clicked successfully");
                Thread.sleep(2000);

                WebElement PayrollLink = driver.findElement(By.xpath("//span[normalize-space()='Payroll']"));
                PayrollLink.click();
                Thread.sleep(1000);
                System.out.println("Payroll menu button is present and clicked successfully");
                WebElement PayrollLink1 = driver.findElement(By.xpath("//a[contains(text(),'Payroll')]"));
                PayrollLink1.click();
                Thread.sleep(1000);
                System.out.println("Payroll page button is present and clicked successfully");
                WebElement Reports = driver.findElement(By.xpath("//a[@title='Reports']"));
                Reports.click();
                Thread.sleep(3000);
                System.out.println("Report sub-menu button is present and clicked successfully");

                WebElement WorkLink = driver.findElement(By.xpath("//span[normalize-space()='Work']"));
                WorkLink.click();
                Thread.sleep(1000);
                System.out.println("Payroll menu button is present and clicked successfully");
                WebElement ProjectLink = driver.findElement(By.xpath("//a[@title='Projects']"));
                ProjectLink.click();
                Thread.sleep(1000);
                System.out.println("Project sub-menu button is present and clicked successfully");
                WebElement taskLink = driver.findElement(By.xpath("//a[@title='Tasks']"));
                taskLink.click();
                Thread.sleep(1000);
                System.out.println("Task sub-menu button is present and clicked successfully");

                WebElement TicketsLink = driver.findElement(By.xpath("//span[normalize-space()='Tickets']"));
                TicketsLink.click();
                Thread.sleep(1000);
                System.out.println("Ticket module is present and clicked successfully");

                WebElement EventLink = driver.findElement(By.xpath("//span[@class='pl-2'][normalize-space()='Events']"));
                EventLink.click();
                Thread.sleep(1000);
                System.out.println("Event module is present and clicked successfully");

                WebElement NoticeBoardLink = driver.findElement(By.xpath("//span[@class='pl-2'][normalize-space()='Notice Board']"));
                NoticeBoardLink.click();
                Thread.sleep(1000);
                System.out.println("Notice Board module is present and clicked successfully");

                WebElement AssetLink = driver.findElement(By.xpath("//span[normalize-space()='Asset']"));
                AssetLink.click();
                Thread.sleep(1000);
                System.out.println("Asset module is present");
                WebElement AssetLink1 = driver.findElement(By.xpath("//a[@class='f-14 text-lightest'][normalize-space()='Asset']"));
                AssetLink1.click();
                Thread.sleep(1000);
                System.out.println("Asset module clicked successfully");
                WebElement AssetReport = driver.findElement(By.xpath("//a[@title='Asset Report']"));
                AssetReport.click();
                Thread.sleep(1000);
                System.out.println("Asset Report sub module is present and clicked successfully");

                WebElement ReimbursementReport = driver.findElement(By.xpath("//span[normalize-space()='Reimbursement']"));
                ReimbursementReport.click();
                Thread.sleep(1000);
                System.out.println("Reimbursement Report module is present and clicked successfully");

                WebElement settingLink = driver.findElement(By.xpath("//span[normalize-space()='Settings']"));
                settingLink.click();
                Thread.sleep(1000);
                System.out.println("Setting module is present and clicked successfully");


                WebElement MessagesLink = driver.findElement(By.xpath("//span[@class='pl-2'][normalize-space()='Messages']"));
                MessagesLink.click();
                Thread.sleep(1000);
                System.out.println("Messages module is present and clicked successfully");

                // hide and unhide the menu bar

                WebElement hide= driver.findElement(By.xpath("//button[@id='sidebarToggle']"));
                hide.click();
                Thread.sleep(3000);
                System.out.println("Menu bar is Hide successfully");

                WebElement unhide= driver.findElement(By.xpath("//button[@id='sidebarToggle']"));
                unhide.click();
                Thread.sleep(5000);
                System.out.println("Menu bar is unhide successfully");

                // logout after verified all the mapped modules and submodules.

                WebElement logout = driver.findElement(By.xpath("//a[@class='d-block header-icon-box']//*[name()='svg']"));
                logout.click();
                Thread.sleep(1000);
                System.out.println("User logged off successfully");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        @Test(enabled = false)
        public void VerifyProfile() throws InterruptedException {

            WebElement Profile = driver.findElement(By.xpath("//i[@class='icon-arrow-down icons pl-2']"));
            Profile.click();
            WebElement ProfileSetting = driver.findElement(By.xpath("//i[@class='side-icon bi bi-pencil-square']"));
            ProfileSetting.click();
            Thread.sleep(3000);
            System.out.println("Profile setting page is open successfully");
// Search functionality

            WebElement Search = driver.findElement(By.id("search-setting-menu"));
            Search.click();

            if (Search.isDisplayed()) {
                System.out.println("Value entered");
                Search.sendKeys("Security Setting");
                Search.click();
                Thread.sleep(2000);
                Search.clear();

            } else {
                System.out.println("Value fetched successfully");
            }

            if (Search.isEnabled()) {
                Search.sendKeys("-9@0(9!");
                Search.click();
                Thread.sleep(2000);
                Search.clear();
                System.out.println("Entered value is incorrect");
            } else {

                System.out.println("Please enter the Correct value");
            }
        }
        @Test (enabled = true)
        public void DashboardPage() {

            try{
                // Check dashboard page Ui My space Page.
                // verify Home button present and clickable.
                WebElement HomeButton = driver.findElement(By.xpath("//div[@class='page-title d-none d-lg-flex']//a[@class='text-lightest'][normalize-space()='Home']"));
                HomeButton.click();
                Thread.sleep(2000);

                // Check the welcome msg.
                WebElement welcomeText = driver.findElement(By.xpath("//h1[normalize-space()='Welcome!']"));
                welcomeText.isDisplayed();

                if (welcomeText.isDisplayed()){
                    System.out.println("Welcome! Text is present on Header section");
                }
                else{
                    System.out.println(("Header is blank"));
                }

                // Check the Employee Name on Header
                WebElement EmployeeName = driver.findElement(By.xpath("//h2[normalize-space()='Abhishek Vaish']"));
                EmployeeName.isDisplayed();

                if(EmployeeName.isDisplayed()) {
                    System.out.println("Employee Name is present on Header section");
                }else{
                    System.out.println("Employee Name not found");
                }
                Thread.sleep(2000);

                // Check the EmployeeId on Header
                WebElement EmployeeId = driver.findElement(By.xpath("//p[normalize-space()='Employee SL000134']"));
                EmployeeId.isDisplayed();

                if(EmployeeId.isDisplayed()){
                    System.out.println("Employee Id is present on Header section");
                }
                else{
                    System.out.println("Employee Name not found");
                }
                Thread.sleep(2000);



                // Verify the Date and time on the Header section

//            WebElement dateTimeElement = driver.findElement(By.xpath("//div[@class='check-in']"));
//            String uiText = dateTimeElement.getText();
//            System.out.println("UI Text: " + uiText);
//
//            // Extract Day & Time from UI text
//            String uiDay = uiText.substring(0, uiText.indexOf(" "));
//            String uiTime = uiText.substring(uiText.indexOf(" ") + 1);
//
//            // ✅ Verify Day
//            String systemDay = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(new Date());
//            Assert.assertEquals(uiDay, systemDay, "Day mismatch!");
//
//
//            // ✅ Verify Time (with tolerance ±5 seconds)
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a", Locale.ENGLISH);
//            LocalTime uiLocalTime = LocalTime.parse(uiTime, formatter);
//            LocalTime systemLocalTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
//            long diffInSeconds = Math.abs(ChronoUnit.SECONDS.between(systemLocalTime, uiLocalTime));
//
//            // Assert with tolerance
//            Assert.assertTrue(diffInSeconds <= 5, "Time mismatch! Difference = " + diffInSeconds + " seconds");



            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

