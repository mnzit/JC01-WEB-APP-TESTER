package com.ggic.tester;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executor = Executors.newFixedThreadPool(100);

        List<Future<String>> futures = executor.invokeAll(IntStream.range(1, 100)
                .mapToObj((i) -> new ApiTest())
                .collect(Collectors.toList()));

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
    }
}
