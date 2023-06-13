# I/O
Next, the root directory is the topmost directory in the file
system, from which all files and directories inherit. In
Windows, it is denoted with a drive name such as c:\, while on
Linux it is denoted with a single forward slash, /.

    File file = new File("C:\\Users\\mdths\\IdeaProjects\\Oracle Certification\\src\\main\\java\\org\\medron\\ıo\\pack\\test.txt");

### Byte Stream vs Character Stream
<div align="center">
    <table>
        <th>Byte Stream</th>
        <th>Character Stream</th>
        <tr>
            <td>1,0</td>
            <td>text, data</td>    
        </tr>
        <tr>
            <td>InputStream,OutputStream</td>
            <td>Reader,Writer</td>    
        </tr>
    </table>
</div>

### CHARACTER ENCODING

    Charset usAsciiCharset = Charset.forName("US-ASCII");
    Charset utf8Charset = Charset.forName("UTF-8");
    Charset utf16Charset = Charset.forName("UTF-16");

### Low-Level vs. High-Level Streams

* High-Level stream wraps the low-level stream.


    BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\Users\\mdths\\IdeaProjects\\Oracle Certification\\src\\main\\java\\org\\medron\\ıo\\pack\\test.txt")));


    try (var ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("zoo-data.txt")))) {
        System.out.print(ois.readObject());
    }

new BufferedInputStream(new FileReader("z.txt")); // DOES NOT COMPILE (Stream and Reader mixed.) \
new BufferedWriter(new FileOutputStream("z.txt")); // DOES NOT COMPILE (Stream and Reader mixed.)\
new ObjectInputStream(new FileOutputStream("z.txt")); // DOES NOT COMPILE (InputStream and OutputStream mixed) \
new BufferedInputStream(new InputStream()); // (can not create instance from interface) DOES NOT COMPILE


<div align="center">
<img src="img.png">
</div>