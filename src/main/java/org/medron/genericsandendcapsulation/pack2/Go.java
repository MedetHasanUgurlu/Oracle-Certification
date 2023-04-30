package org.medron.genericsandendcapsulation.pack2;
import java.util.HashMap;
import java.util.Map;
public class Go {
    public static void main(String[] args) {
        String s = "Medet";
        char[] strings = s.toCharArray();
        Map<Character,Integer> maps= new HashMap<>();

        for (Character c : strings) {
            if(maps.containsKey(c)){
                maps.put(c, maps.get(c)+1);
            }else{
                maps.put(c,1);
            }
        }

        System.out.println(maps.values());
    }
}
