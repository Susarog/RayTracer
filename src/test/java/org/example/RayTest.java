package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RayTest {
    @Test
    void constructRay() {
        Point origin = new Point(1,2,3);
        Vector direction = new Vector(4,5,6);

        Ray r = new Ray(origin,direction);
        assertSame(r.getDirection(), direction);
        assertSame(r.getOrigin(), origin);
    }

    @Test
    void computePointFromDistance() {
        Point origin = new Point(1,2,3);
        Vector direction = new Vector(0f,0f,1f);
        float time = 3.5f;
        Ray r = new Ray(origin,direction);
        Point newPoint = r.position(time);
        assertEquals(new Point(1,2,6.5f), newPoint);
    }

    @Test
    void rayIntersectsASphereAtTwoPoints() {
        Ray r = new Ray(new Point(0f,0f,-5f),new Vector(0f,0f,1f));
        Sphere s = new Sphere();
        float[] xs = r.intersect(s);
        assertEquals(2,xs.length);
        assertEquals(4.0,xs[0]);
        assertEquals(6.0,xs[1]);
    }
    @Test
    void rayIntersectsASphereAtOnePoints() {
        Ray r = new Ray(new Point(0f,1f,-5f),new Vector(0f,0f,1f));
        Sphere s = new Sphere();
        float[] xs = r.intersect(s);
        assertEquals(2,xs.length);
        assertEquals(5.0f,xs[0]);
        assertEquals(5.0f,xs[1]);
    }
    @Test
    void rayMissesASphere() {
        Ray r = new Ray(new Point(0f,2f,-5f),new Vector(0f,0f,1f));
        Sphere s = new Sphere();
        float[] xs = r.intersect(s);
        assertEquals(0,xs.length);
    }
    @Test
    void rayIntersectsASphereAtTheOrigin() {
        Ray r = new Ray(new Point(0f,0f,0f),new Vector(0f,0f,1f));
        Sphere s = new Sphere();
        float[] xs = r.intersect(s);
        assertEquals(2,xs.length);
        assertEquals(-1f,xs[0]);
        assertEquals(1f,xs[1]);
    }
    @Test
    void rayIsBehindTheSphere() {
        Ray r = new Ray(new Point(0f,0f,5f),new Vector(0f,0f,1f));
        Sphere s = new Sphere();
        float[] xs = r.intersect(s);
        assertEquals(2,xs.length);
        assertEquals(-6f,xs[0]);
        assertEquals(-4f,xs[1]);
    }

}