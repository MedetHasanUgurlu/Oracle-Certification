package org.medron.lambdaandfunctionalinterface.pack;

import org.medron.lambdaandfunctionalinterface.pack2.CheckTraitFunctionalInterface;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Kangroo",true,false);

        CheckTraitFunctionalInterface checkTraitFunctionalInterface = animal1 -> animal1.isCanHop();
        boolean b = checkTraitFunctionalInterface.test(animal);
        System.out.println(b);
    }
}
