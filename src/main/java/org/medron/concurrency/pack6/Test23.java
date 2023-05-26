package org.medron.concurrency.pack6;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

@SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S1602","java:S1481","java:S112","java:S1854"})

public class Test23 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Random random = new Random();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Callable<Integer> integerCallable = () -> random.nextInt(100);
        Callable<Integer> integerCallable2 = () -> random.nextInt(100);
        Callable<Integer> integerCallable3 = () -> random.nextInt(100);

        List<Future<Integer>> futureList = executor.invokeAll(List.of(integerCallable,integerCallable2,integerCallable3));
        for (Future<Integer> integerFuture : futureList) {
            //System.out.println(integerFuture.get());
        }

        Integer future = executor.invokeAny(List.of(integerCallable,integerCallable2,integerCallable3));
        System.out.println(future);


        executor.shutdown();
    }
}
