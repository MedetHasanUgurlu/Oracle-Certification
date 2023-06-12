package org.medron.concurrency.pack10;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S1602","java:S1481","java:S112","java:S1854"})
public class Test32 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(5);
        integerList.add(7);

        for (Integer integer : integerList) {
            System.out.println(integer);
            integerList.add(76);
        }


        List<Integer> integers = new CopyOnWriteArrayList<>(List.of(2,5,7));
        for (Integer integer : integers) {
            System.out.println(integer);
            integers.add(76);
        }
    }
}
