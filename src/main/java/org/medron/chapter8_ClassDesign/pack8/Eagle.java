package org.medron.chapter8_ClassDesign.pack8;

public class Eagle extends Bird{

    public int fly(int x) {
        return x;
    }

    @Override
    public void eat(int food) throws RuntimeException {
        super.eat(food);
    }
}
