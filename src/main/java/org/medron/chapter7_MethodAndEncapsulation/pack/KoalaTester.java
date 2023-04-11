package org.medron.chapter7_MethodAndEncapsulation.pack;

public class KoalaTester {
    public static void main(String[] args) {
        Koala k = new Koala();
        System.out.println(k.c);
        k = null;
        System.out.println(k.c);
        System.out.println(KoalaTester.class.getPackage().getName());



    }

}
