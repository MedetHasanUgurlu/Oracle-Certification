package org.medron.concurrency.pack10;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

@SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S1602","java:S1481","java:S112","java:S1854"})

public class Test31 {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer,String> zoos = new ConcurrentHashMap<>();
        zoos.put(1,"Leon");
        zoos.put(2,"Monkey");
        zoos.put(3,"Elephant");

        for (Integer s : zoos.keySet()) {
            zoos.remove(s);
        }
        System.out.println("Size: "+zoos.size());


        // Part 2
        System.out.println("*******");
        Set<String> gardenAnimal = new ConcurrentSkipListSet<>();
        gardenAnimal.add("rabbit");
        gardenAnimal.add("gopher");
        System.out.println(gardenAnimal.stream().collect(Collectors.joining(",")));

        // Part 3
        System.out.println("******");
        Map<String,String> diet = new ConcurrentSkipListMap<>();
        diet.put("cola","water");
        diet.put("chocolate","fruit");
        diet.entrySet().stream().forEach(e ->{
            System.out.println("KEY: "+ e.getKey());
            System.out.println("VALUE: "+ e.getValue());
        });
    }
}
