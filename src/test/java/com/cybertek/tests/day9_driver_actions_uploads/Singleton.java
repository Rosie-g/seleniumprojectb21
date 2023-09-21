package com.cybertek.tests.day9_driver_actions_uploads;

public class Singleton {

    // by making the constructor final we are limiting creating objects from this class
    private Singleton() {

    }

    // by making the String private, we can only reach this using getter method
    private static String word;

    // by creating getter method we will allow user to reach to String in the way we allow them
    public static String getWord() {

        if (word == null) {
            System.out.println("First time call. Word object is null " + "Assigning value to it now");
            word = "something";
        } else {
            System.out.println("Word already has a value");
        }
        return word;
    }


}
