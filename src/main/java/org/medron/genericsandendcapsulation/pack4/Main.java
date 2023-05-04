package org.medron.genericsandendcapsulation.pack4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Squirrel s1 = Squirrel.builder().species("A").weight(15).build();
        Squirrel s2 = Squirrel.builder().species("B").weight(10).build();
        Squirrel s3 = Squirrel.builder().species("A").weight(13).build();
        Squirrel s4 = Squirrel.builder().species("B").weight(9).build();
        Squirrel s5 = Squirrel.builder().species("B").weight(8).build();
        ArrayList<Squirrel> squirrels = new ArrayList<>();
        squirrels.add(s1);
        squirrels.add(s2);
        squirrels.add(s3);
        squirrels.add(s4);
        squirrels.add(s5);

        Comparator<Squirrel> squirrelComparator = Comparator.comparing(Squirrel::getSpecies).thenComparingInt(Squirrel::getWeight);
        Comparator<Squirrel> squirrelComparator1 = Comparator.comparingInt(Squirrel::getWeight);
        Collections.sort(squirrels,squirrelComparator1);
        squirrels.forEach(System.out::println);






    }
    public void x(){

    }
}
