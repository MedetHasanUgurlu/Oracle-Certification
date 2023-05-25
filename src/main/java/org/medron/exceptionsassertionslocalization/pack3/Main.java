package org.medron.exceptionsassertionslocalization.pack3;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        Locale us = new Locale("en","US");
        Locale france = new Locale("fr","FR");
        printWelcomeMessage(france);


    }
    public static void printWelcomeMessage(Locale locale){
        ResourceBundle rb = ResourceBundle.getBundle("Zoo",locale);
        System.out.println(rb.getString("hello")+ ", " + rb.getString("open"));
    }
}
