# Method and Encapsulation

## Method

### Name
    public void walk1(){...} COMPILE
    public void 2walk(){...} DOES NOT COMPILE
    public walk3 void(){...} DOES NOT COMPILE
    public void walk_$3(){...} DOES NOT COMPILE
    public void _(){...} DOES NOT COMPILE
    public void(){...} DOES NOT COMPILE

### varargs

A varargs parameter must
be the last element in a method’s parameter list. This means
you are allowed to have only one varargs parameter per
method.

    public void walk1(int... nums){} 
    public void walk1(int start,int... nums){}
    public void walk1(int... nums,int start){} DOES NOT COMPILE
    public void walk1(int... start,int... nums){} DOES NOT COMPILE

### Access Modifiers
`private`: Only accessible within the same class \
`Default (package-private)` access: private plus other classes in the same package\
`protected`: Default access plus child classes\

SuperClass

    package pond.shore;
    public class Bird {
        protected String text = "floating"; // protected access
        protected void floatInWater() { // protected access
        System.out.println(text);
        }
    }

Subclass

    package pond.goose;
    import pond.shore.Bird; // in a different package
    public class Gosling extends Bird { // extends means create subclass
        public void swim() {
            floatInWater(); // calling protected member
            System.out.println(text); // accessing protected member
        }
    }

Remember that protected also gives us access to everything
that default access does. This means that a class in the same
package as Bird can access its protected members.


    package pond.shore; // same package as Bird
    public class BirdWatcher {
        public void watchBird() {
            Bird bird = new Bird();
            bird.floatInWater(); // calling protected member
            System.out.println(bird.text); // accessing protected member
        }
    }


**_Example_**

    package pond.swan;
    import pond.shore.Bird; // in different package than Bird
    public class Swan extends Bird { // but subclass of Bird
        
        public void swim() {
            floatInWater(); // subclass access to superclass
        System.out.println(text); // subclass access to superclass
        }

        public void helpOtherSwanSwim() {
            Swan other = new Swan();
            other.floatInWater(); // subclass access to superclass
            System.out.println(other.text); // subclass access to superclass
        }
        public void helpOtherBirdSwim() {
            Bird other = new Bird();
            other.floatInWater(); // DOES NOT COMPILE
            System.out.println(other.text); // DOES NOT COMPILE
        }
    }

> Wait a minute. They are almost
exactly the same as lines 10 and 11! There’s one key difference.
This time a Bird reference is used rather than inheritance. It is
created on line 15. Bird is in a different package, and this code
isn’t inheriting from Bird, so it doesn’t get to use protected
members.



**protected rules apply under two scenarios**
1. A member is used without referring to a variable. We are taking advantage of
   inheritance and protected access is allowed.
2. A member is used through a variable. The rules for the reference type of
   the variable are what matter. If it is a subclass, protected access
   is allowed. This works for references to the same class or a
   subclass.



`public`: protected plus classes in the other packages


Remember to look at the reference type for a variable
when you see a static method or variable. The exam
creators will try to trick you into thinking a
NullPointerException is thrown because the variable
happens to be null. Don’t be fooled!


### ACCESSING A STATIC VARIABLE OR METHOD
    Koala.count = 4;
    Koala koala1 = new Koala();
    Koala koala2 = new Koala();
    koala1.count = 6;
    koala2.count = 5;
    System.out.println(Koala.count);

> We hope you answered 5. There is only one count variable since
it is static. It is set to 4, then 6, and finally winds up as 5. All
the Koala variables are just distractions.



### STATIC VS. INSTANCE

There’s another way the exam creators will try to trick you
regarding `static` and instance members. A `static` member
cannot call an instance member without referencing an
instance of the class. This shouldn’t be a surprise since static
doesn’t require any instances of the class to even exist.

    public class Gorilla {
        public static int count;
        
        public static void addGorilla() {
            count++; 
        }
        
        public void babyGorilla() {
            count++;
        }
        
        public void announceBabies() {
            addGorilla();
            babyGorilla();
        }
    
        public static void announceBabiesToEveryone() {
            addGorilla();
            babyGorilla(); // DOES NOT COMPILE
        }

        public int total;
        public static double average = total / count; // DOES NOT COMPILE
    }

`announceBabies()`method is fine because an instance method can call a static method.\
`announceBabiesToEveryone()` doesn’t compile because a static method cannot call an instance method.\
`average` field is not compile because a static variable is trying to use an instance variable

> The same thing happens for static methods. There is one
copy of the code. Parameters and local variables go on the
stack.

### STATIC INITIALIZATION
Static initializers
look similar. They add the static keyword to specify they
should be run when the class is first loaded.

    private static final int NUM_SECONDS_PER_MINUTE;
    private static final int NUM_MINUTES_PER_HOUR;
    private static final int NUM_SECONDS_PER_HOUR;
    static {
        NUM_SECONDS_PER_MINUTE = 60;
        NUM_MINUTES_PER_HOUR = 60;
    }
    static {
        NUM_SECONDS_PER_HOUR   NUM_SECONDS_PER_MINUTE * NUM_MINUTES_PER_HOUR;
    }

> We just got through saying that `final`variables aren’t allowed to be reassigned. The key here is that
the `static` initializer is the first assignment.

    private static int one;
    private static final int two;
    private static final int three = 3;
    private static final int four; // DOES NOT COMPILE
    static {
        one = 1;
        two = 2;
        three = 3; // DOES NOT COMPILE
        two = 4; // DOES NOT COMPILE
    }

>  A final variable that never gets initialized. The compiler gives a
compiler error because it knows that the static blocks are the
only place the variable could possibly get initialized.


### STATIC IMPORTS

**Regular imports**


      import java.util.List;
      import java.util.Arrays;
      public class Imports {
         public static void main(String[] args) {
            List<String> list = Arrays.asList("one", "two");
         }
      }

**Static Imports**


      import java.util.List;
      import static java.util.Arrays.asList; // static import
      public class StaticImports {
         public static void main(String[] args) {
            List<String> list = asList("one", "two"); // no Arrays.
         }
      }
   

**Regular imports** are for importing classes. **Static imports** are for importing
static members of classes. Just like regular imports, you can
use a wildcard or import a specific member. The idea is that
you shouldn’t have to specify where each static method or
variable comes from each time you use it.
> In a large program, static imports can be overused. When
importing from too many places, it can be hard to
remember where each static member comes from.


      import static java.util.Arrays; // DOES NOT COMPILE
      import static java.util.Arrays.asList;
      static import java.util.Arrays.*; // DOES NOT COMPILE

      public class BadStaticImports {
         public static void main(String[] args) {
            Arrays.asList("one"); // DOES NOT COMPILE
         }
      }


Line 1 tries to use a static import to import a class. Remember
that static imports are only for importing static members.\
Line 3 tries to see whether you are paying attention to the order of keywords.\
Line 6 is sneaky The asList method is imported on line 2. However, the Arrays
class is not imported anywhere. \

## Passing Data among Methods

Java is a “pass-by-value” language. This means that a copy of
the variable is made and the method receives that copy.
Assignments made in the method do not affect the caller.


      public static void main(String[] args) {
         String name = "Webby";
         speak(name);
         System.out.println(name);
      }
      public static void speak(String name) {
         name = "Sparky";
      }

The correct answer is Webby.

      public static void main(String[] args) {
         StringBuilder name = new StringBuilder();
         speak(name);
         System.out.println(name); // Webby
      }
      public static void speak(StringBuilder s) {
         s.append("Webby");
      }

<div align="center">
<img src="img.png">
</div>


## Overloading Methods

      public void fly(int numMiles) {}
      public int fly(int numMiles) {} // DOES NOT COMPILE

<br>

      public void fly(int numMiles) {}
      public static void fly(int numMiles) {} // DOES NOT COMPILE

<br>


      public void fly(int[] lengths) {}
      public void fly(int... lengths) {} // DOES NOT COMPILE

> Trick question! Remember that Java treats varargs as if they
were an array.


      fly(new int[] { 1, 2, 3 });
      fly(1, 2, 3);

> They don’t compile exactly the same. The
parameter list is the same.



Primitive(boolean, byte, char, short, int, long, float and double) to Reference type

   

      public void fly(Integer numMiles) {
      }
Which methods will be called?

      public void fly(int numMiles) {
      }
      public void fly(Integer numMiles) {
      }


**_Result_**\
Java will match the int numMiles version.

Java has a concept called type erasure where generics are used
only at compile time.

      public void walk(List<String> strings) {}
      public void walk(List<Integer> integers) {} // DOES NOT COMPILE




































[«« Go Back ««](https://github.com/MedetHasanUgurlu/Oracle-Certification) 