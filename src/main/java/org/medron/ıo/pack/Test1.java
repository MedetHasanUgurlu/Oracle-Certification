package org.medron.ıo.pack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;

@SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S1602","java:S1481","java:S112","java:S1854","java:S3655","java:S125"})

public class Test1 {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\Users\\mdths\\IdeaProjects\\Oracle Certification\\src\\main\\java\\org\\medron\\ıo\\pack\\test.txt")));

        System.out.println(bufferedReader.readLine());

    }
}
