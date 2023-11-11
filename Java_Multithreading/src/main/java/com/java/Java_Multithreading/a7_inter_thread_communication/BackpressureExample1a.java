package com.java.Java_Multithreading.a7_inter_thread_communication;


import java.util.LinkedList;
import java.util.Queue;

public class BackpressureExample1a {

    public static void main(String[] args) {

    }

    private static class ThreadSafeQueue {
        private Queue<MatricesPair> queue = new LinkedList<>();
        private boolean isEmpty = true;
        private boolean isTerminate = false;

        public synchronized void add(MatricesPair matricesPair) {
            queue.add(matricesPair);
            isEmpty = false;
            notify();
        }

        public synchronized MatricesPair remove() {
            while (isEmpty && !isTerminate) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }

            if (queue.size() == 1) {
                isEmpty = true;
            }

            if (queue.size() == 0 && isTerminate) {
                return null;
            }

            System.out.println("queue size " + queue.size());

            return queue.remove();
        }

        public synchronized void terminate() {

        }

    }

    private static class MatricesPair {
        public float[][] matrix1;
        public float[][] matrix2;
    }

}
