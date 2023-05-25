package org.medron.concurrency.pack3;

@java.lang.SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S112"})

public class Main {
    private final Object lock = new Object();

    public void a() throws InterruptedException {
        synchronized (lock){
            System.out.println("a method is working...");
            Thread.sleep(2000);
            lock.wait();
            System.out.println("a method is reworking...");
        }

    }
    public void b() throws InterruptedException {
        synchronized (lock){
            System.out.println("b method is working...");
            Thread.sleep(2000);
            lock.notify();
            System.out.println("b method is notifying the a method");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Main main = new Main();
        Thread a = new Thread(() -> {
            try {
                main.a();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread b = new Thread(() -> {
            try {
                main.b();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        a.start();
        b.start();



    }
}
