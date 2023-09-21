package com.cybertek.tests.practice;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest {

    //TC #16: Hover	Test
    // 1.Go	to	https://demos.telerik.com/kendo-ui/dragdrop/index
    // 2.Drag and drop the small circle	to bigger circle.
    // 3.Assert:
    // -Text in	big	circle	changed to:	“You did great"

    @Test
    public void hover(){

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Driver.getDriver().findElement(By.xpath("//button[.='Accept Cookies']")).click();

        BrowserUtils.sleep(3);

        WebElement dragButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"draggable\"]"));

        WebElement dropButton = Driver.getDriver().findElement(By.xpath("//*[@id=\"droptarget\"]"));

        BrowserUtils.sleep(3);

        Actions actions = new Actions(Driver.getDriver());

        BrowserUtils.sleep(3);

        actions.dragAndDrop(dragButton,dropButton).perform();

        BrowserUtils.sleep(3);


        WebElement text = Driver.getDriver().findElement(By.xpath("//div[.='You did great!']"));
        Assert.assertTrue(text.isDisplayed());

        Driver.closeDriver();




    }
}
