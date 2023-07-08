package org.medron.ıo;

import java.io.Console;

public class TestConsole {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null){
            System.out.println("null");
        }
    }
}
