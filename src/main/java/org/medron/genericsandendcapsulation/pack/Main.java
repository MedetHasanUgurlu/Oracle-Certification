package org.medron.genericsandendcapsulation.pack;
import java.util.*;
import java.util.function.*;

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

        BiPredicate<String,String> isStartWithLambda = (s, s2) -> s.startsWith(s2);
        BiPredicate<String,String> isStartWithMethod = String::startsWith;
        System.out.println(isStartWithLambda.test("Kale","L"));
        System.out.println(isStartWithMethod.test("Kale","L"));

        Supplier<List<String>> getListByLambda = () -> new ArrayList<>();
        Supplier<List<String>> getListByMethodRef = ArrayList::new;

        List<String> lambaList = getListByLambda.get();
        lambaList.add("Mehmet");
        System.out.println(lambaList);

        List<String> methodList = getListByMethodRef.get();
        methodList.add("Metehan");
        System.out.println(methodList);

        IntFunction<List<String>> trickyMricky = ArrayList::new;
        var x = trickyMricky.apply(5);

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(2);
        integers.add(4);


        List<String> bags = new ArrayList<>();
        bags.add("Book");
        bags.add("Pencil");
        bags.add("Eraser");
        bags.add("Beans");
        bags.add("Ruler");
        bags.removeIf(s -> s.startsWith("B"));
        bags.forEach(System.out::println);

        integers.replaceAll(integer -> integer*2);
        integers.forEach(System.out::println);

        TreeSet<String> animals = new TreeSet<>();
        animals.add("pandas");
        animals.add("lion");
        animals.add("zebras");

        TreeSet<Integer> integerTreeSet = new TreeSet<>();
        integerTreeSet.add(1);
        integerTreeSet.add(6);
        integerTreeSet.add(4);
        integerTreeSet.forEach(System.out::println);



















    }
}
