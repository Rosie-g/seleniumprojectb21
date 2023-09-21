package com.cybertek.tests.day2_locators_getText;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_SmartBearLoginVerification {

    public static void main(String[] args) throws InterruptedException {

        //TC #5: Basic login authentication
        //1- Open a chrome browser
        // setup
        WebDriverManager.chromedriver().setup();

        // open browser
        WebDriver driver = new ChromeDriver();

        //maximize
        driver.manage().window().maximize();

        //2- Go to:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //3- Verify title equals:
        //Expected: Web Orders Login
        String expectedTitle = "Web Orders Login";
        String actualTitle = driver.getTitle();


        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Landing page title verification PASSED");
        } else {
            System.err.println("Landing page title verification FAILED");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);
        }


        //4- Enter username: Tester
        //first we need to locate the username input box and then sendKeys(username)
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("tester");


        //5- Enter password: test
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");


        //6- Click "Sign In" button
        //driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        driver.findElement(By.className("button")).click();

        //7- Verify title equals:
        //Expected: Web Orders


        String expectedTitle2 = "Web Orders";
        String actualTitle2 = driver.getTitle();


        if (expectedTitle2.equals(actualTitle2)) {
            System.out.println("Landing page title2 verification PASSED");
        } else {
            System.err.println("Landing page title2 verification FAILED");
            System.out.println("expectedTitle2 = " + expectedTitle2);
            System.out.println("actualTitle2 = " + actualTitle2);
        }


        driver.close();

    }
}
