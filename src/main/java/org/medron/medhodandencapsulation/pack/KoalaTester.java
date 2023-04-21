package org.medron.medhodandencapsulation.pack;

public class KoalaTester {
    public static void main(String[] args) {
        Koala k = new Koala();
        System.out.println(k.c);
        k = null;
        System.out.println(k.c);
        System.out.println(KoalaTester.class.getPackage().getName());



    }

}
