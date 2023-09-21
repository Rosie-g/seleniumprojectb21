package com.cybertek.tests.day9_driver_actions_uploads;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverPractice {

    //TC #15: Hover Test
    //1. Go to http://practice.cybertekschool.com/hovers
    //2. Hover over to first image
    //3. Assert:
    //a. “name: user1” is displayed
    //4. Hover over to second image
    //5. Assert:
    //a. “name: user2” is displayed
    //6. Hover over to third image
    //7. Confirm:
    //a. “name: user3” is displayed

    @Test
    public void hover_test() {

        Driver.getDriver().get("http://practice.cybertekschool.com/hovers ");

        Actions actions = new Actions(Driver.getDriver());

        WebElement firstImage = Driver.getDriver().findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));
        actions.moveToElement(firstImage).perform();

        WebElement user1 = Driver.getDriver().findElement(By.xpath("(//h5)[1]"));

        Assert.assertTrue(user1.isDisplayed());

        WebElement secondImage = Driver.getDriver().findElement(By.xpath("(//img[@alt='User Avatar'])[2]"));
        actions.moveToElement(secondImage).perform();

        WebElement user2 = Driver.getDriver().findElement(By.xpath("(//h5)[2]"));

        Assert.assertTrue(user2.isDisplayed());

        WebElement thirdImage = Driver.getDriver().findElement(By.xpath("(//img[@alt='User Avatar'])[3]"));
        actions.moveToElement(thirdImage).perform();

        WebElement user3 = Driver.getDriver().findElement(By.xpath("(//h5)[3]"));

        Assert.assertTrue(user3.isDisplayed());

        //List<WebElement> pictures = Driver.getDriver().findElements(By.xpath("//img[@alt='User Avatar']"));
        //Actions actions= new Actions(Driver.getDriver());
        // for (WebElement each: pictures){
        //  actions.moveToElement(each);
        //  actions.click().build().perform();
        //  BrowserUtils.sleep(3);
        // }

    }
}
