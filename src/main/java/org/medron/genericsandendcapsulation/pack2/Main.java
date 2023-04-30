package org.medron.genericsandendcapsulation.pack2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> integerQueue= new LinkedList<>();
        integerQueue.add(3);
        integerQueue.add(1);
        integerQueue.add(20);
        integerQueue.add(7);
        integerQueue.forEach(System.out::println);

        System.out.println("After peek");
        System.out.println(integerQueue.peek());
        System.out.println("-");
        integerQueue.forEach(System.out::println);
        System.out.println("After poll");
        System.out.println(integerQueue.poll());
        System.out.println("-");
        integerQueue.forEach(System.out::println);


        Map.ofEntries(Map.entry("1","Kestane")).forEach((s, s2) -> System.out.println(s+" "+s2));

    }
}
