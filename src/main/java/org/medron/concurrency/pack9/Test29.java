package org.medron.concurrency.pack9;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings({"java:S106","java:S2276","java:S2274","java:S2446","java:S2142","java:S1130","java:S1602","java:S1481","java:S112","java:S1854"})
public class Test29 {
    private void removeLions() {
        System.out.println("Removing lions");
    }
    private void cleanPen() {
        System.out.println("Cleaning the pen");
    }
    private void addLions() {
        System.out.println("Adding lions");
    }
    public void performTask() {
        removeLions();
        cleanPen();
        addLions();
    }
    public static void main(String[] args) {
        Test29 test29 = new Test29();
        test29.performTask();

    }
}
