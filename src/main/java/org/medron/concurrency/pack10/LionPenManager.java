package org.medron.concurrency.pack10;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S1602","java:S1481","java:S112","java:S1854"})

public class LionPenManager {
    private void removeLions(){
        System.out.println("Removing lions");
    }
    private void cleanPen(){
        System.out.println("Cleaning the pen");
    }
    private void addLions(){
        System.out.println("Adding lions");
    }
    private void performTask(){
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(3);
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(3,() -> System.out.println("▼"));
        try {
            cleanPen();
            cyclicBarrier1.await();
            cleanPen();
            cyclicBarrier2.await();
            addLions();
        } catch (InterruptedException | BrokenBarrierException e) {
            // Handle checked exceptions here
        }

    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(5);
            var manager = new LionPenManager();
            for (int i = 0; i < 5; i++)
                service.submit(() -> manager.performTask());
        } finally {
            if (service != null) service.shutdown();
        }

    }
}
