package org.medron.concurrency.pack5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.concurrent.Semaphore;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrafikLambasi {

    private Semaphore semaphore;

    public void trafikLambasiOn(int id) throws InterruptedException {
        semaphore.acquire();
        System.out.println("Thread "+id+ " is ON");
        Thread.sleep(5000);
        semaphore.release();

    }
    public static void main(String[] args) throws InterruptedException {
        TrafikLambasi trafikLambasi = new TrafikLambasi(new Semaphore(3));
        Thread thread1= new Thread(() -> {
            try {
                trafikLambasi.trafikLambasiOn(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2= new Thread(() -> {
            try {
                trafikLambasi.trafikLambasiOn(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread3= new Thread(() -> {
            try {
                trafikLambasi.trafikLambasiOn(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread4= new Thread(() -> {
            try {
                trafikLambasi.trafikLambasiOn(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread5= new Thread(() -> {
            try {
                trafikLambasi.trafikLambasiOn(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread6= new Thread(() -> {
            try {
                trafikLambasi.trafikLambasiOn(6);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread7= new Thread(() -> {
            try {
                trafikLambasi.trafikLambasiOn(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
