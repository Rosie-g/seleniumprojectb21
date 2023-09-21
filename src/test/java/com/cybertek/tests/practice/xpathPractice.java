package com.cybertek.tests.practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xpathPractice {

    public static void main(String[] args) throws InterruptedException {

        //1. Open Chrome browser
        // 2. Go to http://practice.cybertekschool.com/add_remove_elements
        // 3. Click to “Add Element” button
        // 4. Verify “Delete” button is displayed after clicking.
        // 5. Click to “Delete” button.
        // 6. Verify “Delete” button is NOT displayed after clicking.
        // USE XPATH LOCATOR FOR ALL WEB ELEMENT LOCATORS


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[.='Add Element']")).click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));

        if (deleteButton.isDisplayed()) {
            System.out.println("Delete button is displayed");
        } else {
            System.out.println("Delete button is not displayed");
        }

        Thread.sleep(3000);

        deleteButton.click();

        Thread.sleep(4000);


        if (deleteButton.isDisplayed()) {
            System.out.println("Delete button is displayed");
        } else {
            System.out.println("Delete button is not displayed");
        }


        driver.close();


    }
}
