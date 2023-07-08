package org.medron.ıo.pack4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DemoFinal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        System.out.println(text);

    }
}
