package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Smart_Bear_Edit_Order {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //maximize
        driver.manage().window().maximize();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebOrderUtils.loginToSmartBear(driver);

    }

    @Test
    public void editOrder() throws InterruptedException {

        // #10: SmartBear edit order
        // 1.Open browser and login to SmartBear
        // 2.Click to edit button from the right for “Steve Johns”
        // 3.Change name to “Michael Jordan”
        // 4.Click Update
        // 5.Assert “Michael Jordan” is in the list

        WebElement editButton = driver.findElement(By.xpath("//table[@class='SampleTable']//tr[4]//input[@type='image']"));
        Thread.sleep(1000);
        editButton.click();

        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        Thread.sleep(1000);

        customerName.clear();


        Thread.sleep(1000);
        customerName.sendKeys("Michael Jordan");


        WebElement updateButton = driver.findElement(By.xpath("//a[.='Update']"));
        updateButton.click();
        Thread.sleep(3000);

        WebElement MichaelJordan = driver.findElement(By.xpath("//table[@class='SampleTable']//tr[4]/td[2]"));

        String actualResult = MichaelJordan.getText();
        String expectedResult = "Michael Jordan";

        Assert.assertTrue(actualResult.equals(expectedResult));


    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        //additional 5 seconds before closing the browser
        Thread.sleep(5000);

         driver.close();

    }
}
