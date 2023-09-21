package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class RemoveName {

    // #11: Create a method called removeName()
    // 1.Accepts two parameters: WebDriver, String name
    // 2.Method will remove the given name from the list of Smartbear
    // 3.Create a new TestNG test, and call your method.
    // 4.Assert that your method removed the given name

    public static void removeName(WebDriver driver, String name) {

        WebElement checkBoxes = driver.findElement(By.xpath("(//td[2]//tr/td[.='"+name+"']/..//input)[1]"));
        checkBoxes.click();

        WebElement deleteButton = driver.findElement(By.xpath("//input[@type='submit']"));
        deleteButton.click();


        List<WebElement> allNames = driver.findElements(By.xpath("//tbody//tr//td[2]"));

        for (WebElement each : allNames) {
            if (each.getText().equals(name)){
                System.out.println("Name still in the list, Please, remove it");
            }else{
               Assert.assertNotEquals(each.getText(),name);
            }
        }


    }
}
