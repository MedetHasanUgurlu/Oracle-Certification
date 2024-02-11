# MODULES

***
**Benefits of Modules\
Better access control: In addition to the levels of access control covered in Chapter 5,
“Methods,” you can have packages that are only accessible to other packages in
the module.\
**Clearer dependency management**: Since modules specify what they rely on, Java can
complain about a missing JAR when starting up the program rather than when it is first
accessed at runtime.\
**Custom Java builds**: You can create a Java runtime that has only the parts of the JDK
that your program needs rather than the full one at over 150 MB.\
**Improved security**: Since you can omit parts of the JDK from your custom build, you
don’t have to worry about vulnerabilities discovered in a part you don’t use.\
**mproved performance**: Another benefit of a smaller Java package is improved startup
time and a lower memory requirement.\
**Unique package enforcement**: Since modules specify exposed packages, Java can ensure
that each package comes from only one module and avoid confusion about what is
being run.*


        javac --module-path mods
        -d feeding
        feeding/zoo/animal/feeding/*.java feeding/module-info.java

--module-path and -p  are equivalent.
What about the classpath?\
The classpath option has three possible forms: -cp, --class-path, and -classpath.\
You can still use these options. In fact, it is common to do so when writing non modular programs.
* Directory for class files -d <dir> 
*   Module path -p <path> --module-path <path>
