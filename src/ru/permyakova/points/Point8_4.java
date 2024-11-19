package ru.permyakova.points;

public class Point8_4 implements Cloneable {
    private final double x, y;

    public Point8_4(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX(){return this.x;}
    double getY(){return this.y;}

    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    public boolean equals(Point8_4 point) {
        if (point == null) return false;
        return this.x == point.x && this.y == point.y;
    }

    public Point8_4 clone() {
        try {
            return (Point8_4)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Клонирование не поддерживается", e);
        }
    }
}
