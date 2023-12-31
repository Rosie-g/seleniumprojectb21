package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Dropdown_Introduction {

    //TC#1: Verifying "Simple dropdown" and "State selection" dropdown default values
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    //3. Verify "Simple dropdown" default selected value is correct
    //Expected: "Please select an option"
    //4. Verify "State selection" default selected value is correct
    //Expected: "Select a State"

    WebDriver driver;

    @BeforeClass
    public void setupClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void dropdown_test1() {
        //3. Verify "Simple dropdown" default selected value is correct
        //Expected: "Please select an option"

        WebElement simpleDropdown = driver.findElement(By.xpath("select[@id='dropdown']"));

        Select select = new Select(simpleDropdown);

        //This method will return us the currently selected option as a web element
        WebElement currentlySelectedOption = select.getFirstSelectedOption();

        String expectedDefaultValue = "Please select an option";
        String actualResult = currentlySelectedOption.getText();

        Assert.assertEquals(expectedDefaultValue, expectedDefaultValue);


        //4. Verify "State selection" default selected value is correct
        //Expected: "Select a State"

    }

    @AfterClass
    public void tearDownClass(){
        driver.close();
    }
}
