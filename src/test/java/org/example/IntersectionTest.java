package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionTest {
    @Test
    void intersectionConstructor() {
        Sphere s = new Sphere();
        float time = 3.5f;
        Intersection i = new Intersection(time, s);
        assertEquals(time,i.getTime());
        assertEquals(s,i.getObject());
    }

    @Test
    void aggregatingIntersection() {
        Sphere s = new Sphere();
        Intersection i1 = new Intersection(1, s);
        Intersection i2 = new Intersection(2, s);
        Intersection[] xs = Intersection.intersections(i1,i2);
        assertEquals(2,xs.length);
        assertEquals(1,xs[0].getTime());
        assertEquals(2,xs[1].getTime());
    }

    @Test
    void gettingHitIntersectionWithPositiveValues() {
        Sphere s = new Sphere();
        Intersection i1 = new Intersection(1, s);
        Intersection i2 = new Intersection(2, s);
        Intersection[] xs = Intersection.intersections(i1,i2);
        Intersection hitIntersection = Intersection.hit(xs);
        assertEquals(1,hitIntersection.getTime());
    }
    @Test
    void gettingHitIntersectionWithOneNegativeAndPositiveValue() {
        Sphere s = new Sphere();
        Intersection i1 = new Intersection(-1, s);
        Intersection i2 = new Intersection(1, s);
        Intersection[] xs = Intersection.intersections(i1,i2);
        Intersection hitIntersection = Intersection.hit(xs);
        assertEquals(1,hitIntersection.getTime());
    }
    @Test
    void gettingHitIntersectionWithNegativeValues() {
        Sphere s = new Sphere();
        Intersection i1 = new Intersection(-2, s);
        Intersection i2 = new Intersection(-1, s);
        Intersection[] xs = Intersection.intersections(i1,i2);
        Intersection hitIntersection = Intersection.hit(xs);
        assertNull(hitIntersection);
    }
    @Test
    void gettingHitIntersection() {
        Sphere s = new Sphere();
        Intersection i1 = new Intersection(5, s);
        Intersection i2 = new Intersection(7, s);
        Intersection i3 = new Intersection(-3, s);
        Intersection i4 = new Intersection(2, s);
        Intersection[] xs = Intersection.intersections(i1,i2,i3,i4);
        Intersection hitIntersection = Intersection.hit(xs);
        assertEquals(2,hitIntersection.getTime());
    }
}