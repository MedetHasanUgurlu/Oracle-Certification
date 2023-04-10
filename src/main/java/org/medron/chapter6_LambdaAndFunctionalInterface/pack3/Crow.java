package org.medron.chapter6_LambdaAndFunctionalInterface.pack3;

import java.util.function.Consumer;
public class Crow {
    private String color;
    public void caw(final String name) {
        final String volume = "loudly";
        Consumer<String> consumer = s ->
                System.out.println(name + " says "
                        + volume + " that she is " + color);
        consumer.accept("s");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
