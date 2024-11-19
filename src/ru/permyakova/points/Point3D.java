package ru.permyakova.points;

public class Point3D {
    private double x, y, z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    double setX(double x) {
        this.x = x;
        return this.x;
    }
    double setY(double y) {
        this.y = y;
        return this.y;
    }
    double setZ(double z) {
        this.z = z;
        return this.z;
    }
    double getX(){return this.x;}
    double getY(){return this.y;}
    double getZ(){return this.z;}

    public String toString() {
        return "{" + x + "; " + y + "; " + z + "}";
    }
}