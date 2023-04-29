# Generics and Collections
<div align="center">
<table>
<th>Functional Interface</th>
<th>Return Type</th>
<th>Method Name</th>
<th>Parameters</th>
<tr>
<td>Supplier &lt T&gt </td>
<td>T</td>
<td>get()</td>
<td>0</td>
</tr>

<tr>
<td>Consumer &lt T&gt </td>
<td>void</td>
<td>accept(T)</td>
<td>(T)</td>
</tr>

<tr>
<td>BiConsumer &lt T,U&gt </td>
<td>void</td>
<td>accept(T,U)</td>
<td>(T,U)</td>
</tr>
<tr>
<td>Predicate &lt T&gt </td>
<td>boolean</td>
<td>test(T)</td>
<td>(T)</td>
</tr>

<tr>
<td>BiPredicate &lt T&gt </td>
<td>boolean</td>
<td>test(T,U)</td>
<td>(T,U)</td>
</tr>

<tr>
<td>Function &lt T,R&gt </td>
<td>R</td>
<td>apply(T)</td>
<td>(T)</td>
</tr>
<tr>
<td>BiFunction &lt T,U,R&gt </td>
<td>R</td>
<td>apply(T,U)</td>
<td>(T,U)</td>
</tr>
<tr>
<td>UnaryOperator &lt T&gt </td>
<td>T</td>
<td>apply(T)</td>
<td>(T)</td>
</tr>


</table>
</div>

<br>

* Remember that :: is like a lambda, and it is used for
deferred execution with a functional interface.
* There are four formats for method references: 
  1) Static methods
  2) Instance methods on a particular instance 
  3) Instance methods on a parameter to be determined at runtime 
  4) Constructors 

### CALLING STATIC METHODS
* The Collections class has a static method that can be used for
  sorting.
![img.png](img.png)
    

    List<Integer> list = new ArrayList<>();
    list.add(3);
    list.add(1);
    list.add(5);
    Consumer<List<Integer>> consumer = integers -> Collections.sort(integers);
    consumer.accept(list);
    list.stream().forEach(System.out::println);
###### Result
**1\
3\
5**


> we reference a method with one parameter, and
Java knows that it's like a lambda with one parameter.
Additionally, Java knows to pass that parameter to the method.

### CALLING INSTANCE METHODS ON A PARTICULAR OBJECT
* The String class has a startsWith() method that takes one
  parameter and returns a boolean. Conveniently, a Predicate is a
  functional interface that takes one parameter and returns a
  boolean.
![img_1.png](img_1.png)


    String s = sc.nextLine();
    Predicate<String> predicate = s::startsWith;
    System.out.println(predicate.test("k"));

* A method reference doesn't have to take any parameters. In
  this example, we use a Supplier, which takes zero parameters
  and returns a value
![img_2.png](img_2.png)


        Supplier<Integer> lambdaSupplier = () -> random.nextInt();
        Supplier<Integer> methodRef = random::nextInt;
        System.out.println(lambdaSupplier.get());
        System.out.println(methodRef.get());
###### Result
**-657562234\
-80164351**

> Since the methods on Random are instance methods, we call the
method reference on an instance of the Random class.

### CALLING INSTANCE METHODS ON A PARAMETER
* This time, we are going to call an instance method that doesn't
  take any parameters. The trick is that we will do so without
  knowing the instance in advance.
![img_3.png](img_3.png)

        Predicate<String> isEmptyLambda = s -> s.isEmpty();
        Predicate<String> isEmptyMethodRef = String::isEmpty;
        System.out.println(isEmptyMethodRef.test(""));
        System.out.println(isEmptyLambda.test(""));

###### Result
**true\
true**

> It looks like a static method, but it isn't. Instead, Java
knows that isEmpty() is an instance method that does not take
any parameters. Java uses the parameter supplied at runtime
as the instance on which the method is called.

* You can even combine the two types of instance method
  references. We are going to use a functional interface called a
  BiPredicate, which takes two parameters and returns a
  boolean.
  ![img_4.png](img_4.png)
* 