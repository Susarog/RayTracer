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
        Intersection[] xs = r.intersect(s);
        assertEquals(2,xs.length);
        assertEquals(4.0,xs[0].getTime());
        assertEquals(6.0,xs[1].getTime());
        assertEquals(s,xs[0].getObject());
        assertEquals(s,xs[1].getObject());
    }
    @Test
    void rayIntersectsASphereAtOnePoints() {
        Ray r = new Ray(new Point(0f,1f,-5f),new Vector(0f,0f,1f));
        Sphere s = new Sphere();
        Intersection[] xs = r.intersect(s);
        assertEquals(2,xs.length);
        assertEquals(5.0f,xs[0].getTime());
        assertEquals(5.0f,xs[1].getTime());
        assertEquals(s,xs[0].getObject());
        assertEquals(s,xs[1].getObject());
    }
    @Test
    void rayMissesASphere() {
        Ray r = new Ray(new Point(0f,2f,-5f),new Vector(0f,0f,1f));
        Sphere s = new Sphere();
        Intersection[] xs = r.intersect(s);
        assertEquals(0,xs.length);
    }
    @Test
    void rayIntersectsASphereAtTheOrigin() {
        Ray r = new Ray(new Point(0f,0f,0f),new Vector(0f,0f,1f));
        Sphere s = new Sphere();
        Intersection[] xs = r.intersect(s);
        assertEquals(2,xs.length);
        assertEquals(-1f,xs[0].getTime());
        assertEquals(1f,xs[1].getTime());
        assertEquals(s,xs[0].getObject());
        assertEquals(s,xs[1].getObject());
    }
    @Test
    void rayIsBehindTheSphere() {
        Ray r = new Ray(new Point(0f,0f,5f),new Vector(0f,0f,1f));
        Sphere s = new Sphere();
        Intersection[] xs = r.intersect(s);
        assertEquals(2,xs.length);
        assertEquals(-6f,xs[0].getTime());
        assertEquals(-4f,xs[1].getTime());
        assertEquals(s,xs[1].getObject());
    }
    @Test
    void rayTranslation() {
        Ray r = new Ray(new Point(1f,2f,3f),new Vector(0f,1f,0f));
        Matrix transformMatrix = Matrix.translation(3,4,5);
        Ray r2 = r.transform(transformMatrix);

        assertEquals(new Point(4f,6f,8f),r2.getOrigin());
        assertEquals(new Vector(0f,1f,0f),r2.getDirection());
    }
    @Test
    void rayScaling() {
        Ray r = new Ray(new Point(1f,2f,3f),new Vector(0f,1f,0f));
        Matrix transformMatrix = Matrix.scaling(2,3,4);
        Ray r2 = r.transform(transformMatrix);

        assertEquals(new Point(2f,6f,12f),r2.getOrigin());
        assertEquals(new Vector(0f,3f,0f),r2.getDirection());
    }
    @Test
    void storeSphereTransform() {
        Sphere s = new Sphere();
        assertEquals(new Matrix(),s.getTransform());
    }
    @Test
    void changingSphereTransform() {
        Sphere s = new Sphere();
        Matrix transformMatrix = Matrix.scaling(2,3,4);
        s.setTransform(transformMatrix);
        assertEquals(transformMatrix,s.getTransform());
    }
    @Test
    void scaledSphereWithRay() {
        Ray r = new Ray(new Point(0,0,-5), new Vector(0,0,1));
        Sphere s = new Sphere();
        Matrix transformMatrix = Matrix.scaling(2,2,2);
        s.setTransform(transformMatrix);
        Intersection[] xs = r.intersect(s);

        assertEquals(2,xs.length);
        assertEquals(3f,xs[0].getTime());
        assertEquals(7f,xs[1].getTime());
    }
    @Test
    void translatedSphereWithRay() {
        Ray r = new Ray(new Point(0,0,-5), new Vector(0,0,1));
        Sphere s = new Sphere();
        Matrix transformMatrix = Matrix.translation(5,0,0);
        s.setTransform(transformMatrix);
        Intersection[] xs = r.intersect(s);

        assertEquals(0,xs.length);
    }

}