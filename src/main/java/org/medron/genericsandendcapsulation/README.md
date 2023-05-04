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

        BiPredicate<String,String> isStartWithLambda = (s, s2) -> s.startsWith(s2);
        BiPredicate<String,String> isStartWithMethod = String::startsWith;
        System.out.println(isStartWithLambda.test("Kale","L"));
        System.out.println(isStartWithMethod.test("Kale","L"));

###### Result
**false\
false**





> functional interface takes two parameters, Java has to
figure out what they represent. The first one will always be the
instance of the object for instance methods. Any others are to
be method parameters.

### CALLING CONSTRUCTORS
* A constructor reference is a special type of method reference
  that uses new instead of a method, and it instantiates an object.
  It is common for a constructor reference to use a Supplier

![img_5.png](img_5.png)

        Supplier<List<String>> getListByLambda = () -> new ArrayList<>();
        Supplier<List<String>> getListByMethodRef = ArrayList::new;

        List<String> lambaList = getListByLambda.get();
        lambaList.add("Mehmet");
        System.out.println(lambaList);

        List<String> methodList = getListByMethodRef.get();
        methodList.add("Metehan");
        System.out.println(methodList);

###### Result
**[Mehmet]\
[Metehan]**


> It expands like the method references you have seen so far. In
the previous example, the lambda doesn't have any parameters.


* Method references can be tricky.
![img_6.png](img_6.png)


    

> This means you can't always determine which method can be
called by looking at the method reference. Instead, you have to
look at the context to see what parameters are used and if there
is a return type. In this example, Java sees that we are passing
an Integer parameter and calls the constructor of ArrayList
that takes a parameter.

<div align="center">
<table>
<th>Type</th>
<th>Before ::</th>
<th>After ::</th>
<th>Example</th>

<tr>
<td>Static methods </td>
<td>Class name</td>
<td>Method name</td>
<td>Collections::sort</td>
</tr>

<tr>
<td>Instance methods on a particular object</td>
<td>Instance variable name </td>
<td>Method name</td>
<td>str::startsWith</td>
</tr>

<tr>
<td>Instance methods on a parameter </td>
<td>Class name</td>
<td>Method name</td>
<td>String::isEmpty</td>
</tr>
<tr>
<td>Constructor</td>
<td>Class name</td>
<td>new</td>
<td>ArrayList::new</td>
</tr>


</table>
</div>

<br>


### Using Wrapper Classes
* With **_autoboxing_**, the compiler automatically converts a primitive to
  the corresponding wrapper. 
* Unsurprisingly, _**unboxing**_ is the
  process in which the compiler automatically converts a
  wrapper class back to a primitive.
<div align="center">
  <table>
    <th>Primitive type</th>
    <th>Wrapper class</th>
    <th>Example of initializing</th>

  <tr>
    <td>boolean</td>
    <td>Boolean</td>
    <td>Boolean.valueOf(true)</td>
  </tr>
  
  <tr>
    <td>byte</td>
    <td>Byte</td>
    <td>Byte.valueOf((byte) 1)</td>
  </tr>
  
  <tr>
    <td>short</td>
    <td>Short</td>
    <td>Short.valueOf((short) 1)</td>
  </tr>
  
  <tr>
    <td>int</td>
    <td>Integer</td>
    <td>Integer.valueOf(1)</td>
  </tr>
  
  <tr>
    <td>long</td>
    <td>Long</td>
    <td>Long.valueOf(1)</td>
  </tr>
  
  
  <tr>
    <td>float</td>
    <td>Float</td>
    <td>Float.valueOf((float)1.0)</td>
  </tr>
  
  <tr>
    <td>double</td>
    <td>Double</td>
    <td>Double.valueOf(1.0)</td>
  </tr>
  
  <tr>
    <td>char</td>
    <td>Character</td>
    <td>Character.valueOf('c')</td>
  </tr>


  </table>
</div>

<br>

* There are two tricks in the space of autoboxing and unboxing.
1) The first has to do with null values.

        List<Integer> integers = new ArrayList<>();
        integers.add(null);
        integers.add(2);
        integers.stream().forEach(System.out::println);
        int a = integers.get(0);

###### Result
**null\
2\
Exception in thread "main" java.lang.NullPointerException**

> We add a null to the list. This is legal because a null
reference can be assigned to any reference variable.
We try to unbox that null to an int primitive. This is a problem.
Java tries to get the int value of null. Since calling any method
on null gives a NullPointerException, that is just what we get.
Be careful when you see null in relation to autoboxing.

### WRAPPER CLASSES AND NULL
* Speaking of null, one advantage of a wrapper class over a
  primitive is that it can hold a null value. While null
  values aren't particularly useful for numeric calculations,
  they are quite useful in data‐based services. For example,
  if you are storing a user's location data using (latitude,
  longitude), it would be a bad idea to store a missing point
  as (0,0) since that refers to an actual location off the cost
  of Africa where the user could theoretically be.


**_What do you think this code outputs?_**

![img_7.png](img_7.png)
<details>
<summary>Click for result</summary>

```
It actually outputs [1]. Let's walk through why that is. On lines
24 through 26, we add three Integer objects to numbers. The
one on line 24 relies on autoboxing to do so, but it gets added
just fine. At this point, numbers contains [1, 3, 5].
Line 27 contains the second trick. The remove() method is
overloaded. One signature takes an int as the index of the
element to remove. The other takes an Object that should be
removed. On line 27, Java sees a matching signature for int, so
it doesn't need to autobox the call to the method. Now numbers
contains [1, 5]. Line 28 calls the other remove() method, and it
removes the matching object, which leaves us with just [1].
```
</details>


### Using the Diamond Operator
* In the past, we would write code using generics like


    List<Integer> list1 = new ArrayList<Integer>(); 

> Luckily, the diamond operator, <>, was added to the language.
  The diamond operator is a shorthand notation that allows you
  to omit the generic type from the right side of a statement when
  the type can be inferred. It is called the diamond operator
  because <> looks like a diamond.

    List<Integer> list1 = new ArrayList<>();


**_What do you think this code outputs?_**
![img_8.png](img_8.png)
    
    List<> list = new ArrayList<Integer>();
    Map<> map = new HashMap<String, Integer>();


<details>
<summary>Click for result</summary>

```
DOES NOT COMPILE
The diamond operator cannot be used as the type in a variable
declaration. It can be used only on the right side of an
assignment operation.
```
</details>

### Using Lists, Sets, Maps, and Queues
![img_9.png](img_9.png)

#### DELETING WHILE LOOPING
* Java does not allow removing elements from a list while
  using the enhanced for loop. 
<br>


    Collection<String> birds = new ArrayList<>();
    birds.add("hawk");
    birds.add("hawk");
    birds.add("hawk");
    for (String bird : birds) // ConcurrentModificationException
    birds.remove(bird);

#### removeIf()
* The removeIf() method removes all elements that match a
  condition.
<br>


    boolean removeIf(Predicate<? super E> filter)

* It uses a Predicate, which takes one parameter and returns a
  boolean.
<br>

        List<String> bags = new ArrayList<>();
        bags.add("Book");
        bags.add("Pencil");
        bags.add("Eraser");
        bags.add("Beans");
        bags.add("Ruler");
        bags.removeIf(s -> s.startsWith("B"));
        bags.forEach(System.out::println);

###### Result
**Pencil\
Eraser\
Ruler**

**_How would you replace with a method reference?_**
<details>
<summary>Click for result</summary>

```

Trick question—you can't. The removeIf() method takes a Predicate.
We can pass only one value with this method reference. Since
startsWith takes a literal, it needs to be specified “the long
way.”

```
</details>

**_Let's try one more example that does use a method reference._**

![img_10.png](img_10.png)
<details>
<summary>Click for result</summary>

```

we remove any empty String objects from the set.
The comment on that line shows the lambda equivalent of the
method reference. Line 15 shows that the removeIf() method
successfully removed one element from the list.”

```
</details>


### Comparing List Implementations
* The main benefit of an ArrayList is that you can look up any
element in constant time. Adding or removing an element is
slower than accessing an element. This makes an ArrayList a
good choice when you are reading more often than (or the same
amount as) writing to the ArrayList.
* A LinkedList is special because it implements both List and
Queue. It has all the methods of a List. It also has additional
methods to facilitate adding or removing from the beginning
and/or end of the list.
* The main benefits of a LinkedList are that you can access, add,
  and remove from the beginning and end of the list in constant
  time. The trade‐off is that dealing with an arbitrary index takes
  linear time. This makes a LinkedList a good choice when you'll
  be using it as Queue.
<br>

  

<div align="center">
  <table>
 <caption><span style="font-weight: bold">Factory methods to create a List</span></caption>
    <th>Method</th>
    <th>Description</th>
    <th>Can Add Elements?</th>
    <th>Can Replace Elements?</th>
    <th>Can Delete Elements?</th>

  <tr>
    <td>Arrays.asList(x)</td>
    <td>Returns fixed size list backed by an array.</td>
    <td><span style="color: red;font-weight: normal">No</span></td>
    <td><span style="font-weight: bold;color: greenyellow;">Yes</span></td>
    <td><span style="color: red;font-weight: normal">No</span></td>
  </tr>

  <tr>
    <td>List.of(x)</td>
    <td>Returns immutable list.</td>
    <td><span style="color: red;font-weight: normal">No</span></td>
    <td><span style="color: red;font-weight: normal">No</span></td>
    <td><span style="color: red;font-weight: normal">No</span></td>
  </tr>

  <tr>
    <td>List.copyOf(collection)</td>
    <td>Returns an immutable list with copy of original collection's values</td>
    <td><span style="color: red;font-weight: normal">No</span></td>
    <td><span style="color: red;font-weight: normal">No</span></td>
    <td><span style="color: red;font-weight: normal">No</span></td>
  </tr>

  </table>
</div>

<br>



<br>
<div align="center">
  <table>
    <th>Method</th>
    <th>Description</th>
    <tr>
      <td><span style="font-weight: bolder">boolean add(E element)</span></td>
      <td>Adds element to end </td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder">void add(int index,E element)</span></td>
      <td>Adds element at index and movers the rest</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder">E get(int index)</span></td>
      <td>Returns element at index</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder">E remove(int index)</span></td>
      <td>Removes an element at index and moves the rest toward the front</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder">void replaceAll(UnaryOperator&lt E&gt op)</span></td>
      <td>Replaces each element in the list with the result of the operator</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder">E set(int index, E e)</span></td>
      <td>Replaces element at index and returns original. Throws IndexOutOfBoundsException if the index is larger than the maximum one set</td>
    </tr>

 <caption><span style="font-weight: bold">List methods</span></caption>
  </table>

</div>

<br>

### Comparing Set Implementations
* A HashSet stores its elements in a hash table, which means the
  keys are a hash and the values are an Object. This means that it
  uses the hashCode() method of the objects to retrieve them
  more efficiently.
* A TreeSet stores its elements in a sorted tree structure. The
  main benefit is that the set is always in **sorted order**. The trade‐
  off is that adding and checking whether an element exists take
  longer than with a HashSet, especially as the tree grows larger.


### USING THE QUEUE INTERFACE
* Unless stated otherwise, a queue is assumed to be FIFO (first‐
  in, first‐out). Some queue implementations change this to use a
  different order. You can envision a FIFO queue as shown in
  Figure 14.5. The other format is LIFO (last‐in, first‐out), which
  is commonly referred to as a stack. In Java, though, both can
  be implemented with the Queue interface.

### Comparing Queue Implementations
* You saw LinkedList earlier in the List section. In addition to
  being a list, it is a double‐ended queue. A double‐ended queue
  is different from a regular queue in that you can insert and
  remove elements from both the front and back of the queue.
<div align="center">
  <table>
    <th>Method</th>
    <th>Description</th>
    <th>Throws exception on failure</th>
    <tr>
      <td><span style="font-weight: bolder; font-family: Unispace">boolean add(E e)</span></td>
      <td>Adds an element to back of the queue and returns true or throws an exception</td>
      <td>Yes</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder; font-family: Unispace">E element()</span></td>
      <td>Returns next element or throws an exception if empty queue</td>
      <td>Yes</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder; font-family: Unispace">boolean offer(E e)</span></td>
      <td>Adds an element to back of the queue and returns whether successful</td>
      <td>No</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder; font-family: Unispace">E remove()</span></td>
      <td>Removes and returns next element or throws an exception if empty queue."</td>
      <td>Yes</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder; font-family: Unispace">E poll()</span></td>
      <td>Removes and returns next element or returns null if empty queue</td>
      <td>No</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder; font-family: Unispace">E peek()</span></td>
      <td>Returns next element or returns null if empty queue</td>
      <td>No</td>
    </tr>

 <caption><span style="font-weight: bold">List methods</span></caption>
  </table>

</div>

### USING THE MAP INTERFACE 
* You do need to know that TreeMap is
  sorted.

### MAP.OF() AND MAP.COPYOF()
* Just like List and Set, there is a helper method to create a
  Map. 
<br>


    Map.of("key1", "value1", "key2", "value2");
* Unlike List and Set, this is less than ideal. Suppose you
  miscount and leave out a value.
<br>


    Map.of("key1", "value1", "key2"); // INCORRECT
> This code compiles but throws an error at runtime.

    Map.ofEntries(Map.entry("key1", "value1"),Map.entry("key1", "value1"));
    Map.ofEntries(Map.entry("1","Kestane")).forEach((s, s2) -> System.out.println(s+" "+s2));



<div align="center">
  <table>
    <th>Method</th>
    <th>Description</th>
    <tr>
      <td><span style="font-weight: bolder;">void  clear()</span></td>
      <td>Removes all keys and values from the map.</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder;">boolean containsKey(Object key)</span></td>
      <td>Returns whether key is in a map.</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder;">boolean containsValue(Object value)</span></td>
      <td>Returns whether value is in map.</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder;">Set &lt Map.Entry &lt K,V &gt &gt entrySet() </span></td>
      <td>Returns a Set of key/value pairs.</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder;">void forEach(BiConsumer(K key, V value))</span></td>
      <td>Loop through each key/value pair.</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder;">V get(Object key)</span></td>
      <td>Returns the value mapped by key or null if none is mapped.</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder;">V getOrDefault(Object key, V defaultValue)</span></td>
      <td>Returns the value mapped by the key or the default value if none is mapped.</td>
    </tr>
    <tr>
      <td><span style="font-weight: bolder;">boolean isEmpty()</span></td>
      <td>Returns whether the map is empty.</td>
    </tr>
    <caption><span style="font-weight: bold">Map methods</span></caption>
  </table>
</div>

#### entrySet()
* Another way of going through all the data in a map is to get the
  key/value pairs in a Set. Java has a static interface inside Map
  called Entry. It provides methods to get the key and value of
  each pair.
<br>


    map.entrySet().forEach(e -> System.out.println(e.getKey() + e.getValue()));
#### getOrDefault()
* The get() method returns null if the requested key is not in
  map. Sometimes you prefer to have a different value returned.
  Luckily, the getOrDefault() method makes this easy. Let's
  compare the two methods.



```diff
+ EXERCISE-3
```
![img_15.png](img_15.png)
<details>
<summary>Click for result</summary>

```

X marks the spot
X marks the spot
Y marks the null
Y marks the
”

```
</details>

#### merge()
* The merge() method adds logic of what to choose. Suppose we
  want to choose the ride with the longest name. We can write
  code to express this by passing a mapping function to the
  merge() method.
<br>

        Map<String,String> favorites = new HashMap<>();
        BiFunction<String,String,String> mapper = (s, s2) -> s+"-"+s2;
        favorites.put("Medet","Running");
        favorites.put("Metehan","Football");
        favorites.merge("Metehan","Basketball",mapper);
        System.out.println(favorites.get("Metehan"));


![img_16.png](img_16.png)


<div align="center">
  <table>
    <th>If Key .... </th>
    <th>Mapping function returns</th>
    <th>Result</th>
    <tr>
      <td>Has a null value in map</td>
      <td>N/A (mapping function not called)</td>
      <td>Update key's value in map with value parameter.</td>
    </tr>
    <tr>
      <td>Has a non‐null value in map</td>
      <td>null</td>
      <td>Remove key from map.</td>
    </tr>
    <tr>
      <td>Has a non‐null value in map</td>
      <td>A non‐null value</td>
      <td>Set key to mapping function result.</td>
    </tr>
    <tr>
      <td>Is not in map</td>
      <td>N/A (mapping function not called)</td>
      <td>Add key with value parameter to map directly without calling mapping function.</td>
    </tr>
    <caption><span style="font-weight: bold">Behavior of the merge() method</span></caption>
  </table>
</div>

### COMPARING COLLECTION TYPES

<div align="center">
  <table>
    <th>Type </th>
    <th>Can contain duplicate elements?</th>
    <th>Elements always ordered?</th>
    <th>Has keys and values?</th>
    <th>Must add/remove in specific order?</th>
    <tr>
      <td>List</td>
      <td>Yes</td>
      <td>Yes</td>
      <td>No</td>
      <td>No</td>
    </tr>
    <tr>
      <td>Map</td>
      <td>Yes</td>
      <td>No</td>
      <td>Yes</td>
      <td>No</td>
    </tr>
    <tr>
      <td>Queue</td>
      <td>Yes</td>
      <td>Yes</td>
      <td>No</td>
      <td>Yes</td>
    </tr>
    <tr>
      <td>Set</td>
      <td>No</td>
      <td>No</td>
      <td>No</td>
      <td>No</td>
    </tr>
    <caption><span style="font-weight: bold"> Java Collections Framework types</span></caption>
  </table>
</div>

<div div align="center">
  <table>
    <th>Type </th>
    <th>Java Collections Framework interface</th>
    <th>Sorted</th>
    <th>Calls hashCode</th>
    <th>Calls compareTo</th>
    <tr>
      <td>ArrayList</td>
      <td>List</td>
      <td>No</td>
      <td>No</td>
      <td>No</td>
    </tr>
    <tr>
      <td>HashMap</td>
      <td>Map</td>
      <td>No</td>
      <td>Yes</td>
      <td>No</td>
    </tr>
    <tr>
      <td>HashSet</td>
      <td>Set</td>
      <td>No</td>
      <td>Yes</td>
      <td>No</td>
    </tr>
    <tr>
      <td>LinkedList</td>
      <td>List, Queue</td>
      <td>No</td>
      <td>No</td>
      <td>No</td>
    </tr>
    <tr>
      <td>TreeMap</td>
      <td>Map</td>
      <td>Yes</td>
      <td>No</td>
      <td>Yes</td>
    </tr>
    <tr>
      <td>TreeSet</td>
      <td>Set</td>
      <td>Yes</td>
      <td>No</td>
      <td>Yes</td>
    </tr>
    <caption><span style="font-weight: bold"> Collection Attributes</span></caption>
  </table>
</div>

### Sorting Data
* Remember that numbers sort before letters, and
  uppercase letters sort before lowercase letters.
<br>

* You can also sort objects that you create yourself. Java provides
  an interface called Comparable. If your class implements
  Comparable, it can be used in these data structures that require
  comparison. There is also a class called Comparator, which is
  used to specify that you want to use a different order than the
  object itself provides.
<br>
### CREATING A COMPARABLE CLASS

    public interface Comparable<T> {
      int compareTo(T o);
    }

* Any object can be Comparable.


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Duck implements Comparable<Duck>{
      private int id;
      private String name;
  
      @Override
      public int compareTo(Duck o) {
        return id - o.getId();
      }
    }
<br>

      public static void main(String[] args) {
        Duck duck1 = new Duck(4,"Merop");
        Duck duck2 = new Duck(2,"Losap");
        ArrayList<Duck> ducks = new ArrayList<>();
        ducks.add(duck1);
        ducks.add(duck2);
        ducks.forEach(System.out::println);
        System.out.println("After sort");
        Collections.sort(ducks);
        ducks.forEach(System.out::println);
      }
<br>

<details>
<summary>Click for result</summary>

```
Duck(id=4, name=Merop)
Duck(id=2, name=Losap)
After sort
Duck(id=2, name=Losap)
Duck(id=4, name=Merop)
”

```
</details>




* There are three rules to know.
1) The number 0 is returned when the current object is equivalent
to the argument to compareTo().
2) A negative number (less than 0) is returned when the current
object is smaller than the argument to compareTo().
3) A positive number (greater than 0) is returned when the
current object is larger than the argument to compareTo().

### Keeping compareTo() and equals() Consistent
* A natural
  ordering that uses compareTo() is said to be consistent with
  equals if, and only if, x.equals(y) is true whenever
  x.compareTo(y) equals 0.

### COMPARING DATA WITH A COMPARATOR
* Sometimes you want to sort an object that did not implement
  Comparable, or you want to sort objects in different ways at
  different times.
<br>


    @FunctionalInterface
    public interface Comparator<T> {
      int compare(T o1, T o2);
    }

    Comparator<Duck> duckComparator = (o1, o2) -> o1.getId()-o2.getId();
    Collections.sort(ducks,duckComparator);
    System.out.println("After sort");
    ducks.forEach(System.out::println);  

> we do show the import to
call attention to the fact that Comparable and Comparator are in
different packages, namely, java.lang versus java.util,
respectively. That means Comparable can be used without an
import statement, while Comparator cannot.

> IS COMPARABLE A FUNCTIONAL INTERFACE?
We said that Comparator is a functional interface because
it has a single abstract method. Comparable is also a
functional interface since it also has a single abstract
method. However, using a lambda for Comparable would
be silly. The point of Comparable is to implement it inside
the object being compared.

<div align="center">
  <table>
    <th>Difference</th>
    <th>Comparable</th>
    <th>Comparator</th>
    <tr>
      <td>Package name</td>
      <td>java.lang</td>
      <td>java.util</td>
    </tr>
    <tr>
      <td>Interface must be implemented by class comparing?</td>
      <td>Yes</td>
      <td>No</td>
    </tr>
    <tr>
      <td>Method name in interface</td>
      <td>compareTo()</td>
      <td>compare:()</td>
    </tr>
    <tr>
      <td>Number of parameters</td>
      <td>1</td>
      <td>2</td>
    </tr>
    <tr>
      <td>Common to declare using a lambda</td>
      <td>No</td>
      <td>Yes</td>
    </tr>
    <caption><span style="font-weight: bold"> Comparison of Comparable and Comparator</span></caption>
  </table>
</div>

### COMPARING MULTIPLE FIELDS


    public class Squirrel {
      private int weight; 
      private String species;
    }


```diff
- If two squirrels are from the same species, we want to sort the one that weighs the least first.
```
<details>
<summary>Click for result Bad Way</summary>

```
public class MultiFieldComparator implements Comparator<Squirrel> {
  public int compare(Squirrel s1, Squirrel s2) {
    int result = s1.getSpecies().compareTo(s2.getSpecies());
    if (result != 0) return result;
      return s1.getWeight()-s2.getWeight();
    }
 }
}
```
</details>
<details>
<summary>Click for result Good Way</summary>

```
Comparator<Squirrel> squirrelComparator = Comparator.comparing(Squirrel::getSpecies).thenComparingInt(Squirrel::getWeight);
```
</details>

<div align="center">
  <table>
    <th>Method</th>
    <th>Description</th>
    <tr>
      <td>comparing(function)</td>
      <td>Compare by the results of a function that returns any Object (or object autoboxed into an Object).</td>
    </tr>
    <tr>
      <td>comparingDouble(function)</td>
      <td>Compare results of function then returns boolean.</td>
    </tr>
    <tr>
      <td>comparingInt(function)</td>
      <td>Compare the result of function then returns int</td>
    </tr>
    <tr>
      <td>comparingLong(function)</td>
      <td>Compare the result of function then returns long</td>
    </tr>
    <tr>
      <td>naturalOrder()</td>
      <td>Sort using the order specified by the Comparable implementation on the object itself.</td>
    </tr>
    <tr>
      <td>reverseOrder()</td>
      <td>reverse of the naturalOrder()</td>
    </tr>
    <caption><span style="font-weight: bold"> Helper static methods for building a Comparator</span></caption>
  </table>
</div>

<div align="center">
  <table>
    <th>Method</th>
    <th>Description</th>
    <tr>
      <td>reversed()</td>
      <td>Reverse card</td>
    </tr>
    <tr>
      <td>thenComparing(function)</td>
      <td>If the previous comparator returns 0 use this.</td>
    </tr>
    <tr>
      <td>thenComparingInt(function)</td>
      <td>Compare the result of function then returns int</td>
    </tr>
    <tr>
      <td>thenComparingLong(function)</td>
      <td>Compare the result of function then returns long</td>
    </tr>
    <caption><span style="font-weight: bold"> Helper default methods for building a Comparator </span></caption>
  </table>
</div>


### Generics
└┴┬ E -> element \
└┴┬ K -> key \
└┴┬ V -> value \
└┴┬ N -> number \
└┴┬ T -> data \

* Class Level
<br>


    @Getter
    @Setter
    public class SizeLimitedCrate <T,U>{
      private T data;
      private U units;

      public SizeLimitedCrate(T data, U units) {
          this.data = data;
          this.units = units;
      }
    }

* Interface Level
<br>


    public interface Shippable<T> {
      void ship(T t);
    }

* Method Level
<br>


    public class Handler {
      public static <T> void prepare(T t) {
        System.out.println("Preparing " + t);
      }
      public static <T> Crate<T> ship(T t) {
        System.out.println("Shipping " + t);
        return new Crate<T>();
      }
    }


 ```diff
- Which line does not compline?
```
![img_22.png](img_22.png)
<details>
<summary>Click for result</summary>

```
Line 3 shows the formal parameter type immediately before the
return type of void. Line 4 shows the return type being the
formal parameter type. It looks weird, but it is correct. Line 5
omits the formal parameter type, and therefore it does not
compile.
```
</details>
* When you have a method declare a generic parameter type, it is
independent of the class generics. Take a look at this class that
declares a generic T at both levels

    public class Crate<T> {
      public <T> T tricky(T t) {
        return t;
      }
    }


### BOUNDING GENERIC TYPES

* A wildcard generic type is an unknown generic type
  represented with a question mark ( ?)


<div align="center">
  <table>
    <th>Type of bound</th>
    <th>Syntax</th>
    <th>Example</th>
    <tr>
      <td>Unbounded wildcard</td>
      <td>?</td>
      <td>List &lt ? &gt a = new ArrayList &lt String &gt(); </td>
    </tr>
    <tr>
      <td>Wildcard with upper bound</td>
      <td>? extends type</td>
      <td>List &lt ? extends Exception &gt a = new ArrayList &lt RuntimeException &gt(); </td>
    </tr>
    <tr>
      <td>Wildcard with lower bound</td>
      <td>? super type</td>
      <td>List &lt ? super Exception &gt a = new ArrayList &lt Object &gt(); </td>
    </tr>
    <caption><span style="font-weight: bold"> Types of bound </span></caption>
  </table>
</div>

 ```diff
- When you have subclasses and superclasses, lower
  bounds can get tricky.
```

![img_25.png](img_25.png)

<details>
<summary>Click for result</summary>

```
Line 3 references a List that could be List<IOException>
or List<Exception> or List<Object>. Line 4 does not
compile because we could have a List<IOException> and
an Exception object wouldn't fit in there.
Line 5 is fine. IOException can be added to any of those
types. Line 6 is also fine. FileNotFoundException can also
be added to any of those three types. This is tricky because
FileNotFoundException is a subclass of IOException, and
the keyword says super. What happens is that Java says,
“Well, FileNotFoundException also happens to be an
IOException, so everything is fine.”
```
</details>