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
ExecutorService threadlerin kaçar kaçar çalışacağını belirler. Bellekten kazanç sağlar. \
THreadlerin yönetilmesi için iyi bir servis. \
main() method is still an independent thread from the
ExecutorService.
> main() method is still an independent thread from the ExecutorService.

    ExecutorService executor = Executors.newFixedThreadPool(3);
    executor.submit(new Thread(...);
    executor.submit(new Thread(...);
    executor.submit(new Thread(...);
    executor.submit(new Thread(...);

    executor.shutdown();
> Only 3 executors will work another thread waits.


<div align="center">
<img src="img_9.png">
</div> 

_executor.shutdown()_ does not actually stop any task however _**executor.shutdownNow()**_ stops when we called.

### submit vs execute
<div align="center">
<img src="img_10.png">
</div>

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

### Callable and Future
> return value, that's all.
<div align="center">
<img src="img_8.png">
<img src="img_11.png">
</div>

### invokeAll vs invokeAny
> invokeAll() returns Future list however invokeAny() returns only one value.

<div align="center">
<img src="img_12.png">
</div>

