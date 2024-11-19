package ru.permyakova.main;

public class Power {
    public static double power(String base, String exponent) {
        int x = Integer.parseInt(base);
        int y = Integer.parseInt(exponent);
        return Math.pow(x, y);
    }
}
