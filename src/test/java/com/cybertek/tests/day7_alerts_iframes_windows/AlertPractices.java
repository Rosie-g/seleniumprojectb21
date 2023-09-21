package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");

        //2. Go to website: http://practice.cybertekschool.com/javascript_alerts
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    //TC #1: Information alert practice

    @Test
    public void p1_information_alert_test() throws InterruptedException {

        // Locating the button for alert to click
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        // Clicking to the button for alert to be displayed
        informationAlertButton.click();

        Thread.sleep(2000);



        //4. Click to OK button from the alert

        // Switching driver's focus to alert
        Alert alert = driver.switchTo().alert();

        // Use 'alert' instance to click and close the alert
        alert.accept();


        //5. Verify "You successfully clicked an alert" text is displayed.
        WebElement resultText = driver.findElement(By.id("result"));

        String actualText = resultText.getText();
        String expectedResult = "You successfuly clicked an alert";

        Assert.assertTrue(resultText.isDisplayed());
        Assert.assertEquals(actualText,expectedResult);

    }
    @Test
    public void p2_information_alert_test() throws InterruptedException {

        // 3.Click to “Click for JS Confirm” button
        WebElement confirmButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmButton.click();
        Thread.sleep(2000);

        // 4.Click to OK button from the alert
        Alert alert = driver.switchTo().alert();

        alert.accept();

        // 5.Verify “You clicked: Ok” text is displayed.
        WebElement resultText = driver.findElement(By.id("result"));

        Assert.assertTrue(resultText.isDisplayed());

    }

    @Test
    public void p3_information_alert_test() throws InterruptedException{

        //3.Click to “Click for JS Prompt” button
        WebElement promptButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promptButton.click();

        //4.Send “hello”text to alert
        Alert alert = driver.switchTo().alert();

        alert.sendKeys("hello");

        //5.Click to OK button from the alert
        alert.accept();

        //6.Verify “You entered:  hello” text is displayed
        WebElement resultText = driver.findElement(By.id("result"));

        Assert.assertTrue(resultText.isDisplayed());


    }




    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }






}
