package org.medron.exceptionsassertionslocalization.pack2;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        double price = 48;
        var myLocale = NumberFormat.getCurrencyInstance(new Locale("tr","TR"));
        System.out.println(myLocale.format(price));

    }
}
