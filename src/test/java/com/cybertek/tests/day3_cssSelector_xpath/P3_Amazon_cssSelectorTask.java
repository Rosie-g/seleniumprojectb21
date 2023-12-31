package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_Amazon_cssSelectorTask {

    public static void main(String[] args) {

//1. Open Chrome browser
//2. Go to https://www.amazon.com
//3. Enter search term (use cssSelector to locate search box)
//4. Verify title contains search term

        //1. Open Chrome browser
        // using our utility to SETUP + open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2. Go to https://www.amazon.com
        driver.get("https://www.amazon.com");

        //3. Enter search term (use cssSelector to locate search box)

        // tagname[attribute = 'value']
        WebElement amazonSearchBar = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));


        amazonSearchBar.sendKeys("apple"+ Keys.ENTER);


        //4. Verify title contains search term

        String expectedTitle = "apple";
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title contains search key.Verification passed");
        }else {
            System.out.println("Title does not contains search key. Verification failed");
            System.out.println(actualTitle);
            System.out.println(expectedTitle);
        }



    }
}
