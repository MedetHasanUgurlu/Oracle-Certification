# Lambda and Functional Interface
***
 "One Way Out" \
**Kino Loy** 


## Writeing Simple Lambda
These two lines do the exact same thing.

    a -> a.canHop()
    (Animal a) -> { return a.canHop(); }



> Here’s a fun fact: `s -> {}` is a valid lambda. If there is no
code on the right side of the expression, you don’t need
the semicolon or return statement.

### Invalid Lambda

    a,b -> a.startsWith("tests")                MISSING PARANTHESES
    a -> {a.startsWith("test");}                MISSING RETURN
    a -> {return a.startsWith("test")}          MISSING SEMICOLON



## Introducing Functional Interfaces
    
    boolean test(Animal a);


Lambdas work with interfaces that have only one abstract
method. These are called functional interfaces.\
**_Single Abstract Method (SAM)_** rule.

### Predicate
    @FunctionalInterface
    public interface Predicate<T>{
        boolean test(T t);
    }
### Consumer
    @FunctionalInterface
    public interface Consumer<T>{
        boolean test(T t);
    }
### Supplier
    @FunctionalInterface
    public interface Supplier<T>{
        T get();
    }

### Comparator
    @FunctionalInterface
    public interface Comparator<T> {
        int compare(T o1, T o2);
    }

> The Comparator interface existed prior to lambdas being
added to Java. As a result, it is in a different package. You
can find Comparator in `java.util`.


## Working with Variables in Lambdas

### LOCAL VARIABLES INSIDE THE LAMBDA BODY

That block can have anything that is valid in a normal Java block, including local
variable declarations.

    (a, b) -> { int c = 0; return 5;}

<br>

**_Example_**\
Find mistakes.

    public void variables(int a) {
        int b = 1;
        Predicate<Integer> p1 = a -> {
            int b = 0;
            int c = 0;
            return b == c;
        }
    }
_**Result**_\
The variable a was already used in this scope as a method parameter, so it cannot be reused.\
Code attempts to redeclare local variable b.\
The variable p1 is missing a semicolon at the end. There is a semicolon before the }, but that is inside the block.
**So beware!**

### VARIABLES REFERENCED FROM THE LAMBDA BODY
Lambda bodies are allowed to reference some variables from
the surrounding code.

    public class Crow {
        private String color;
        public void caw(String name) {
            String volume = "loudly";
            Consumer<String> consumer = s -> System.out.println(name + " says " + volume + " that she is " + color);
        }
    }

> Method parameters and local variables are allowed to be
referenced if they are _**effectively final**_. This means that the
value of a variable doesn’t change after it is set, regardless of
whether it is explicitly marked as `final`.


    public class Crow {
        private String color;

        public void caw(String name) {
            String volume = "loudly";
            name = "Caty";
            color = "black";
        
            Consumer<String> consumer = s -> System.out.println(name + " says " + volume + " that she is " + color);
        volume = "softly";
        }
     }

`name` is not effectively final because it is set on
`name = "Caty"`. However, the compiler error occurs on `Consumer<String> consumer = s -> System.out.println(name + " says " + volume + " that she is " + color);`
 The variable is no longer effectively final, so the lambda is not allowed to use
the variable.\
The `variable` volume is not effectively final either

<div align="center">
<h4>Rules for accessing a variable from a
lambda body inside a method</h4>
    <table>
        <th>Variable Type</th>
        <th>Rule</th>
        <tr>
            <td>Instance variable</td>
            <td>Allowed</td>
        </tr>
        <tr>
            <td>Static variable</td>
            <td>Allowed</td>
        </tr>
        <tr>
            <td>Local variable</td>
            <td>Allowed if effectively final</td>
        </tr>
        <tr>
            <td>Method parameter</td>
            <td>Allowed if effectively final</td>
        </tr>
        <tr>
            <td>Lambda parameter </td>
            <td>Allowed</td>
        </tr>
    </table>
</div>

## Calling APIs with Lambdas

### removeIf()
List and Set declare a removeIf() method that takes a
Predicate.

    List<String> bunnies = new ArrayList<>();
    bunnies.add("long ear");
    bunnies.add("floppy");
    bunnies.add("hoppy");
    System.out.println(bunnies); // [long ear, floppy, hoppy]
    bunnies.removeIf(s -> s.charAt(0) != 'h');
    System.out.println(bunnies); // [hoppy]

### sort()
While you can call `Collections.sort(list)`, you can now sort
directly on the list object.

    List<String> bunnies = new ArrayList<>();
    bunnies.add("long ear");
    bunnies.add("floppy");
    bunnies.add("hoppy");
    System.out.println(bunnies); // [long ear, floppy, hoppy]
    bunnies.sort((b1, b2) -> b1.compareTo(b2));
    System.out.println(bunnies); // [floppy, hoppy, long ear]


> There is not a sort method on `Set` or Map. Neither of those types
has indexing, so it wouldn’t make sense to sort them.

### forEach()
It takes a Consumer and calls that
lambda for each element encountered.

    List<String> bunnies = new ArrayList<>();
    bunnies.add("long ear");
    bunnies.add("floppy");
    bunnies.add("hoppy");
    
    bunnies.forEach(b -> System.out.println(b));
    System.out.println(bunnies);

For a `Map`, you have to choose whether you want to go through
the keys or values.

    Map<String, Integer> bunnies = new HashMap<>();
    bunnies.put("long ear", 3);
    bunnies.put("floppy", 8);
    bunnies.put("hoppy", 1);
    bunnies.keySet().forEach(b -> System.out.println(b));
    bunnies.values().forEach(b -> System.out.println(b));

> Java has a functional interface called `BiConsumer`. It works just like
`Consumer` except it can take two parameters. This
functional interface allows you to use `forEach()` with
key/value pairs from Map.

    Map<String, Integer> bunnies = new HashMap<>();
    bunnies.put("long ear", 3);
    bunnies.put("floppy", 8);
    bunnies.put("hoppy", 1);
    bunnies.forEach((k, v) -> System.out.println(k + " " + v));















[«« Go Back ««](https://github.com/MedetHasanUgurlu/Oracle-Certification) 

