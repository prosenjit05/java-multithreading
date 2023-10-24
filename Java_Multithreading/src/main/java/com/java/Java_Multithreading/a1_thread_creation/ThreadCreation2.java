package com.java.Java_Multithreading.a1_thread_creation;

public class ThreadCreation2 {

    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();
    }

    public static class NewThread extends Thread {
        @Override
        public void run() {
            //Code that will run in  a new thread
            System.out.println("Hello from: " + Thread.currentThread().getName());
        }
    }

}
