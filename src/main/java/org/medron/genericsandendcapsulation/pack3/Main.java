package org.medron.genericsandendcapsulation.pack3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        /*
        Duck duck1 = new Duck(4,"Merop");
        Duck duck2 = new Duck(2,"Losap");
        ArrayList<Duck> ducks = new ArrayList<>();
        ducks.add(duck1);
        ducks.add(duck2);
        ducks.forEach(System.out::println);
        System.out.println("After sort");
        Collections.sort(ducks);
        ducks.forEach(System.out::println);*/

        Duck duck1 = new Duck(4,"Merop");
        Duck duck2 = new Duck(2,"Losap");
        ArrayList<Duck> ducks = new ArrayList<>();
        ducks.add(duck1);
        ducks.add(duck2);
        System.out.println("*****");
        Comparator<Duck> duckComparator = (o1, o2) -> o1.getId()-o2.getId();
        Collections.sort(ducks,duckComparator);
        System.out.println("After sort");
        ducks.forEach(System.out::println);




    }
}
