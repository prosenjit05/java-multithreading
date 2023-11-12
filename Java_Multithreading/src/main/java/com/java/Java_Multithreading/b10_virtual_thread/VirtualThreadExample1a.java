package com.java.Java_Multithreading.b10_virtual_thread;

public class VirtualThreadExample1a {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> System.out.println("Inside thread: " + Thread.currentThread());
        Thread platformThread = Thread.ofVirtual().unstarted(runnable);

        platformThread.start();
        platformThread.join();
    }

}
