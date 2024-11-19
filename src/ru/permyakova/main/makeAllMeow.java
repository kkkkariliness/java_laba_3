package ru.permyakova.main;

import java.util.List;

public class makeAllMeow {
    public static void output(List<Meowable> meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }
}
