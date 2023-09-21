package com.cybertek.tests.day5_testNG_intro_dropdowns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Amazon {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();


        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("masks" + Keys.ENTER);

        String expectedTitle = "Amazon.com : masks";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);

        WebElement mask = driver.findElement(By.linkText("ZTANPS Face Mask,Pack of 50 Black Disposable Face Mask for Men & Women"));
        mask.click();

        String expectedRes = "Amazon.com: ZTANPS Face Mask,Pack of 50 Black Disposable Face Mask for Men & Women";
        String actual = driver.getTitle();


        Assert.assertTrue(actual.contains(expectedRes));

        System.out.println(actual);
        System.out.println(actualTitle);

        driver.close();


    }

}



