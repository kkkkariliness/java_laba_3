package ru.permyakova.animals;

import static java.lang.System.out;

// Кукушка
public class Cuckoo extends Bird {
    public void sing() {
        int k = (int) (Math.random()*10) + 1;
        for (int i = 0; i < k; i++) {
            out.print("ку-ку ");
        }
        out.println();
    }
}
