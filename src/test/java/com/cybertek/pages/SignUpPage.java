package com.cybertek.pages;

// This is a sign-up page for the web-site "http://practice.cybertekschool.com/sign_up"

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    public SignUpPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "full_name")
    public WebElement inputFullName;

    @FindBy(name = "email")
    public WebElement inputEmail;

    @FindBy(name = "wooden_spoon")
    public WebElement signUpButton;

}
