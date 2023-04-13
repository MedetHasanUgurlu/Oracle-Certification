package org.medron.chapter8_ClassDesign.pack;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User{
    private int salary;

    public Employee(Long id, String name, int salary) {
        super(id, name);
        this.salary = salary;
    }
}
