# NIO.2

we focus on the java.nio version 2 API, or NIO.2
for short, to interact with files. NIO.2 is an acronym that stands
for the second version of the **Non‐blocking Input/Output API**,
and it is sometimes referred to as the “**_New I/O._**”
## Introducing NIO.2

we mean that the preferred approach for working
with files and directories with newer software applications is to
use NIO.2, rather than java.io.File. As you'll soon see, the
NIO.2 provides many features and performance improvements
than the legacy class supported.

### INTRODUCING PATH
The cornerstone of NIO.2 is Path interface. It s replace of File.class.
They have similar properties; however, Path interface contains support for symbolic links.

A **symbolic link** is a special file within a file
system that serves as a reference or pointer to another file or
directory. For instance symbolic link from
/zoo/favorite to /zoo/cats/lion.

<div align="center">
<img src="img.png">
</div>

### CREATING PATH
Path is interface so can not create directly, we will use static-factory method to create a path objects.

#### Path.of()
    Path path = Path.of("pandas/cuddly.png"); RELATIVE PATH
    Path path2 = Path.of("c:\\zooinfo\\November\\employees.txt"); ABSOLUTE PATH
    Path path3 = Path.of("/home/zoodirectory"); ABSOLUTE PATH

#### Path.get()
    Path path1 = Paths.get("pandas/cuddly.png");
    Path path2 = Paths.get("c:\\zooinfo\\November\\employees.txt");
    Path path3 = Paths.get("/", "home", "zoodirectory");

#### Obtaining a Path with a URI Class

**A uniform resource identifier (URI)** is a string of
characters that identify a resource.

file:// for local file systems

http://, https://, and ftp:// for remote file systems.

#### Obtaining a Path from the FileSystem Class
FileSystems class creates instances of the abstract FileSystem class.
The FileSystem class includes methods for working with the file system directly.
In fact, both Paths.get() and Path.of() are actually shortcuts for this FileSystem


    Path path1 = FileSystems.getDefault().getPath("pandas/cuddly.png");
    Path path2 = FileSystems.getDefault().getPath("c:\\zooinfo\\November\\employees.txt");
    Path path3 = FileSystems.getDefault().getPath("/home/zoodirectory");

#### Obtaining a Path from the java.io.File Class

    File file = new File("husky.png");
    Path path = file.toPath();
    File backToFile = path.toFile();

These methods are available for convenience and also to help
facilitate integration between older and newer APIs.
### ABSOLUTE VS. RELATIVE PATHS

**Absolute:**
* /bird/parrot.png and /bird/../data/./info \
* c:/bird/parrot.png

**Relative**
* bird/parrot.png


### CONNECTING TO REMOTE FILE SYSTEMS
    
    FileSystem fileSystem = FileSystems.getFileSystem(new URI("http://www.selikoff.net"));
    Path path = fileSystem.getPath("duck.txt");

This code is useful when we need to construct Path objects
frequently for a remote file system. NIO.2 gives us the
power to connect to both local and remote file systems


### UNDERSTANDING COMMON NIO.2 FEATURES

#### Applying Path Symbols
Absolute and relative paths can contain path symbols. A path
symbol is a reserved series of characters that have special
meaning within some file systems.

<div align="center">
<img src="img_1.png">
<img src="img_2.png">
</div>

#### Providing Optional Arguments
<div align="center">
<img src="img_4.png">
</div>

    Path path = Paths.get("schedule.xml");
    boolean exists = Files.exists(path, LinkOption.NOFOLLOW_LINKS);

## Interacting with Paths

Path instances are immutable. In the
following example, the Path operation on the second line is lost
since p is immutable.

    Path p = Path.of("whale");
    p.resolve("krill");
    System.out.println(p); // whale


Many of the methods available in the Path interface transform
the path value in some way and return a new Path object,
allowing the methods to be chained.

    Path.of("/zoo/../home").getParent().normalize().toAbsolutePath();

### VIEWING THE PATH WITH TOSTRING(), GETNAMECOUNT(), AND GETNAME()
The Path interface contains three methods to retrieve basic
information about the path representation.

    public String toString()
    public int getNameCount()
    public Path getName(int index)


The `getNameCount()` and `getName()` methods are often used in
conjunction to retrieve the number of elements in the path and
a reference to each element, respectively.

    Path path = Paths.get("/land/hippo/harry.happy");
    System.out.println("The Path Name is: " + path);
    for(int i=0; i<path.getNameCount(); i++) {
        System.out.println(" Element " + i + " is: " + path.getName(i));
    }
_**Result**_ \
_The Path Name is: /land/hippo/harry.happy\
Element 0 is: land\
Element 1 is: hippo\
Element 2 is: harry.happy_

Even though this is an absolute path, the root element is not
included in the list of names. As we said, these methods do not
consider the root as part of the path.

    var p = Path.of("/");
    System.out.print(p.getNameCount()); // 0
    System.out.print(p.getName(0)); // IllegalArgumentException

> Notice that if you try to call getName() with an invalid index, it
will throw an exception at runtime.

### CREATING A NEW PATH WITH SUBPATH()

The Path interface includes a method to select portions of a
path.

    public Path subpath(int beginIndex, int endIndex)

> The references are inclusive of the beginIndex, and exclusive of
the endIndex.

    var p = Paths.get("/mammal/omnivore/raccoon.image");
    System.out.println("Path is: " + p);
    for (int i = 0; i < p.getNameCount(); i++) {
        System.out.println(" Element " + i + " is: " + p.getName(i));
    }
    System.out.println();
    System.out.println("subpath(0,3): " + p.subpath(0, 3));
    System.out.println("subpath(1,2): " + p.subpath(1, 2));
    System.out.println("subpath(1,3): " + p.subpath(1, 3));

_**Result**_\
Path is: /mammal/omnivore/raccoon.image\
Element 0 is: mammal\
Element 1 is: omnivore\
Element 2 is: raccoon.image\
subpath(0,3): mammal/omnivore/raccoon.image\
subpath(1,2): omnivore\
subpath(1,3): omnivore/raccoon.image


    var q = p.subpath(0, 4); // IllegalArgumentException
    var x = p.subpath(1, 1); // IllegalArgumentException


> Like getNameCount() and getName(), subpath() is 0‐indexed and
does not include the root. Also like getName(), subpath() throws
an exception if invalid indices are provided.

### ACCESSING PATH ELEMENTS WITH GETFILENAME(), GETPARENT(), AND GETROOT()
    
    public Path getFileName()
    public Path getParent()
    public Path getRoot()

The `getFileName()` returns the Path element of the current file
or directory.\
`getParent()` returns the full path of the
containing directory.\
The getParent() returns null if operated
on the root path or at the top of a relative path.

    public void printPathInformation(Path path) {
        System.out.println("Filename is: " + path.getFileName());
        System.out.println(" Root is: " + path.getRoot());
        Path currentParent = path;
        while((currentParent = currentParent.getParent()) != null) {
            System.out.println(" Current parent is: " + currentParent);
        }
    }

**_Test_**\

    printPathInformation(Path.of("zoo"));
    printPathInformation(Path.of("/zoo/armadillo/shells.txt"));
    printPathInformation(Path.of("./armadillo/../shells.txt"));

**_Result_**\
_Filename is: zoo\
Root is: null\
Filename is: shells.txt\
Root is: /\
Current parent is: /zoo/armadillo\
Current parent is: /zoo\
Current parent is: /\
Filename is: shells.txt\
Root is: null\
Current parent is: ./armadillo/..\
Current parent is: ./armadillo\
Current parent is: ._

### CHECKING PATH TYPE WITH ISABSOLUTE() AND TOABSOLUTEPATH()




> The current working directory can be selected from
System.getProperty("user.dir"). This is the value that
toAbsolutePath() will use when applied to a relative path.

    var path1 = Paths.get("C:\\birds\\egret.txt");
    System.out.println("Path1 is Absolute? " + path1.isAbsolute());
    System.out.println("Absolute Path1: " + path1.toAbsolutePath());
    var path2 = Paths.get("birds/condor.txt");
    System.out.println("Path2 is Absolute? " + path2.isAbsolute());
    System.out.println("Absolute Path2 " + path2.toAbsolutePath());

assume the current working directory is /home/work.

**_Result_**\
Path1 is Absolute? true\
Absolute Path1: C:\birds\egret.txt\
Path2 is Absolute? false\
Absolute Path2 /home/work/birds/condor.txt

### JOINING PATHS WITH RESOLVE()

Suppose you want to concatenate paths in a similar manner as
we concatenate strings. The Path interface provides two
resolve() methods for doing just that.

    public Path resolve(Path other)
    public Path resolve(String other)

**Test**

    Path path1 = Path.of("/cats/../panther");
    Path path2 = Path.of("food");
    System.out.println(path1.resolve(path2));
_**Result**_\
/cats/../panther/food

### DERIVING A PATH WITH RELATIVIZE()
The Path interface includes a method for constructing the
relative path from one Path to another, often using path
symbols.

Using Relative

    var path1 = Path.of("fish.txt");
    var path2 = Path.of("friendly/birds.txt");
    System.out.println(path1.relativize(path2));
    System.out.println(path2.relativize(path1));

_**Result**_\
../friendly/birds.txt\
../../fish.txt

Using Absolute

    Path path3 = Paths.get("E:\\habitat");
    Path path4 = Paths.get("E:\\sanctuary\\raven\\poe.txt");
    System.out.println(path3.relativize(path4));
    System.out.println(path4.relativize(path3));

_**Result**_\
..\sanctuary\raven\poe.txt\
..\..\..\habitat\

    Path path1 = Paths.get("/primate/chimpanzee");
    Path path2 = Paths.get("bananas.txt");
    path1.relativize(path2); // IllegalArgumentException

> The relativize() method requires that both paths are absolute
or both relative and throws an exception if the types are mixed.

    Path path3 = Paths.get("c:\\primate\\chimpanzee");
    Path path4 = Paths.get("d:\\storage\\bananas.txt");
    path3.relativize(path4); // IllegalArgumentException

> On Windows‐based systems, it also requires that if absolute
paths are used, then both paths must have the same root
directory or drive a letter. 
 

### CLEANING UP A PATH WITH NORMALIZE()
Remember, the path symbol .. refers to the parent directory,
while the path symbol . refers to the current directory. We can
apply normalize() to some of our previous paths.

    var p1 = Path.of("./armadillo/../shells.txt");
    System.out.println(p1.normalize()); // shells.txt

    var p2 = Path.of("/cats/../panther/food");
    System.out.println(p2.normalize()); // /panther/food

    var p3 = Path.of("../../fish.txt");
    System.out.println(p3.normalize()); // ../../fish.txt

## Operating on Files and Directories

Most of the methods we covered in the Path interface operate
on theoretical paths, which are not required to exist within the
file system. What if you want to rename a directory, copy a file,
or read the contents of a file?
> Many of the names for the methods in the NIO.2 Files
class are a lot more straightforward than what you saw in
the java.io.File class. For example, the java.io.File
methods renameTo() and mkdir() have been changed to
move() and createDirectory(), respectively, in the Files
class.
### CHECKING FOR EXISTENCE WITH EXISTS()

The first example checks whether a file exists, while the second
example checks whether a directory exists.


    var b1 = Files.exists(Paths.get("/ostrich/feathers.png"));
    System.out.println("Path " + (b1 ? "Exists" : "Missing"));

    var b2 = Files.exists(Paths.get("/ostrich"));
    System.out.println("Path " + (b2 ? "Exists" : "Missing"));

### MAKING DIRECTORIES WITH CREATEDIRECTORY() AND CREATEDIRECTORIES()
The createDirectory() will create a directory and throw an
exception if it already exists or the paths leading up to the
directory do not exist.

The createDirectories() works just like the java.io.File
method mkdirs(), in that it creates the target directory along
with any nonexistent parent directories leading up to the path.

    Files.createDirectory(Path.of("/bison/field"));
    Files.createDirectories(Path.of("/bison/field/pasture/green"));

### COPYING FILES WITH COPY()
The NIO.2 Files class provides a method for copying files and
directories within the file system.

    Files.copy(Paths.get("/panda/bamboo.txt"), Paths.get("/panda-save/bamboo.txt"));
    Files.copy(Paths.get("/turtle"), Paths.get("/turtleCopy"));

> When directories are copied, the copy is shallow. A shallow
copy means that the files and subdirectories within the
directory are not copied. A deep copy means that the entire tree
is copied, including all of its content and subdirectories. 

