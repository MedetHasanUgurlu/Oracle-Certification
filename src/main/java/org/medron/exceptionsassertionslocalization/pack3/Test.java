package org.medron.exceptionsassertionslocalization.pack3;

public class Test {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        // b = 5 a = 7
        b = a + b; // b=12
        a = b - a; // a= 7
        b = b - a;
        System.out.println(a);
        System.out.println(b);

    }
}
