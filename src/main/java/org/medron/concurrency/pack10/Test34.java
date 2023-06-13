package org.medron.concurrency.pack10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


@SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S1602","java:S1481","java:S112","java:S1854","java:S3655","java:S125"})

public class Test34 {
    public static void main(String[] args) {
//        int b =0;
//        b = List.of(1,2,3,4,5,6).parallelStream().reduce((integer, integer2) -> integer-integer2).orElseThrow();
//        System.out.println(b);
//        System.out.println(List.of("w","o","l","f")
//                .parallelStream()
//                .reduce("X", String::concat));
//        System.out.println(List.of("w","o","l","f")
//                .stream()
//                .reduce("X", String::concat));

//
//        Stream<String> stream = Stream.of("b","i","r","d").parallel();
//        Set<String> set = stream.collect(ConcurrentSkipListSet::new,Set::add,Set::addAll);
//        System.out.println(set);
        System.out.println(Test34.getEven(IntStream.range(1,20).parallel()));



    }
    public static List<Integer> getEven(IntStream stream){
        List<Integer> data = Collections.synchronizedList(new ArrayList<Integer>());
        stream.filter(value -> value%2==0).forEach(data::add);
        return  data;
    }
}
