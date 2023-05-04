package org.medron.genericsandendcapsulation.pack3;

import lombok.*;

import java.util.Collections;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Duck implements Comparable<Duck>{
    private int id;
    private String name;

    @Override
    public int compareTo(Duck o) {
        return id - o.getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Duck d = (Duck) obj;
        return  this.id == d.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return this.id+" " +this.name;
    }
}
