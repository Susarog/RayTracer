package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaterialTest {
    @Test
    void getMaterialAttributes() {
        Material material = new Material();
        assertEquals(new Color(1,1,1), material.getColor());
        assertEquals(0.1f, material.getAmbient());
        assertEquals(0.9f, material.getDiffuse());
        assertEquals(0.9f, material.getSpecular());
        assertEquals(200.0f, material.getShininess());
    }
    @Test
    void lightingWithEyeBetweenLightAndSurface() {
        Material material = new Material();
        Point position = new Point(0,0,0);
        Vector eyeVec = new Vector(0,0,-1);
        Vector normalVec = new Vector(0,0,-1);
        Light light = new Light(new Point(0,0,-10), new Color(1,1,1));
        Color result = light.lighting(material, position, eyeVec, normalVec);
        assertEquals(new Color(1.9f,1.9f,1.9f), result);
    }
    @Test
    void lightingWithOffset45DegEyeBetweenLightAndSurfaceBut() {
        Material material = new Material();
        Point position = new Point(0,0,0);
        Vector eyeVec = new Vector(0,(float)Math.sqrt(2)/2,(float)-Math.sqrt(2)/2);
        Vector normalVec = new Vector(0,0,-1);
        Light light = new Light(new Point(0,0,-10), new Color(1,1,1));
        Color result = light.lighting(material, position, eyeVec, normalVec);
        assertEquals(new Color(1.0f,1.0f,1.0f), result);
    }
    @Test
    void offset45DeglightingWithEyeOppositeOfSurface() {
        Material material = new Material();
        Point position = new Point(0,0,0);
        Vector eyeVec = new Vector(0,0,-1);
        Vector normalVec = new Vector(0,0,-1);
        Light light = new Light(new Point(0,10,-10), new Color(1,1,1));
        Color result = light.lighting(material, position, eyeVec, normalVec);
        assertEquals(new Color(0.7364f,0.7364f,0.7364f), result);
    }
    @Test
    void lightingWithEyeOnReflectionVector() {
        Material material = new Material();
        Point position = new Point(0,0,0);
        Vector eyeVec = new Vector(0,(float)-(Math.sqrt(2)/2),(float)-(Math.sqrt(2)/2));
        Vector normalVec = new Vector(0,0,-1);
        Light light = new Light(new Point(0,10,-10), new Color(1,1,1));
        Color result = light.lighting(material, position, eyeVec, normalVec);
        float value = (float) (0.1 + 0.9 * (Math.sqrt(2)/2) + 0.9);
        assertEquals(new Color(value,value,value), result);
    }
    @Test
    void lightingOnOppositeSide() {
        Material material = new Material();
        Point position = new Point(0,0,0);
        Vector eyeVec = new Vector(0,0,-1);
        Vector normalVec = new Vector(0,0,-1);
        Light light = new Light(new Point(0,0,10), new Color(1,1,1));
        Color result = light.lighting(material, position, eyeVec, normalVec);
        assertEquals(new Color(0.1f,0.1f,0.1f), result);
    }
}