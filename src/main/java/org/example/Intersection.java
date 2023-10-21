package org.example;

public class Intersection {
    public Intersection(float time, Sphere object) {
        this.time = time;
        this.object = object;
    }

    public static Intersection[] intersections(Intersection... args){
        return args;
    }
    public static Intersection hit(Intersection[] intersections) {
        Intersection hitIntersection = null;
        float min = Float.MAX_VALUE;
        for (Intersection intersection : intersections) {
            float currentTime = intersection.getTime();
            if (!(currentTime < 0) && min > currentTime) {
                min = currentTime;
                hitIntersection = intersection;
            }
        }
        return hitIntersection;
    }

    private float time;
    //change this whenever I add more object
    private Sphere object;

    public float getTime() {
        return time;
    }

    public Sphere getObject() {
        return object;
    }
}
