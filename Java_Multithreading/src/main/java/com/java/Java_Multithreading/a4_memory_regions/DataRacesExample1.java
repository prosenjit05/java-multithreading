package com.java.Java_Multithreading.a4_memory_regions;

public class DataRacesExample1 {

    public static void main(String[] args) {

    }

    private static class InventoryCounter {
        private int items = 0;

        Object lock = new Object();

        public void increment() {
            items++;
        }

        public void decrement() {
            items--;
        }

        public int getItems() {
            return items;
        }
    }

}
