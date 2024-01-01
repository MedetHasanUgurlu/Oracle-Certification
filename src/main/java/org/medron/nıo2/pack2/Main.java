package org.medron.nıo2.pack2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(X.multiple(6));
//
//        try(Stream<Path> stream = Files.list(Path.of("/home"))){
//            System.out.println(stream.toString());
//        }



        String s = "ABCDEFGHJKLMNOPRSTVYZX";
        System.out.println(s.substring(3,6));
        System.out.println(s.substring(3));


    }
}
