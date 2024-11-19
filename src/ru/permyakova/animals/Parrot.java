package ru.permyakova.animals;

import static java.lang.System.out;

// Попугай
public class Parrot extends Bird {
    private String text;

    public Parrot(String text) {
        this.text = text;
    }
    public void sing() {
        int n = 1 + (int) (Math.random()*text.length());
        out.println(text.substring(0, n));
    }
}
