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



        FoodOrder foodOrder = new FoodOrder("Water",3);
        FoodOrder foodOrder2 = new FoodOrder("Cola",2);
        System.out.println(FoodOrder.total(List.of(foodOrder2,foodOrder)));

        HackerHarryFoodOrder hackerHarryFoodOrder = new HackerHarryFoodOrder("Water",3);
        HackerHarryFoodOrder hackerHarryFoodOrder2 = new HackerHarryFoodOrder("Cola",2);
        System.out.println(HackerHarryFoodOrder.total(List.of(hackerHarryFoodOrder2,hackerHarryFoodOrder)));




    }
}
