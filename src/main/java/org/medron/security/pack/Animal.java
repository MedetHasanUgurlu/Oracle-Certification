package org.medron.security.pack;

import java.util.ArrayList;

public class Animal implements Cloneable{
    private final ArrayList<String> favoriteFoods;
    public Animal(ArrayList<String> favoriteFoods){
        this.favoriteFoods = (ArrayList) favoriteFoods.clone();
    }

    public int getFavoriteFoodsCount(){
        return favoriteFoods.size();
    }

    public String getFavoriteFoodsElement(int index){
        return favoriteFoods.get(index);
    }

}
