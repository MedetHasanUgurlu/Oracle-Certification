package org.medron.concurrency.pack10;

import java.util.List;

@SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S1602","java:S1481","java:S112","java:S1854"})

public class Test33 {
    public static void main(String[] args) {
        long initial = System.currentTimeMillis();
        List.of(1,2,3,4,5).stream().unordered().forEach(integer -> {System.out.println(doDouble(integer));});
        System.out.println("Time: "+ (System.currentTimeMillis()-initial)/1000);
    }

    public static int doDouble(int i) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return i*2;
    }
}
