package com.cybertek.tests.practice;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClick {

    //TC#16: Double	Click Test
    // 1.Go	to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    // 2.Switch	to	iframe.
    // 3.Double	click on the text “Double-click	me	to	change	my	text color.”
    // 4.Assert: Text’s	“style”	attribute value contains "red"

    @Test
    public void test() {

        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        Driver.getDriver().switchTo().frame("iframeResult");

        Actions actions = new Actions(Driver.getDriver());

        WebElement text = Driver.getDriver().findElement(By.xpath("//p[@id='demo']"));

        actions.doubleClick(text).perform();

        WebElement redColor = Driver.getDriver().findElement(By.xpath("//p[contains(@style,'color: red;')]"));

        Assert.assertTrue(redColor.isDisplayed());

        Driver.closeDriver();

    }


}
