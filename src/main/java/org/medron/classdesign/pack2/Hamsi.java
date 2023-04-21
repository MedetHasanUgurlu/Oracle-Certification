package org.medron.classdesign.pack2;

import org.medron.classdesign.pack.Fish;

public class Hamsi extends Fish {
    public Hamsi(int age) {
        super(age);
    }

    public static void main(String[] args) {
        Hamsi hamsi = new Hamsi(6);



        hamsi.size = 458;
        System.out.println(hamsi.toString());
    }
}
