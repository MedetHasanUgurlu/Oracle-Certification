# Exceptions, Assertions, and Localization

<div align="center">
    <img src="img.png">
</div>



<div align="center">
  <table>
    <tr>
      <td>ArrayStoreException</td>
    </tr>
    <tr>
      <td>IllegalArgumentException</td>
    <tr>
      <td>MissingResourceException</td>
    </tr>
    <tr>
      <td>NumberFormatException</td>
    </tr>
    <tr>
      <td>ClassCastException</td>
    </tr>
    <tr>
      <td>IllegalStateException</td>
    </tr>
    <tr>
      <td>NullPointerException</td>
    </tr>
   <tr>
      <td>UnsupportedOperationException</td>
    </tr>
    <caption><span style="font-weight: bold"> Unchecked Exceptions</span></caption>
  </table>
</div>


 ```diff
- Why does the following not compile?
```
<div align="center">
    <img src="img_3.png">
</div>


<details>
<summary>Click for result</summary>

```
Since FileNotFoundException is a subclass of IOException,
listing both in a multi‐ catch expression is redundant, resulting
in a compilation error.
```
</details>


 ```diff
- Ordering of exceptions in consecutive catch blocks matters too. Why does the following not compile?
```
<div align="center">
    <img src="img_4.png">
</div>


<details>
<summary>Click for result</summary>

```
For the exam, remember that trying to catch a more specific
exception (after already catching a broader exception) results
in unreachable code and a compiler error.
```
</details>


### Constructing Try-With-Resources Statements

The first rule you should know is: try‐with‐
resources statements require resources that implement the
AutoCloseable interface
<br>

    try (String reptile = "lizard") {
    }

> String does not implement AutoCloseable so above code does not compile.

* NOTE: you will encounter
  resources that implement Closeable, rather than
  AutoCloseable. Since Closeable extends AutoCloseable,
  they are both supported in try‐with‐resources statements.
  The only difference between the two is that Closeable's
  close() method declares IOException, while
  AutoCloseable's close() method declares Exception.


    public class CustomFileReader implements AutoCloseable{
      private String tag;
      @Override
      public void close() throws Exception {
          System.out.println("Closed."+tag);
      }
    }

<br>
Main Code
<br>


      public static void main(String[] args) {
        try(CustomFileReader customFileReader = new CustomFileReader("Medron");) {
            System.out.println("Try Block");

        } catch (Exception e) {
            System.out.println("Catch Block");
        }finally {
            System.out.println("Finally Block");
        }
      }
<br>

**Result** \
Try Block \
Closed.Medron \
Finally Block 

> As you can see, the resources are closed at the end of the try
statement, before any catch or finally blocks are executed.
Behind the scenes, the JVM calls the close() method inside a
hidden finally block, which we can refer to as the implicit
finally block. The finally block that the programmer declared
can be referred to as the explicit finally block.
* **TIP**: In a try‐with‐resources statement, you need to remember
  that the resource will be closed at the completion of the
  try block, before any declared catch or finally blocks
  execute.

The second rule you should be familiar with is: a try‐with‐
resources statement can include multiple resources, which are
closed in the reverse order in which they are declared.

<div align="center">
    <img src="img_5.png">
</div>


When executed, this code prints the following:
<div align="center">
    <img src="img_6.png">
</div>


### Why You Should Be Using Try-With-Resources Statements
<div align="center">
    <img src="img_7.png">
</div>


  



