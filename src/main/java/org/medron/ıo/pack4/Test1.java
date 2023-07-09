package org.medron.ıo.pack4;

import java.io.*;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws IOException {

//        Scanner sc= new Scanner(System.in);
//        String s = sc.next();
//        System.out.println(s);
//        Console console = System.console();
//        if(console != null){
//            String text = console.readLine();
//            console.writer().println("Entered text: " + text);
//        }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\mdths\\IdeaProjects\\Oracle Certification\\src\\main\\java\\org\\medron\\ıo\\pack4\\zoo.txt"));
        ) {
            writer.write(new char[5]);
        }

    }
}
