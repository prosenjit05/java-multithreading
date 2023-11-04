package com.java.Java_Multithreading.a2_thread_coordination;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());

        thread.start();

        thread.interrupt();
    }

    private static class BlockingTask implements Runnable {

        @Override
        public void run() {
            // do blocking tasks
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                System.out.println("Exiting blocking thread!");
                throw new RuntimeException(e);
            }
        }
    }

}
