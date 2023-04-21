package org.medron.classdesign.pack2;

public class House {
    private final int volume;
    private final String type;
    {
        this.volume = 10;
    }
    public House() {

        type = "happy";
    }

    public static void main(String[] args) {
        House house = new House();
        System.out.println(house.type);
        System.out.println(house.volume);
    }

}
