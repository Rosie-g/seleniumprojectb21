package com.cybertek.tests.day4_findElements_checkBoxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBoxesSize {

    public static void main(String[] args) throws InterruptedException{


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        List<WebElement> listOfCheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));


        int size = listOfCheckBoxes.size();
        int count = 0;

        for (WebElement each: listOfCheckBoxes){

            if (each.isSelected()){
                count++;
            }

        }



        System.out.println("size = "+ size);
        System.out.println("count = " + count);


    }
}
