package org.medron.chapter8_ClassDesign.pack4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private String name;
    private String surName;
    {
        name="Jesus";

        System.out.println("I am no args constructor.");
    }
}
