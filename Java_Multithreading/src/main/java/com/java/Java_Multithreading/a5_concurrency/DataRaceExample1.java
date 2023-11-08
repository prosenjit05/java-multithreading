package com.java.Java_Multithreading.a5_concurrency;

public class DataRaceExample1 {

    public static void main(String[] args) {

    }

    public static class SharedClass {
        private int x = 0;
        private int y = 0;

        public void increment() {
            x++;
            y++;
        }

        public void checkForDataRace() {
            if (y > x) {
                System.out.println("y > x - Data Race is detected");
            }
        }
    }

}
