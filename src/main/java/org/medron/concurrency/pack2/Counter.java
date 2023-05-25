package org.medron.concurrency.pack2;

public class Counter {
    public static int count = 0;

    public synchronized void increase(){
        count++;
    }

    public void thread1(){
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increase();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increase();
            }
        });

        thread.start();
        thread2.start();

        try {
            thread2.join();
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.thread1();
    }

}
