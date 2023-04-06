# Oracle-Certification Chapter 5-Core Java API
****

#“You take the blue pill – the story ends, you wake up in your bed and believe whatever you want to believe. You take the red pill – you stay in Wonderland and I show you how deep the rabbit-hole goes.”
#### 'Morpheus'
*****    
    1. If both operands are numeric, + means numeric addition.
    2. If either operand is a String, + means concatenation.
    3. The expression is evaluated left to right.    

    System.out.println(1 + 2); // 3
    System.out.println("a" + "b"); // ab
    System.out.println("a" + "b" + 3); // ab3
    System.out.println(1 + 2 + "c"); // 3c
    System.out.println("c" + 1 + 2); // c12
    
    ® Once a String object is created, it is not allowed to change. It
    cannot be made larger or smaller, and you cannot change one
    of the characters inside it.

    String string = "animals";
    System.out.println(string.substring(3)); // mals
    System.out.println(string.substring(string.indexOf('m'))); // mals
    System.out.println(string.substring(3, 4)); // m
    System.out.println(string.substring(3, 7)); // mals

    System.out.println(string.substring(3, 3)); // empty string
    System.out.println(string.substring(3, 2)); // throws exception
    System.out.println(string.substring(3, 8)); // throws exception

    Unlike the String class, StringBuilder is not immutable.

    StringBuilder stringBuilder = new StringBuilder();
    for(char a = 'a';a<='z';a++){
        stringBuilder.append(a);
    }
    System.out.println(stringBuilder); //abcdefghijklmnopqrstuvwxyz

    Stringbuffer slower than StringBuilder so we should use instead of it.

    StringBuilder sb = new StringBuilder("abcdef");
    sb.delete(1, 3); // sb = adef
    sb.deleteCharAt(5); // throws an exception





