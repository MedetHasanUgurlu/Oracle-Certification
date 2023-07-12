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

Hacker Harry is tricky, though. He decides to send us a favoriteFood
object but keep his own secret reference to it, which he can
modify directly.

        var favorites = new ArrayList<String>();
        favorites.add("Apples");
        Animal animal = new Animal(favorites);
        System.out.println(animal.getFavoriteFoodsCount());
        favorites.clear();
        System.out.println(animal.getFavoriteFoodsCount());

**_Result_**\
1\
0

It seems like
Animal is not immutable anymore, since its contents can change
after it is created. The solution is to use a _**copy constructor**_ to
make a copy of the list object containing the same elements.


    public Animal(ArrayList<String> favoriteFoods){
        this.favoriteFoods = new ArrayList<>(favoriteFoods);
    }
**_Result_**\
1\
1

### CLONING OBJECTS

Java has a `Cloneable` interface that you can implement if you
want classes to be able to call the `clone()` method on your
object. This helps with making defensive copies.

    this.favoriteFoods = (ArrayList) favoriteFoods.clone();

## Introducing Injection and Input Validation

### PREVENTING INJECTION WITH A PREPAREDSTATEMENT
WAITING FOR JDBC SECTION



### INVALIDATING INVALID INPUT WITH VALIDATION
SQL injection isn't the only type of injection. Command
injection is another type that uses operating system commands
to do something unexpected.

    Console console = System.console();
    String dirName = console.readLine();
    Path path = Paths.get("c:/data/diets/" + dirName);
    try (Stream<Path> stream = Files.walk(path)) {
        stream.filter(p -> p.toString().endsWith(".txt")).forEach(System.out::println);
    }

We tested it by typing in mammals and got the expected output.

_**Result**_ \
c:/data/diets/mammals/Platypus.txt

<div align="center">
<img src="img.png">
</div>

Then Hacker Harry came along and typed .. as the directory
name.

**_Input_** \
c:/data/diets/../secrets/giraffeDueDate.txt\
c:/data/diets/../diets/mammals/Platypus.txt\
c:/data/diets/../diets/birds/turkey.txt

Oh, no! Hacker Harry knows we are expecting a baby giraffe
just from the filenames. We were not intending for him to see
the secrets directory.

We will use a whitelist that
allows us to specify which values are allowed.

    Console console = System.console();
        String dirName = console.readLine();
        if (dirName.equals("mammal") || dirName.equals("birds")) {
            Path path = Paths.get("c:/data/diets/" + dirName);
            try (Stream<Path> stream = Files.walk(path)) {
                stream.filter(p -> p.toString().endsWith(".txt")).forEach(System.out::println);
        }
    }

## Working with Confidential Information

When working on a project, you will often encounter
confidential or sensitive data. Sometimes there are even laws
that mandate proper handling of data

he is careful what methods she calls in these sensitive contexts
to ensure confidential information doesn't escape. Such
sensitive contexts include the following:
Writing to a log file
Printing an exception or stack trace
System.out and System.err messages
Writing to data files

### PROTECTING DATA IN MEMORY
If application crashes, it may generate a dump file. That
contains values of everything in memory.

> When calling the `readPassword()` on Console, it returns a` char[]`
instead of a `String`. This is safer for two reasons.
1. It is not stored as a String, so Java won't place it in the String
   pool, where it could exist in memory long after the code that
   used it is run.
2. You can null out the value of the array element rather than
   waiting for the garbage collector to do it.\
<br>


      Console console = System.console();
      char[] password = console.readPassword();
      Arrays.fill(password, 'x');
<br>

      LocalDate dateOfBirth = getDateOfBirth();
      // use date of birth
      dateOfBirth = null;


> When the sensitive data cannot be overwritten, it is good
practice to set confidential data to null when you're done using
it. If the data can be garbage collected, you don't have to worry
about it being exposed later.

### LIMITING FILE ACCESS

    grant {
        permission java.io.FilePermission
        "C:\\water\\fish.txt",
        "read";
    };

This policy gives the programmer permission to read, but not
update, the fish.txt file. 

## Serializing and Deserializing Objects

Imagine we are storing data in an Employee record. We want to
write this data to a file and read this data back into memory,
but we want to do so without writing any potentially sensitive
data to disk.

>  Java skips calling the constructor
when deserializing an object. This means it is important not to
rely on the constructor for custom validation logic.



    import java.io.*;
    public class Employee implements Serializable {
        private String name;
        private int age;
        // Constructors/getters/setters
    }

### SPECIFYING WHICH FIELDS TO SERIALIZE

Our zoo has decided that employee age information is sensitive
and shouldn't be written to disk.

you can specify fields to be serialized in an array.

    private static final ObjectStreamField[] serialPersistentFields = { new ObjectStreamField("name", String.class) };

You can think of serialPersistentFields as the opposite of
transient. The former is a whitelist of fields that should be
serialized, while the latter is a blacklist of fields that should not.

### CUSTOMIZING THE SERIALIZATION PROCESS
Security may demand custom serialization. In our case, we got
a new requirement to add the Social Security number to our
object.

Unlike age, we do need to
serialize this information. However, we don't want to store the
Social Security number in plain text, so we need to write some
custom code.

    import java.io.*;
    public class Employee implements Serializable {
        private String name;
        private String ssn;
        private int age;
        
        // Constructors/getters/setters
        private static final ObjectStreamField[] serialPersistentFields = { new ObjectStreamField("name", String.class), new ObjectStreamField("ssn", String.class) };
        
        private static String encrypt(String input) {
            // Implementation omitted
        }
        private static String decrypt(String input) {
            // Implementation omitted
        }
        
        private void writeObject(ObjectOutputStream s) throws Exception {
            ObjectOutputStream.PutField fields = s.putFields();
            fields.put("name", name);
            fields.put("ssn", encrypt(ssn));
            s.writeFields();
        }
        private void readObject(ObjectInputStream s) throws Exception {
            ObjectInputStream.GetField fields = s.readFields();
            this.name = (String)fields.get("name", null);
            this.ssn = decrypt((String)fields.get("ssn", null));
        }
    }

### PRE/POST-SERIALIZATION PROCESSING

Suppose our zoo employee application is having a problem with
duplicate records being created for each employee. They decide
that they want to maintain a list of all employees in memory
and only create users as needed. Furthermore, each employee's
name is guaranteed to be unique. Unlikely in practice we know,
but this is a special zoo!
From what you learned about concurrent collections and factory methods, we can accomplish
this with a private constructor and factory method.

    import java.io.*;
    import java.util.Map;
    import java.util.concurrent.ConcurrentHashMap;
    
    public Employee{
      private int id;
      private String name;
      private Employee(){
      }
      
      private static Map<String,Emplpyee> pool = new ConcurrentHashMap<>();
      
      public synchronized static Employee(String name){
          if(pool.get(name)== null){ 
              Employee e  = new Employee();
              e.setName(name);
              pool.put(name,e);
              return e;
          }
          return pool.get(name);
          
      }
   }

### readResolve()
When someone reads the data
from the disk, it deserializes it into a new object, not the one in
memory pool. This could result in two users holding different
versions of the Employee in memory!

Enter the readResolve() method. When this method is present,
it is run after the readObject() method and is capable of
replacing the reference of the object returned by
deserialization.

<br>


      import java.io.*;
      import java.util.Map;
      import java.util.concurrent.ConcurrentHashMap;
      public class Employee implements Serializable {
         …
         public synchronized Object readResolve() throws ObjectStreamException {
            var existingEmployee = pool.get(name);
            if(pool.get(name) == null) {
               // New employee not in memory
               pool.put(name, this);
               return this;
            } else {
               // Existing user already in memory
               existingEmployee.name = this.name;
               existingEmployee.ssn = this.ssn;
               return existingEmployee;
             }
         }
      }
> Notice that we added the `synchronized` modifier to this method.
Java allows any method modifiers (except `static`) for the
`readResolve()` method including any access modifier. This rule
applies to `writeReplace()`, which is up next.

### writeReplace()

      import java.io.*;
         import java.util.Map;
         import java.util.concurrent.ConcurrentHashMap;
         public class Employee implements Serializable {
         …
         public Object writeReplace() throws ObjectStreamException {
         var e = pool.get(name);
         return e != null ? e : this;
         }
      }
