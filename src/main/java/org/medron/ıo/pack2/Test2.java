package org.medron.ıo.pack2;

import java.io.*;

public class Test2 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\mdths\\IdeaProjects\\Oracle Certification\\src\\main\\java\\org\\medron\\ıo\\pack\\test.txt");
//        byte[] bytes = {1,0,1,1,0,0};
//
//        try( FileOutputStream fileWriter = new FileOutputStream(file)){
//            fileWriter.write(bytes);
//        }
//
//        try (
//                var fis = new FileOutputStream("zoo-banner.txt");
//                var bis = new BufferedOutputStream(fis);
//                var ois = new ObjectOutputStream(bis)) {
//
//            ois.writeObject("Hello");
//        }
//        try (var ois = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("zoo-banner.txt")))) {
//            ois.writeObject("Hello");
//        }







    }

    public void copy(File src,File destination) throws IOException {
        try(
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(src));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destination));
        ){
            byte[] bytes = new byte[1024];
            int b ;
            while ((b = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,b);
                bufferedOutputStream.flush();
            }

        }

    }

}
