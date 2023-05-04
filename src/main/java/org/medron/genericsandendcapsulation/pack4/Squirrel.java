package org.medron.genericsandendcapsulation.pack4;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Squirrel {
    private int weight;
    private String species;

    @Override
    public String toString() {
        return weight+" "+species;
    }
}
