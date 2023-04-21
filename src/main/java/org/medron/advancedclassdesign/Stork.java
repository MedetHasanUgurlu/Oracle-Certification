package org.medron.advancedclassdesign;

public class Stork extends Bird{
    private String species;
    public Stork(String name,String species){
        super(name);
        this.species = species;
    }
    @Override
    public void makeSound() {
        System.out.println("Stork sound.");
    }
}
