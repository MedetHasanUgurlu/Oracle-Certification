package org.medron.concurrency.pack7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S1602","java:S1481","java:S112","java:S1854"})
public class Wallet {
    private int balance;

    public void increase(){
        synchronized (this){
            System.out.print(++balance+" ");
        }
    }
    public synchronized void  increase2(){
        System.out.print(++balance+" ");
    }
    public static void main(String[] args) {
        Wallet wallet = new Wallet(0);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.submit(wallet::increase);
        }

        executor.shutdown();

    }


}
