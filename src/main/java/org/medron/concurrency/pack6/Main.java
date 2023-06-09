package org.medron.concurrency.pack6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S1602","java:S1481","java:S112","java:S1854"})

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<?> future = executor.submit(() -> {
            return 6;
        });

        executor.execute(() -> System.out.println("NO RETURN"));
        Future<?> result = executor.submit(() -> { return 5;});
        System.out.println(result.get());








        Runnable runnable = () -> System.out.println("Hello World");
        Runnable runnable2 = () -> {int i =1; i++;};
        Runnable runnable3 = () -> {return;};
        Runnable runnable4 = () -> {};













    }
}
