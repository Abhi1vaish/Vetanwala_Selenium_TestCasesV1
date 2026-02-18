package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    @Test
    public void verifyGoogleTitle() {

        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        Assert.assertTrue(title.contains("Google"), "Title does not match!");
    }
}
