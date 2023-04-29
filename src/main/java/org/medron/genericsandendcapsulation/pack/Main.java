package org.medron.genericsandendcapsulation.pack;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        //DuckHelper.teach("Medron",s -> System.out.println(s));
        // Or
        // DuckHelper.teach("Medron",System.out::println);

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(5);
        Consumer<List<Integer>> consumer = integers -> Collections.sort(integers);
        consumer.accept(list);
        list.stream().forEach(System.out::println);

        //String s = sc.nextLine();
        //Predicate<String> predicate = s::startsWith;
        //System.out.println(predicate.test("k"));

        Supplier<Integer> lambdaSupplier = () -> random.nextInt();
        Supplier<Integer> methodRef = random::nextInt;
        System.out.println(lambdaSupplier.get());
        System.out.println(methodRef.get());

        Predicate<String> isEmptyLambda = s -> s.isEmpty();
        Predicate<String> isEmptyMethodRef = String::isEmpty;
        System.out.println(isEmptyMethodRef.test(""));
        System.out.println(isEmptyLambda.test(""));


    }
}
