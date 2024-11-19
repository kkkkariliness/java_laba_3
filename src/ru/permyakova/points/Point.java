package ru.permyakova.points;

public class Point {
    private final double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() { return this.x; }
    double getY() {
        return this.y;
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    public boolean equals(Point point) {
        if (point == null) return false;
        return this.x == point.x && this.y == point.y;
    }
}