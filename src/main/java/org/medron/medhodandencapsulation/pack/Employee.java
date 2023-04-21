package org.medron.medhodandencapsulation.pack;

import org.medron.medhodandencapsulation.pack2.User;

public class Employee extends User {
    public Employee(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Employee user = new Employee("Eto");
        user.protectName();

    }
}
