package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P2_ZerobankVerification {

    public static void main(String[] args) {

        /*
        TC #2: Zero Bank link text verification
        1.Open Chrome browser
        2.Go to http://zero.webappsecurity.com/login.html
        3.Verify link text from top left:
        Expected: “Zero Bank”
        4.Verify link href attribute value contains:
        Expected: “index.html”
         */


        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement zeroBankLink = driver.findElement(By.className("brand"));


        String expectedLinkText = "Zero Bank";
        String actualLinkText = zeroBankLink.getText();

        if(actualLinkText.equalsIgnoreCase(expectedLinkText)){
            System.out.println("Link Text Verification Passed");
        }else {
            System.out.println("Link Text Verification Failed");
        }

        String expectedHref = "index.html";
        String actualHref = zeroBankLink.getAttribute("chrome");

        if(actualHref.contains(expectedHref)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

        System.out.println("expectedHref = " + expectedHref);
        System.out.println("actualHref = " + actualHref);

        driver.close();
    }
}
