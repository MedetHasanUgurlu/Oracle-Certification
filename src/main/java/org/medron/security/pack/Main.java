package org.medron.security.pack;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        var favorites = new ArrayList<String>();
//        favorites.add("Apples");
//        Animal animal = new Animal(favorites);
//
//        System.out.println(animal.getFavoriteFoodsCount());
//        favorites.clear();
//        System.out.println(animal.getFavoriteFoodsCount());

        Console console = System.console();
        String dir = console.readLine();
        System.out.println(dir);
    }
}
