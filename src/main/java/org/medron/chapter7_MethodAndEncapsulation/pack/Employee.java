package org.medron.chapter7_MethodAndEncapsulation.pack;

import org.medron.chapter7_MethodAndEncapsulation.pack2.User;

public class Employee extends User {
    public Employee(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Employee user = new Employee("Eto");
        user.protectName();

    }
}
