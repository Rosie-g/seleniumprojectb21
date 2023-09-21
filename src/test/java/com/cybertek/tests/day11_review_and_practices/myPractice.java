package com.cybertek.tests.day11_review_and_practices;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class myPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        WebElement gmailButton = driver.findElement(By.cssSelector("a[class='gb_f']"));
        Thread.sleep(2000);
        gmailButton.click();

        String expected = "Gmail: Free, Private & Secure Email | Google Workspace";
        String actual  = driver.getTitle();

        if (expected.contains(actual)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
            System.out.println("Exp : " + expected);
            System.out.println("Title: "+ actual);

        }

        driver.close();


    }
}
