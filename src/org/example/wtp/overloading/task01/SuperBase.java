package org.example.wtp.overloading.task01;

public class SuperBase {
    public int i = 3;

    public void foo (Object o) {
        System.out.println("Object " + i);
    }
    public void foo (String s) {
        System.out.println("String " + i);
    }
}
