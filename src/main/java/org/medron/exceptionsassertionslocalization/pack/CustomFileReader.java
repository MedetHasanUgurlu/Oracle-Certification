package org.medron.exceptionsassertionslocalization.pack;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomFileReader implements AutoCloseable{
    private String tag;
    @Override
    public void close() throws Exception {
        System.out.println("Closed."+tag);
    }
}
