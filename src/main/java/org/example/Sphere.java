package org.example;

public class Sphere {
    private Point origin;
    private Matrix transform;

    public Sphere() {
        origin = new Point(0,0,0);
        transform = new Matrix();
    }
    public Sphere(Matrix transform) {
        origin = new Point(0,0,0);
        this.transform = transform;
    }

    public Point getOrigin() {
        return origin;
    }

    public Matrix getTransform() {
        return transform;
    }

    public void setTransform(Matrix transform) {
        this.transform = transform;
    }
}
