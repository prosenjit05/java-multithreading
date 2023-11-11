package com.java.Java_Multithreading.a8_lock_free_algorithms;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceExample1 {

    public static void main(String[] args) {
        String oldName = "old name";
        String newName = "new name";
        AtomicReference<String> atomicReference = new AtomicReference<>(oldName);

        atomicReference.set("unexpected name");
        if (atomicReference.compareAndSet(oldName, newName)) {
            System.out.println("New value is " + atomicReference.get());
        } else {
            System.out.println("Nothing Changed");
        }
    }

}
