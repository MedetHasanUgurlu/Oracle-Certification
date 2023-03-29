package org.medron.chapter9_AdvancedClassDesign;

public class Main9 {
    public static void main(String[] args) {
        Integer i = 6;


    }
    /*
    ø An abstract class is most commonly used when you want another class to inherit properties of a particular class, but you
    want the subclass to fill in some implementation details.
    ~ public class abstract Jackal{}  DOES NOT COMPILE
    ~ public int abstract howl();  DOES NOT COMPILE

    ø If you mark something abstract, you are intending for someone else to extend or implement it. But, if you mark something final,
    ø you are preventing anyone from extending or implementing it. These concepts are in direct conflict with each other.
    ~ public abstract final class Tortoise {}  DOES NOT COMPILE
    ~ public abstract final void walk();  DOES NOT COMPILE


    ø A method cannot be marked as both abstract and private. This rule makes sense if you think about it. How would you define a
    ø subclass that implements a required method if the method is not inherited by the subclass?
    ~ private abstract void sing();  DOES NOT COMPILE
    ~ protected abstract void sing(); DOES NOT COMPILE

    ø A static method cannot be overridden. It is defined as belonging to the class, not an instance of the class. If a static method
    ø cannot be overridden,then it follows that it also cannot be marked abstract since it can never be implemented.
    ~ abstract static void swim();  DOES NOT COMPILE

    ø interface can extend multiple interface.
    ~ interface Nocturnal{}
    ~ interface CanFly{}
    ~ interface HasBigEyes extends Nocturnal,CanFly{}

    ø concrete class can extend multiple interface.
    ~ interface Climb{}
    ~ interface CanBurrow{}
    ~ public class FieldMouse implements Climb,CanBurrow{}

    ø You cannot use private in interface.
    ~ private int count = 4;  DOES NOT COMPILE
    ~ protected void step();  DOES NOT COMPILE

    ø In interface, you should initialize variables.
    ~ String distance;    DOES NOT COMPILE

    ø Even though abstract classes and interfaces are both considered abstract types, only interfaces make use of implicit
    modifiers. This means that an abstract class and interface with similar declarations may have very different properties.
    ~ abstract class Husky {
        abstract void play();
    }
    ~ interface Poodle {
        void play();
    }
    ~ class Webby extends Husky {
        void play() {}
    }
    ~ class Georgette implements Poodle {
        void play() {}
    }

    ø The definition of play() in the Georgette class therefore reduces the visibility of a method from public to package-private,
     resulting in a compiler error.
    ~ class Georgette implements Poodle {
        public void play() {}
    }
    ø if we have 2 abstract and 2 incompatible methods subclass can not compile

    ~ interface LongEars {
        int softSkin();
    }
    ~ interface LongNose {
        void softSkin();
    }
    ~ interface Donkey extends LongEars, LongNose {}  DOES NOT COMPILE
    ~ public class Penguin implements LongEars, LongNose {}  DOES NOT COMPILE

    ~ Number tickets = 4;
    ~ if(tickets instanceof String) {}  DOES NOT COMPILE

    ø With interfaces, the compiler has limited ability to enforce this rule because even though a reference type may not implement
    an interface, one of its subclasses could.
    ~ Number tickets = 5;
    ~ if(tickets instanceof List) {}

    ø Number abstract class Integer final class so
    ~ Number tickets = 5;
    ~ if(tickets instanceof List) {}   COMPILE
    ~ Integer tickets = 6;
    ~ if(tickets instanceof List) {}  DOES NOT COMPILE

    # Interface Definition Rules
    1. Interfaces cannot be instantiated.
    2. All top-level types, including interfaces, cannot be marked
    protected or private.
    3. Interfaces are assumed to be abstract and cannot be marked
    final.
    4. Interfaces may include zero or more abstract methods.
    5. An interface can extend any number of interfaces.
    6. An interface reference may be cast to any reference that
    inherits the interface, although this may produce an exception
    at runtime if the classes aren’t related.
    7. The compiler will only report an unrelated type error for an
    instanceof operation with an interface on the right side if the
    reference on the left side is a final class that does not inherit
    the interface.
    8. An interface method with a body must be marked default,
    private, static, or private static (covered when studying for
    the 1Z0-816 exam).
    The following are the five rules for abstract methods defined in
    interfaces.
    #Abstract Interface Method Rules
    1. Abstract methods can be defined only in abstract classes or
    interfaces.
    2. Abstract methods cannot be declared private or final.
    3. Abstract methods must not provide a method
    body/implementation in the abstract class in which is it
    declared.
    4. Implementing an abstract method in a subclass follows the
    same rules for overriding a method, including covariant return
    types, exception declarations, etc.
    5. Interface methods without a body are assumed to be abstract
    and public.
    ® Notice anything? The first four rules for abstract methods,
    whether they be defined in abstract classes or interfaces, are
    exactly the same! The only new rule you need to learn for
    interfaces is the last one.
    Finally, there are two rules to remember for interface variables.

    #Interface Variables Rules
    1. Interface variables are assumed to be public, static, and final.
    2. Because interface variables are marked final, they must be
    initialized with a value when they are declared.

    ø There are four types of nested classes you will need to know about: member inner classes, local classes,
     anonymous classes, and static nested classes.

    ø While top-level classes and interfaces can only be set with public or package-private access, member inner classes do not
    have the same restriction. A member inner class can be declared with all the same access modifiers as a class member,
    such as public, protected, default (package-private),or private.
    ~ public class Zoo {
    ~ public class Ticket {}
    }
    ~ public class Zoo {
    ~ private interface Paper {}
    ~ public class Ticket implements Paper {}
    }














     */
}
