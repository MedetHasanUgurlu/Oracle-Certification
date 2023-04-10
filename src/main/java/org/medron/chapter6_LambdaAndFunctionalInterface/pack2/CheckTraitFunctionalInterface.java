package org.medron.chapter6_LambdaAndFunctionalInterface.pack2;

import org.medron.chapter6_LambdaAndFunctionalInterface.pack.Animal;

@FunctionalInterface
public interface CheckTraitFunctionalInterface {
    boolean test(Animal animal);
}
