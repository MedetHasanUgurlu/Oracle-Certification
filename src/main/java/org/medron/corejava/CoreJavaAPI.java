package org.medron.corejava;

import java.util.Arrays;

public class CoreJavaAPI {
    public static void main(String args) {
        StringBuilder stringBuilder = new StringBuilder();
        for(char a = 'a';a<='z';a++){
            stringBuilder.append(a);
        }
        System.out.println(stringBuilder);
        //Stringbuffer slower than StringBuilder so we should use instead of it.
        String x = "El psy congroo";
        String y = "El psy congroo";
        if (x==y){
            System.out.println("Equal");
        }
        String[] bugs = {"cricket","beetle","ladybug"};

        System.out.println(Arrays.compare(new int[]{1,2,7},new int[]{1,2,4}));




    }
    /*
    ¥ Application Programming Interface (API),an interface refers to a group of classes or Java interface
    definitions giving you access to a service or functionality.


    System.out.println(1 + 2); // 3
    System.out.println("a" + "b"); // ab
    System.out.println("a" + "b" + 3); // ab3
    System.out.println(1 + 2 + "c"); // 3c
    System.out.println("c" + 1 + 2); // c12

    ¥
     */
}
