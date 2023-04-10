package org.medron.chapter6_LambdaAndFunctionalInterface.pack;

public class HopperCheckTrait implements CheckTrait{
    @Override
    public boolean test(Animal animal) {
        return animal.isCanHop();
    }
}
