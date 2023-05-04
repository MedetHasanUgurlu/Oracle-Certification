package org.medron.genericsandendcapsulation.pack5;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SizeLimitedCrate <T,U>{
    private T data;
    private U units;

    public SizeLimitedCrate(T data, U units) {
        this.data = data;
        this.units = units;
    }

    public static <X> X  x(X t){
        return t;
    }
}
