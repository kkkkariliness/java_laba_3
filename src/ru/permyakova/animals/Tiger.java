package ru.permyakova.animals;

import ru.permyakova.main.Meowable;

import static java.lang.System.out;

public class Tiger implements Meowable {
    private String name;

    public Tiger(String name) {
        this.name = name;
    }

    String setName(String name) {
        this.name = name;
        return this.name;
    }
    String getName() {
        return this.name;
    }

    public String toString() {
        return "Тигр: " + name;
    }

    public void meow() {
        out.println(name + ": ррр!");
    }
}