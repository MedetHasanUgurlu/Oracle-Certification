package org.medron.chapter8_ClassDesign.pack8;

public class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
    public void eat(int food) throws RuntimeException {
        System.out.println("Bird is eating "+food+" units of food");
    }

}
