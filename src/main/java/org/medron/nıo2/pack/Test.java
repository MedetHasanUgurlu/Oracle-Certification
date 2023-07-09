package org.medron.nıo2.pack;

import java.nio.file.*;

public class Test {
    public static void main(String[] args) {
        Path path = Paths.get("../../../../Oracle Certification/src/main/ ");
        System.out.println(Files.exists(path,LinkOption.NOFOLLOW_LINKS));

    }
}
