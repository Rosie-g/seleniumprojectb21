package com.cybertek.tests.day8_testbase_properties_driver;

import com.cybertek.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CybertekDropdown extends TestBase {

    //TC#7: Cybertek “month”dropdown default value
    //1.Open browser2.
    //Go to website: http://practice.cybertekschool.com/dropdowns
    //3.Verify default value is always showing the current month
    // Expected: If currently in June, should show June selected.


    @Test
    public void cyberTek_dropdown() {

        driver.get("http://practice.cybertekschool.com/dropdown");

        Select select = new Select(driver.findElement(By.xpath("//select[@id='month']")));

        String currentMonth = LocalDate.now().getMonth().name();
        currentMonth = currentMonth.substring(0, 1).toUpperCase() + currentMonth.substring(1).toLowerCase();
        String actualDate = select.getFirstSelectedOption().getText();

        Assert.assertEquals(currentMonth, actualDate, "Not valid");

    }

    @Test
    public void month_dropdown() {

        //1. Do both verifications in the same test
        //2. Verify list of months are correct as expected.
        //o Expected: Options should contain all 12 months of the year.

        driver.get("http://practice.cybertekschool.com/dropdown");

        Select select = new Select(driver.findElement(By.xpath("//select[@id='month']")));

        List<WebElement> monthList = select.getOptions();

        ArrayList<String> month = new ArrayList<>();


        for (WebElement each : monthList) {
            month.add(each.getText());
        }

        for (WebElement each : monthList){
            Assert.assertTrue(each.isDisplayed());
        }


    }


}
