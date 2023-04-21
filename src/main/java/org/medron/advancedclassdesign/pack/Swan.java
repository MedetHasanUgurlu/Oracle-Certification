package org.medron.advancedclassdesign.pack;

public class Swan extends Bird implements Swim{
    @Override
    int getType() {
        return 0;
    }

    @Override
    boolean canSwoop() {
        return false;
    }

    @Override
    public void Swim() {

    }

    @Override
    public void fly() {

    }
}
