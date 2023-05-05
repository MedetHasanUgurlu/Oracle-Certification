package org.medron.genericsandendcapsulation.pack5;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Elephant {
    private int id;


    public <T> void  test(T t){
        List<T> list = new ArrayList<>();
        list.add(t);
        System.out.println(t);
    }


}
