package org.medron.ıo.pack4;

import java.io.Console;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
//        Scanner sc= new Scanner(System.in);
//        String s = sc.next();
//        System.out.println(s);
        Console console = System.console();
        if(console != null){
            String text = console.readLine();
            console.writer().println("Entered text: " + text);
        }




    }
}
