package org.medron.concurrency.pack6;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S1602","java:S1481","java:S112","java:S1854"})

public class Test24 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        Runnable runnable = () -> System.out.println("Runnable-1 is running"+"Time: "+ LocalDateTime.now().getSecond());
        Runnable runnable2 = () -> System.out.println("Runnable-2 is running");
        Runnable runnable3 = () -> System.out.println("Runnable-3 is running");
        scheduledExecutorService.schedule(runnable,5,TimeUnit.SECONDS);
    }
}
