package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC2_Checkbox_Verification {

    public static void main(String[] args) throws InterruptedException {

        // 1.Open	Chrome	browser
        // 2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        // 3.Verify	“Success – Check box is	checked” message is	NOT displayed.
        // 4.Click	to	checkbox under “Single Checkbox Demo” section
        // 5.Verify	“Success – Check box is	checked” message is displayed.

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 3.Verify	“Success – Check box is	checked” message is	NOT displayed.

        //Option#1: Using xpath and id attribute to locate successMessage
        WebElement successMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));

        //Option#2: Using xpath and style attribute: //div[@id='display: block']
        //Option#3: Using xpath and text value: //div[.='Success - Check box is checked']
        //Option#3: Using xpath and text value: //div[text()='Success - Check box is checked']
        //Option#4: Using xpath and * instead of tagName: //*[@id='display: block']

        //Locating checkbox
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));

        if (!checkbox1.isSelected() && !successMessage.isDisplayed()){
            System.out.println("Checkbox is not selected. Message is not displayed. Verification PASSED!");
        }else{
            System.out.println("FAIL!");
        }

        // 4.Click	to	checkbox under “Single Checkbox Demo” section
        Thread.sleep(2000);
        checkbox1.click();

        // 5.Verify	“Success – Check box is	checked” message is displayed.

        if (checkbox1.isSelected()&&successMessage.isDisplayed()){
            System.out.println("Checkbox is not selected. Message is not displayed. Verification PASSED!");
        }else{
            System.out.println("FAIL!");
        }

        Thread.sleep(2000);

        driver.close();




    }
}
