package org.medron.annotations.pack;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/*
* @deprecated
*
* */
@Deprecated
@Documented
@Target({ElementType.METHOD,ElementType.FIELD})
public @interface Hazard{
    String veterinarian() default "unsigned";
    String value() default "foot";

}
