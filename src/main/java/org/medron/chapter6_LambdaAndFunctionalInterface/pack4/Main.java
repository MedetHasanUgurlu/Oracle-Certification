package org.medron.chapter6_LambdaAndFunctionalInterface.pack4;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> bunnies = new ArrayList<>();
        bunnies.add("long ear");
        bunnies.add("floppy");
        bunnies.add("hoppy");
        bunnies.removeIf((String s) -> s.startsWith("f"));
        System.out.println(bunnies);


        List<Student> students = new ArrayList<>();
        students.add(new Student("Medet","Ugurlu",27707711l));
        students.add(new Student("Kudret","Ugurlu",12212l));
        students.add(new Student("Metehan","Ugurlu",21212l));
        students.sort((o1, o2) -> o1.getTc().compareTo(o2.getTc()));
        System.out.println(students);

        Set<String> set = Set.of("mickey", "minnie");
        List<String> list = new ArrayList<>(set);

        set.forEach(s -> System.out.println(s));
        list.forEach(s -> System.out.println(s));


    }
}
