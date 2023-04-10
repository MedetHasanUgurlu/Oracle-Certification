package org.medron.chapter6_LambdaAndFunctionalInterface.pack4;

public class Student {
    private String name;
    private String lastName;
    private Long tc;

    public Student(String name, String lastName, Long tc) {
        this.name = name;
        this.lastName = lastName;
        this.tc = tc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getTc() {
        return tc;
    }

    public void setTc(Long tc) {
        this.tc = tc;
    }

    @Override
    public String toString() {
        return name+" "+ lastName;
    }
}
