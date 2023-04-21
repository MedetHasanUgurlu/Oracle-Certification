package org.medron.classdesign.pack5;

public class Home {
    private final int room ;

    static {
        System.out.println("Home static");

    }
    {
        System.out.println("Home constructor");
        room =15;
    }

    public static void main(String[] args) {
        Home home = new Home();
    }
}
