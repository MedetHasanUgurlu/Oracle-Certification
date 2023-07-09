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

