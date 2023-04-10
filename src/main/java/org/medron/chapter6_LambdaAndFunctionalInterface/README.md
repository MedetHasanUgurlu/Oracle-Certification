# Lambda and Functional Interface
***
 "One Way Out"
 ##### _*Kino*_ 
***
Deferred execution means
that code is specified now but will run later. In this case, later is
when the print() method calls it.
***
These two lines do the exact same thing
a -> a.canHop()
(Animal a) -> { return a.canHop(); }
****
Here’s a fun fact: s -> {} is a valid lambda. If there is no
code on the right side of the expression, you don’t need
the semicolon or return statement.
***
![img.png](images/img.png)

Lambdas work with interfaces that have only one abstract
method. These are called functional interfaces.

* Predicate
![img_1.png](images/img_1.png)

* Consumer
![img_2.png](images/img_2.png)
* Supplier
![img_3.png](images/img_3.png)
* Comparator
![img_4.png](images/img_4.png)

* Descending sort


    Comparator<String> strings = (s1, s2) -> s2.compareTo(s1);
    Comparator<String> moreStrings = (s1, s2) -> - s1.compareTo(s2);
![img_5.png](images/img_5.png)
****
How many syntax errors do you see in this method?
![img_6.png](images/img_6.png)
  ***
Method parameters and local variables are allowed to be
referenced if they are effectively final.
* works
![img_7.png](images/img_7.png)
* compile error due to setting variable lost their final attribute.
![img_8.png](images/img_8.png)
![img_9.png](images/img_9.png)
![img_10.png](images/img_10.png)
***

