package org.example;

public class Sphere {
// Instance variables
    private float radius;
    private Point origin;

    // Constructor
    public Sphere() {
        origin = new Point(0,0,0);
    }

    public Point getOrigin() {
        return origin;
    }
}
