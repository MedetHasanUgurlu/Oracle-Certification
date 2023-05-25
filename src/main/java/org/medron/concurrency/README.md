# CONCURRENCY

**Multitask**: birçok process'in(işlem) aynı anda çalıştırılmasıdır. Oyun oynarken müzik dinlemek gibi.\
**Multithread**: bir process içinde bir çok çalışma ünitesi(thread) birlikte çalıştırmaktır. Wordde yazı yazarken yazdıklarımızın kontrol edilmesi. \
* Her process kendi memory space(heap) sahiptir. Processler birbirlerinin memory spacelerine(heap) erişemezler.
* Her thread processin oluşturduğu bellek alanına erişebilir ve ayrıca kendinin erişebileceği thread stack'i bulunur.


## THREAD OLUŞTURMA YONTEMLERI

<div align="center">
    <img src="img.png" alt="">
</div> 

### synchronized
<div align="center">
    <img src="img_1.png" alt="">
</div> 

### using multiple lock
    public final Object lock = new Object();
    public final Object lock2 = new Object();

<div align="center">
<img src="img_2.png">
</div>

### Thread pool

    ExecutorService executor = Executors.newFixedThreadPool(3);
    executor.submit(new Thread(...);
    executor.submit(new Thread(...);
    executor.submit(new Thread(...);
    executor.submit(new Thread(...);

    executor.shutdown();


> Only 2 executors will work another thread waits.

### wait and notify
>   wait() yellow light \
notify() green light

<div align="center">
<img src="img_3.png">
</div>


### deadlock

<div>
<img src="img_5.png">
</div>

### semaphore
Semophere controls the amount of thread which uses methods.\
**semaphore.acquire()**: If amount is zero don't accept the threads.
**semaphore.release()**: increase the amount by adding 1.

    Semaphore semaphore = new Semaphore(3);
    

<div align="center">
<img src="img_6.png">
<img src="img_7.png">
</div>