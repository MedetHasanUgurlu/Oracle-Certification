# Annotations
* _**Metadata**_ is data that provides information about other data. 

### Rule

1) Annotations function a lot like interfaces, annotations
  allow us to mark without changing its inheritance structure.
2) Annotations establish relationships that make it easier to
manage data about our application.
3) The Annotation ascribes custom information on the declaration
  where it is defined.
4) Annotations are optional metadata and by themselves
  do not do anything. This means you can take a project filled
  with thousands of annotations and remove all of them, and it
  will still compile and run, albeit with potentially different
  behavior at runtime.

marker annotation, since it does not contain any elements
<br>

>    public @interface Exercise {    
    }  
We have mixed. That is fine.



    @Exercise() 
    public class Cheetah {
    }

    @Exercise 
    public class Sloth {
    }

    @Exercise
    public class ZooEmployee {
    }





* It looks a lot like an abstract method.Behind the scenes,
the JVM is creating **elements as interface methods** and
**_annotations as implementations of these interfaces_**. 
<br>


    public @interface Exercise {
      int hoursPerDay();
    }




Remember, parentheses are optional only if no values are included.


    @Exercise(hoursPerDay=3) 
    public class Cheetah{
    }

    @Exercise hoursPerDay=0 
    public class Cheetah{                     DOES NOT COMPILE
    }
    
    @Exercise                                 DOES NOT COMPILE
    public class Cheetah{
    }
  



* For an element to be optional, rather than required, it must
  include a default value. Let's update our annotation to include
  an optional value.

> ![img_1.png](png/images/img_1.png)
> ![img_2.png](png/images/img_2.png)
* The default value of an annotation cannot be just any
  value. Similar to case statement values, the default value
  of an annotation must be a non‐ null constant
  expression.
> ![img_3.png](png/images/img_3.png)
* The **height()** element does not compile. While primitive types
  like int and long are supported, wrapper classes like Integer
  and Long are not. **The generalInfo()** element also does not
  compile. The type _String[] is supported_, as it is an array of
  String values, but _~~String[][] is not~~_.
  The **size()** and **exercise()** elements both compile, with one
  being an enum and the other being an annotation. To set a
  default value for **exercise()**, we use the @Exercise annotation.
  Remember, this is the only way to create an annotation value.
  Unlike instantiating a class, **the new keyword is never used to
  create an annotation**.
  Finally, the **friendlyBear()** element does not compile. The type
  of friendlyBear() is Bear (not Class). Even if Bear were
  changed to an interface, the friendlyBear() element would still
  not compile since it is not one of the supported types.

> ![img_4.png](png/images/img_4.png)



* Like abstract interface methods, annotation elements are
  implicitly **_abstract and public_**, whether you declare them that
  way or not.
> ![img_5.png](png/images/img_5.png)

* Yep, just like _**interface variables, annotation variables are
  implicitly public, static, and final**_.
> ![img_6.png](png/images/img_6.png)
* @Alert. Remember, a marker annotation is one that does not
  contain any elements.
* The annotation declaration must contain an element named
  **value()**, which may be optional or required.

> ![img.png](png/images/h/images2/img.png)
> ![img_1.png](png/images/h/images2/img_1.png)


* Annotations support a shorthand notation for providing an
  array that contains a single element.

> ![img_2.png](png/images/h/images2/img_2.png)

* It might not surprise you that we can combine both of our
    recent rules for shorthand notations.

> ![img_3.png](png/images/h/images2/img_3.png)
> ![img_4.png](png/images/h/images2/img_4.png)


* Learning the ElementType Values
<div align="center">
<table>
<th>ElementType value</th>
<th>Applies to</th>
<tr>
<td>TYPE</td>
<td>Classes, interfaces, enums, annotations</td>
</tr>
<tr>
<td>FIELD</td>
<td>Instance and static variables, enum values</td>
</tr>
<tr>
<td>METHOD</td>
<td>Method declarations</td>
</tr>
<tr>
<td>PARAMETER</td>
<td>Constructor,Method, Lambda</td>
</tr>
<tr>
<td>CONSTRUCTOR</td>
<td>Constructor declarations</td>
</tr>
<tr>
<td>LOCAL_VARIABLE</td>
<td>Local Variables</td>
</tr>
<tr>
<td>ANNOTATION_TYPE</td>
<td>Annotations</td>
</tr>
<tr>
<td>PACKAGE*</td>
<td>Packages declared in package-info.java</td>
</tr>
<tr>
<td>TYPE_PARAMETER</td>
<td>Parameterized types, generic declarations</td>
</tr>
<tr>
<td>TYPE_USE</td>
<td>Able to be applied anywhere there is Java's type declared.</td>
</tr>
<tr>
<td>MODULE*</td>
<td>Modules</td>
</tr>
</table>
</div>




* Values for the @Retention annotation
> ![img_7.png](png/images/img_7.png)
> ![img_8.png](png/images/img_8.png)

* Javadoc has its own annotations that are used solely in
  generating data within a Javadoc file.
> ![img_10.png](png/images/img_10.png)


* Another marker annotation you should know for the exam is **@Inherited**. 
When this annotation is applied to a class,
  subclasses will inherit the annotation information found in the
  parent class.
> ![img_11.png](png/images/img_11.png)
* It actually
  requires creating two annotations. The @Repeatable annotation
  is used when you want to specify an annotation more than once
  on a type.

* The Zoo class does not compile.
> ![img_12.png](png/images/img_12.png)
> ![img_13.png](png/images/img_13.png)
> ![img_14.png](png/images/img_14.png)
> ![img_7.png](png/images/h/images2/img_7.png)

* The repeatable annotation must be declared with @Repeatable
  and contain a value that refers to the containing type
  annotation.
* The containing type annotation must include an element
  named value(), which is a primitive array of the repeatable
  annotation type.
<br>

<div align="center">
<table>
  <tr>
    <th>Annotation</th>
    <th>Marker Annotation</th>
    <th>Type of value()</th>
    <th>Default compiler behavior (if annotation not present)</th>
  </tr>
  <tr>
    <td>@Target</td>
    <td>No</td>
    <td>Array of Element Type</td>
    <td>Annotation able to be applied to all locations except TYPE_USE and TYPE_PARAMETER</td>
  </tr>
  <tr>
    <td>@Retention</td>
    <td>No</td>
    <td>Retention Policy</td>
    <td>RetentionPolicy.CLASS</td>
  </tr>
  <tr>
    <td>@Documented</td>
    <td>Yes</td>
    <td>—</td>
    <td>Annotations are not included in the generated Javadoc.</td>
  </tr>
  <tr>
    <td>@Inherited</td>
    <td>Yes</td>
    <td>—</td>
    <td>Annotations in supertypes are not inherited.</td>
  </tr>
  <tr>
    <td>@Repeatable</td>
    <td>No</td>
    <td>Annotation</td>
    <td>Annotation can not be repeated.</td>
  </tr>

</table>
</div>
<br>
* The Reptile declaration does not compile, because the
  @FunctionalInterface annotation can be applied only to
  interfaces. The Slimy interface does not compile, because it
  does not contain any abstract methods. The Scaley interface
  compiles, as it contains exactly one abstract method.
  The Rough interface does not compile, because it contains two
  abstract methods, one of which it inherits from Scaley. Finally,
  the Smooth interface contains two abstract methods, although
  since one matches the signature of a method in
  java.lang.Object, it does compile.

> ![img_8.png](png/images/h/images2/img_8.png)

<div align="center">
<table>
  <th>Annotation</th>
  <th>Marker annotation</th>  
  <th>Type of value()</th>
  <th>Optional Members</th>
  <tr>
    <td>@Override</td>
    <td>Yes</td>
    <td>-</td>
    <td>-</td>
  </tr>
  <tr>
    <td>@FunctionalInterface</td>
    <td>Yes</td>
    <td>-</td>
    <td>-</td>
  </tr>
  <tr>
    <td>@Deprecated</td>
    <td>No</td>
    <td>-</td>
    <td>String since() boolean forRemoval()</td>
  </tr>
  <tr>
    <td>@SuppressWarnings</td>
    <td>No</td>
    <td>String[]</td>
    <td>-</td>
  </tr>
  <tr>
    <td>@SafeVarargs</td>
    <td>Yes</td>
    <td>-</td>
    <td>-</td>
  </tr>
</table>
</div>
