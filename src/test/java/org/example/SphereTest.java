package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SphereTest {
    @Test
    void constructSphere() {
        Sphere sphere = new Sphere();
        assertEquals(new Point(0,0,0), sphere.getOrigin());
        assertEquals(new Matrix(), sphere.getTransform());
    }

    @Test
    void getSurfaceNormalAtXAxis() {
        Sphere sphere = new Sphere();
        Vector surfaceNormal = sphere.normalAt(new Point(1,0,0));
        assertEquals(new Vector(1,0,0), surfaceNormal);
    }
    @Test
    void getSurfaceNormalAtYAxis() {
        Sphere sphere = new Sphere();
        Vector surfaceNormal = sphere.normalAt(new Point(0,1,0));
        assertEquals(new Vector(0,1,0), surfaceNormal);
    }
    @Test
    void getSurfaceNormalAtZAxis() {
        Sphere sphere = new Sphere();
        Vector surfaceNormal = sphere.normalAt(new Point(0,0,1));
        assertEquals(new Vector(0,0,1), surfaceNormal);
    }

    @Test
    void getSurfaceNormalAtNonAxialPoint() {
        Sphere sphere = new Sphere();
        float value = (float) (Math.sqrt(3)/3);
        Vector surfaceNormal = sphere.normalAt(new Point(value,value,value));
        assertEquals(new Vector(value,value,value), surfaceNormal);
    }
    @Test
    void getSurfaceNormalGivesNormalizedVector() {
        Sphere sphere = new Sphere();
        float value = (float) (Math.sqrt(3)/3);
        Vector surfaceNormal = sphere.normalAt(new Point(value,value,value));
        assertEquals(surfaceNormal.normalize(), surfaceNormal);
    }

    @Test
    void getSurfaceNormalOnATranslatedSphere() {
        Sphere sphere = new Sphere();
        sphere.setTransform(Matrix.translation(0,1,0));
        Vector surfaceNormal = sphere.normalAt(new Point(0,1.70711f,-0.70711f));
        assertEquals(new Vector(0,0.70711f,-0.70711f), surfaceNormal);
    }
    @Test
    void getSurfaceNormalOnATransformedSphere() {
        Sphere sphere = new Sphere();
        sphere.setTransform(Matrix.scaling(1,0.5f,1).multiply(Matrix.zRotation((float) Math.PI/5)));
        float value = (float) (Math.sqrt(2)/2);
        Vector surfaceNormal = sphere.normalAt(new Point(0,value,-(value)));
        assertEquals(new Vector(0,0.97014f,-0.24254f), surfaceNormal);
    }
    @Test
    void getSphereMaterials() {
        Sphere sphere = new Sphere();
        Material material = new Material();
        assertEquals(material, sphere.getMaterial());
    }

}