package com.example.designpatterns.creational;

/**
 * The Singleton class demonstrates the Singleton pattern.
 * This pattern ensures that a class has only one instance and
 * provides a global point of access to that instance.
 */
public class Singleton {
    // Static variable to store the single instance of the class
    private static Singleton instance;

    /**
     * Private constructor prevents instantiation from outside the class.
     * This is a key aspect of the Singleton pattern.
     */
    private Singleton() {
        // Initialization, if necessary
    }

    /**
     * Static method to get the single instance of the class.
     * If the instance hasn't been created yet, it's created on the first call.
     *
     * @return the single instance of the Singleton class
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * Example instance method.
     * In a real application, this could contain more complex logic.
     */
    public void showMessage() {
        System.out.println("Hello, I am a Singleton object!");
    }
}

/**
 * Class to demonstrate the usage of Singleton.
 */
