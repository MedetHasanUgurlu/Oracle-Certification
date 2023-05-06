package org.medron.exceptionsassertionslocalization.pack;

public class Main {
    public static void main(String[] args) {
        try(CustomFileReader customFileReader = new CustomFileReader("Medron");) {
            System.out.println("Try Block");

        } catch (Exception e) {
            System.out.println("Catch Block");
        }finally {
            System.out.println("Finally Block");
        }
    }
}
