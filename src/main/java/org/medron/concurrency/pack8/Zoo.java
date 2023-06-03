package org.medron.concurrency.pack8;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S1602","java:S1481","java:S112","java:S1854"})
public class Zoo {
    private final Lock lock = new ReentrantLock();
    private int count;
    public void increase(){
        try{
            lock.lock();
            System.out.print(++count+" ");

        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.submit(zoo::increase);
        }
    }
}
