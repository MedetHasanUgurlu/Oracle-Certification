package org.medron.chapter9_AdvancedClassDesign;


public abstract class Bird {
    private String name;

    public Bird(String name) {
        this.name = name;
    }

    public abstract void makeSound();



}
