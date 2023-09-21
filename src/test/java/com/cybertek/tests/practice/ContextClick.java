package com.cybertek.tests.practice;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextClick {

    //TC #17: Context Click–HOMEWORK
    // 1.Go	to	https://the-internet.herokuapp.com/context_menu
    // 2.Right click to	the	box.
    // 3.Alert will open.
    // 4.Accept	alert No assertion needed for this practice.

    @Test
    public void click(){

        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        WebElement whiteBox = Driver.getDriver().findElement(By.xpath("//div[@id='hot-spot']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.contextClick(whiteBox).perform();
        BrowserUtils.sleep(3);

        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            BrowserUtils.sleep(3);
            alert.accept();
        }catch (UnhandledAlertException e){

        }


//        Alert alert = Driver.getDriver().switchTo().alert();
//        BrowserUtils.sleep(3);
//        alert.accept();

        Driver.closeDriver();


    }


}
