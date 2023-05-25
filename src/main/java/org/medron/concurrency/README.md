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

