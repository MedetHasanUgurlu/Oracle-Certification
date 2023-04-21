package org.medron.lambdaandfunctionalinterface.pack;

public class HopperCheckTrait implements CheckTrait{
    @Override
    public boolean test(Animal animal) {
        return animal.isCanHop();
    }
}
