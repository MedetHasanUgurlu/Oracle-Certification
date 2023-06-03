package org.medron.concurrency.pack7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S1602","java:S1481","java:S112","java:S1854"})

public class Sheep {
    private AtomicInteger sheepCount;
    public void addSheep(){
        System.out.print(sheepCount.incrementAndGet()+" ");
    }

    public static void main(String[] args) {
        Sheep sheep = new Sheep(new AtomicInteger(0));
        ExecutorService service = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 10; i++) {
            service.submit(sheep::addSheep);

        }

    }
}
