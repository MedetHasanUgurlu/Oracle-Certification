package org.medron.chapter8_ClassDesign.pack8;
import java.util.ArrayList;
import java.util.List;
public class Eagle extends Bird{

    public int fly(int x) {
        return x;
    }

    @Override
    public void eat(int food) throws RuntimeException {
        super.eat(food);
    }

    public static void main(String[] args) {
        List<Integer>  list = new ArrayList<>(); //Implicit Cast
        ArrayList<Integer> arrayList = (ArrayList<Integer>) list; //Explicit Cast
        list.add(1);
        list.add(2);
        arrayList.stream().forEach(System.out::println);
        Bird bird = new Bird();
        Eagle eagle = new Eagle();
        if(eagle instanceof Bird){
            System.out.println("Yeap");
        }
    }
}
