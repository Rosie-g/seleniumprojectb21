package com.cybertek.tests.day5_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Introduction {

    @BeforeMethod
    public void setupMethod() {
        System.out.println("Before method is running...");
    }

    @AfterMethod
    public void teardownMethod() {
        System.out.println("After method is running...");
    }

    @BeforeClass
    public void setupClass() {
        System.out.println("Before class is running...");
    }

    @AfterClass
    public void teardownClass() {
        System.out.println("After class is running...");
    }

    @Test
    public void test1() {
        System.out.println("Running test 1....");
    }

    @Test
    public void test2() {
        System.out.println("Running test 2....");
    }

    @Test
    public void test3() {
        System.out.println("Running test 3...");

        String str1 = "hello";
        String str2 = "hello";
        String str3 = "hello";

        //assertTrue: expects a boolean value to be passed.

        Assert.assertTrue(str1.equals(str2), "SELF NOTE TO OURSELVES IF THIS FAILS I KNOW WHAT FAILED");

        //AssertEquals: expects two arguments the same type: String VS String etc.
        Assert.assertEquals(str1, str3, "Asserting with assertEquals on line 56");

        //the last string argument will be accepted "as failure message"



    }

}
