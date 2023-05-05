package org.medron.genericsandendcapsulation.pack5;

public class Main {
    public static void main(String[] args) {
        Elephant elephant = new Elephant();
        SizeLimitedCrate<Elephant,Integer> crate = new SizeLimitedCrate<>(elephant,15);
        elephant.test(String.class);


    }
}
