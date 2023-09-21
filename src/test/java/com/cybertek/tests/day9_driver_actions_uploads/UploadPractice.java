package com.cybertek.tests.day9_driver_actions_uploads;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadPractice {

    //TC #14: Upload Test
    //1. Go to http://practice.cybertekschool.com/upload
    //2. Find some small file from your computer, and get the path of it.
    //3. Upload the file.
    //4. Assert:
    //-File uploaded text is displayed on the page

    @Test
    public void upload_test(){

        Driver.getDriver().get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = Driver.getDriver().findElement(By.id("file-upload"));

        BrowserUtils.sleep(2);
        chooseFile.sendKeys("/Users/rosie/Desktop/my notes/Interview questions");

        BrowserUtils.sleep(2);

        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();


        WebElement message = Driver.getDriver().findElement(By.xpath("//h3"));

        Assert.assertTrue(message.isDisplayed());

        Driver.closeDriver();
    }
}
