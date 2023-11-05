package com.java.Java_Multithreading.a3_performance_optimisation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ThroughputOptimisation {

    private static final String INPUT_FILE = "./src/main/resources/war_and_peace.txt";

    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
        startServer(text);
    }

}
