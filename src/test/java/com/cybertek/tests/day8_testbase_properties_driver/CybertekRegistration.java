package com.cybertek.tests.day8_testbase_properties_driver;

import com.cybertek.tests.base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CybertekRegistration extends TestBase {

    // TC#6: Cybertek registration form confirmation Note: Use JavaFaker when possible.

    @Test
    public void faker_task() throws InterruptedException {

        //1. Open browser
        //2. Go to website: http://practice.cybertekschool.com/registration_form
        driver.get("http://practice.cybertekschool.com/registration_form");

        Faker faker = new Faker();

        //3. Enter first name
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        //4. Enter last name
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        //5. Enter username
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("aaa0001");

        //6. Enter email address
        WebElement emailAddress = driver.findElement(By.xpath("//input[@name='email']"));
        emailAddress.sendKeys(faker.internet().emailAddress());

        //7. Enter password
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());

        //8. Enter phone number
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys("871-003-8765");

        //9. Select a gender from radio buttons
        WebElement gender = driver.findElement(By.xpath("//input[@value='male']"));
        gender.click();

        //10. Enter date of birth
        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@name='birthday']"));
        dateOfBirth.sendKeys("08/04/1994");


        //11. Select Department/Office
        Select selectDep = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        Thread.sleep(1000);
        selectDep.selectByVisibleText("Department of Engineering");

        //12. Select Job Title
        Select selectJob = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        Thread.sleep(1000);
        selectJob.selectByVisibleText("SDET");

        //13. Select programming language from checkboxes
        WebElement progLanguage = driver.findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        progLanguage.click();

        //14. Click to sign up button
        WebElement signupButton = driver.findElement(By.xpath("//button[@id='wooden_spoon']"));
        signupButton.click();

        //15.Verify success message “You’ve successfully completed registration.” is displayed.


        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = driver.findElement(By.xpath("//p")).getText();

        Assert.assertEquals(actualMessage,expectedMessage);


        WebElement firstName = driver.findElement(By.xpath("//input[@name='fname']"));
        firstName.sendKeys("Firuza");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='ltname']"));
        lastName.sendKeys("Davlyatshoeva");

        WebElement gender = driver.findElement(By.xpath("//input[@id='female']"));
        gender.click();

        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();

        if(!checkbox.isSelected()){
            System.out.println("Checkbox is NOT selected. Default value verification PASSED! ");
        }else{
            System.out.println("Checkbox is selected. Default value verification FAILED!!!");
        }

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();


    }
}
