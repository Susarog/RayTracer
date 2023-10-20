package org.example;

import java.util.Dictionary;

public class Ray {
    public Point position(float time) {
        Vector scaledDirection = direction.multiply(time);
        return origin.add(scaledDirection);
    }

    public Ray(Point origin, Vector direction){
        this.origin = origin;
        this.direction = direction;
    }

    public float[] intersect(Sphere obj) {
        Vector sphereToRay = origin.subtract(obj.getOrigin());
        float a = direction.dotProduct(direction);
        float b = direction.dotProduct(sphereToRay) * 2;
        float c = sphereToRay.dotProduct(sphereToRay) - 1;
        float discriminant = b*b - 4 * a * c;
        if (discriminant < 0) {
            return new float[]{};
        }
        float t1 = (float) ((-b - Math.sqrt(discriminant))/(2*a));
        float t2 = (float) ((-b + Math.sqrt(discriminant))/(2*a));
        return new float[]{t1,t2};
    }

    private Point origin;
    private Vector direction;


    public Point getOrigin() {
        return origin;
    }

    public Vector getDirection() {
        return direction;
    }
}
