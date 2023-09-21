package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebOrderUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebOrder_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //maximize
        driver.manage().window().maximize();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebOrderUtils.loginToSmartBear(driver);

    }

    @Test
    public void test2_create_order_with_java_faker() throws InterruptedException {
        //6.Click on Order
        WebElement orderLink = driver.findElement(By.xpath("//a[.='Order']"));
        orderLink.click();


        //7.Select familyAlbum from product, set quantity to 2

        //Locating the dropdown
        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));

        //Selecting "FamilyAlbum" from options using selectByVisibleText method
        productDropdown.selectByVisibleText("FamilyAlbum");

        //Locate quantityInput box
        WebElement inputQuantity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));

        //inputQuantity.clear();
        Thread.sleep(1000);
        inputQuantity.sendKeys(Keys.BACK_SPACE);

        Thread.sleep(1000);
        inputQuantity.sendKeys("2");

        //8.Click to “Calculate” button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        //Locating web elements using ID locator
        WebElement nameInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement streetInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement cityAddress = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement zipCode = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));


        //9.Fill address Info with JavaFaker
        Faker faker = new Faker();

        nameInput.sendKeys(faker.name().fullName());
        streetInput.sendKeys(faker.address().streetAddress());
        cityAddress.sendKeys(faker.address().cityName());
        zipCode.sendKeys(faker.address().zipCode().replaceAll("-",""));

        //•Generate: name, street, city, state, zip code
        //10.Click on “visa” radio button
        WebElement visaRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaRadioButton.click();

        //11.Generate card number using JavaFaker
        WebElement inputCreditCard = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        inputCreditCard.sendKeys(faker.finance().creditCard().replaceAll("-",""));

        //Enter ExpirationDate
        WebElement inputExpirationDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        inputExpirationDate.sendKeys("01/26");

        //12.Click on “Process”
        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        //13.Verify success message “New order has been successfully added
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));

        Assert.assertTrue(successMessage.isDisplayed(),"Success message is NOT displayed!!!");
    }


    @Test
    public void test1_link_verifications() {

        //6.Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));// to get all links
        System.out.println("Number of all links in this page: " + allLinks.size());

        //7.Print out each link text on this page
        for (WebElement each : allLinks) {
            System.out.println("each = " + each.getText());
        }


    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        //additional 5 seconds before closing the browser
        Thread.sleep(5000);

        driver.close();

    }
}
