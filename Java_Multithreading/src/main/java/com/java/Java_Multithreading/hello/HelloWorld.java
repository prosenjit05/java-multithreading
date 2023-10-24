package com.java.Java_Multithreading.hello;

public class HelloWorld {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            // Code that will run in a new thread
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000); // Sleeps only thread2
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Code that will run in a new thread
        });

        thread1.start(); // Start thread1
        thread2.start(); // Start thread2
    }

}
