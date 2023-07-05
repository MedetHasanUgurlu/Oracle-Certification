package org.medron.corejava.pack;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"java:S112"})
public class Gorilla implements Serializable{

    private String name;
    public Gorilla(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void saveToFile(List<Gorilla> gorillas, File file) throws Exception {

        try(ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            for(Gorilla gorilla: gorillas){
                outputStream.writeObject(gorilla);
            }
        }
    }


    List<Gorilla> readFromFile(File file) throws Exception {
        List<Gorilla> gorillas = new ArrayList<>();
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
            while (true){
                var object = objectInputStream.readObject();
                if(object instanceof Gorilla){
                    gorillas.add((Gorilla) object);
                }
            }
        }catch (EOFException e){
            e.printStackTrace();
        }
        return gorillas;
    }
}
