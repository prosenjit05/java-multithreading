package com.javamultithread.MultiThreadRest.throughput;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@RestController
public class ThroughputOptimisation {

    private static final String INPUT_FILE = "./src/main/resources/war_and_peace.txt";
    private static final int NUMBER_OF_THREADS = 1;
    static String text = "";

    private final TaskExecutor globalTaskExecutor;

    @Autowired
    public ThroughputOptimisation(TaskExecutor globalTaskExecutor) {
        this.globalTaskExecutor = globalTaskExecutor;
    }

    //http://localhost:8000/search?word=afraid

    @GetMapping("/search")
    public ResponseEntity<String> getBookById(@RequestParam String word) throws InterruptedException, IOException, ExecutionException {
        CompletableFuture<Long> futureResult = new CompletableFuture<>();

        globalTaskExecutor.execute(() -> {
            try {
                text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            futureResult.complete(countWord(word));
        });

        return new ResponseEntity<>(futureResult.get().toString(), HttpStatus.OK);
    }

    private static long countWord(String word) {
        long count = 0;
        int index = 0;
        while (index >= 0) {
            index = text.indexOf(word, index);

            if (index >= 0) {
                count++;
                index++;
            }
        }
        return count;
    }

}
