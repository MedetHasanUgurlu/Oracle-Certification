package org.medron.concurrency.pack;

public class Main {
    public static void main(String[] args) {
     Thread thread = new Thread(new Printer());
     thread.start();

     Thread thread2 = new Thread(new Printer2());
     thread2.start();

     Thread thread3 = new Thread(() -> {
         for (int i = 0; i < 10; i++) {
             System.out.println("Thread3-"+i);
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }
     });
     thread3.start();





        thread.start();
        thread2.start();
    }

}
