package com.java.Java_Multithreading.a1_thread_creation;

public class ThreadCreation {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Code that will run in  a new thread
            }
        });
    }

}
