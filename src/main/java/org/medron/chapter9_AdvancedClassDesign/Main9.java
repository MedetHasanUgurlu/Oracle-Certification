package org.medron.chapter9_AdvancedClassDesign;

public class Main9 {
    public static void main(String[] args) {

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












     */
}
