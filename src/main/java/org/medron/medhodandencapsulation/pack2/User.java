package org.medron.medhodandencapsulation.pack2;

public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    protected String protectName(){
        return name+" protected";
    }
}
