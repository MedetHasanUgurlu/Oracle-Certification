package org.medron.concurrency.pack6;

import lombok.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S1602","java:S1481","java:S112","java:S1854"})

public class Test {
    private String name;
    public static Test test(){
        return new Test("test");
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<?> future = executor.submit(() -> {
                    });
        System.out.println(future.get());

        ExecutorService executor2 = Executors.newFixedThreadPool(1);
        Future<?> future2 =  executor2.submit(() -> 5);
        System.out.println(future2.get());


        executor.shutdown();
        executor2.shutdown();

    }

}
