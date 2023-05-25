package org.medron.concurrency.pack2;

public class Counter {
    public static int count = 0;
    public static int a =0;
    public static int b =0;
    public final Object lock = new Object();
    public final Object lock2 = new Object();


    public void increase(){
        synchronized (lock){
                try {
                    Thread.sleep(1);
                    a++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


        }
    }
    public void increase2(){
        synchronized (lock2){
                try {
                    Thread.sleep(1);
                    b++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


    }
    public void x(){

    }
    public void runThread(){
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                increase();
                increase2();
            }

        });


        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                increase();
                increase2();
            }
        });

        try {
            thread.start();
            thread2.start();
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        //TODO: ıncrease count to 2000 using threads
        Counter counter = new Counter();
        long i = System.currentTimeMillis();
        counter.runThread();
        long j = System.currentTimeMillis();

        System.out.println(j-i);
        System.out.println(Counter.a+Counter.b);




    }

}
