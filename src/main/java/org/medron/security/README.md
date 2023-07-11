# Security

## Designing a Secure Object

Java provides us with many tools to protect the objects that we
create. In this section, we will look at access control,
extensibility, validation, and creating immutable objects. All of
these techniques can protect your objects from Hacker Harry.

### LIMITING ACCESSIBILITY
    package animals.security;
        public class ComboLocks {
            public Map<String, String> combos;
    }
A key security principle is to limit access as much as possible. Think of it as “need to know”
for objects. This is called the _principle of least privilege_.\
It would be better to make the combos object private and write a method to provide the
necessary functionality.

    package animals.security;

    public class ComboLocks {
        private Map<String, String> combos;
        public boolean isComboValid(String animal, String combo) {
            var correctCombo = combos.get(animal);
            return combo.equals(correctCombo);
        }
    }
    


This is far better; we don't expose the combinations map to any
classes outside the ComboLocks class. For example, package‐
private is better than public, and private is better than
package‐private.

> If your application is using modules, you can do even better by only
exporting the security packages to the specific modules that
should have access.
    
    exports animals.security to zoo.staff;

### RESTRICTING EXTENSIBILITY

Suppose you are working on a class that uses ComboLocks.

    public class GrasshopperCage {
        public static void openLock(ComboLocks comboLocks, String combo) {
            if (comboLocks.isComboValid("grasshopper", combo)){
                System.out.println("Open!");
            }
        }
    }

Ideally, the first variable passed to this method is an instance of
the `ComboLocks` class. However, Hacker Harry is hard at work
and has created this subclass of `ComboLocks`.


    public class EvilComboLocks extends ComboLocks {

        public boolean isComboValid(String animal, String combo) {
            var valid = super.isComboValid(animal, combo);
            if (valid) {
                // email the password to Hacker Harry
            }
        return valid;
        }
    }

Marking a sensitive class as **`final`** prevents any subclasses.

    public final class ComboLocks {

        private Map<String, String> combos;
        // instantiate combos object
        public boolean isComboValid(String animal, String combo) {
            var correctCombo = combos.get(animal);
            return combo.equals(correctCombo);
        }
    }

### CREATING IMMUTABLE OBJECTS
An immutable object is one that cannot change
state after it is created.

Immutable objects are helpful when
writing **secure code** because you don't have to worry about the
values changing.
They also simplify code when dealing with
**concurrency**.

`String`, `List.of()`, `Set.of()`, and `Map.of()`. All three of these methods return
immutable types.

Strategy for making a class immutable.
1. Mark the class as final.
2. Mark all the instance variables private.
3. Don't define any setter methods and make fields final. 
4. Don't allow referenced mutable objects to be modified. DON'T EXPOSE MUTABLE OBJECT WITH USING GETTER
5. Use a constructor to set all properties of the object, making a copy if needed.


    import java.util.*;
    
    public final class Animal {
        private final ArrayList<String> favoriteFoods;
    
        public Animal() {
            this.favoriteFoods = new ArrayList<String>();
            this.favoriteFoods.add("Apples");
        }
        public List<String> getFavoriteFoods() {
            return favoriteFoods;
        }
    }




