package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TupleTest {
    private final static double EPSILON = 0.00001;
    @Test
    public void creatingTuple() {
        Tuple pointTuple = new Tuple(4.3f, -4.2f, 3.1f);
        Assertions.assertEquals(pointTuple.getValue(), 4.3f);
        Assertions.assertEquals(pointTuple.getValue1(), -4.2f);
        Assertions.assertEquals(pointTuple.getValue2(), 3.1f);
    }
    @Test
    public void creatingVector() {
        Vector pointTuple = new Vector(4.3f, -4.2f, 3.1f);
        Assertions.assertEquals(pointTuple.getX(), 4.3f);
        Assertions.assertEquals(pointTuple.getY(), -4.2f);
        Assertions.assertEquals(pointTuple.getZ(), 3.1f);
    }
    @Test
    public void creatingPoint() {
        Point pointTuple = new Point(4.3f, -4.2f, 3.1f);
        Assertions.assertEquals(pointTuple.getX(), 4.3f);
        Assertions.assertEquals(pointTuple.getY(), -4.2f);
        Assertions.assertEquals(pointTuple.getZ(), 3.1f);
    }
    @Test
    void addTwoVectors() {
        Vector a = new Vector(3.0f,-2.0f,5.0f);
        Vector b = new Vector(-2.0f,3.0f,1.0f);
        Assertions.assertEquals(new Vector(1.0f,1.0f,6.0f), a.add(b));
    }
    @Test
    void subtractTwoPoints() {
        Point a = new Point(3.0f,2.0f,1.0f);
        Point b = new Point(5.0f,6.0f,7.0f);
        Assertions.assertEquals(new Point(-2.0f,-4.0f,-6.0f), a.subtract(b));
    }
    @Test
    void subtractTwoVectors() {
        Vector a = new Vector(3.0f,2.0f,1.0f);
        Vector b = new Vector(5.0f,6.0f,7.0f);
        Assertions.assertEquals(new Vector(-2.0f,-4.0f,-6.0f), a.subtract(b));
    }
    @Test
    void subtractVectorFromZeroVector() {
        Vector v = new Vector(1.0f,-2.0f,3.0f);
        Vector zero = new Vector(0.0f,0.0f,0.0f);
        Assertions.assertEquals(new Vector(-1.0f,2.0f,-3.0f), zero.subtract(v));
    }

    @Test
    void negateTuple() {
        Tuple a = new Tuple(1.0f,-2.0f,3.0f);
        Tuple negativeA = a.negate();
        Assertions.assertEquals(new Tuple(-1.0f,2.0f,-3.0f), negativeA);
    }

    @Test
    void multiplyTupleByScalar() {
        Tuple a = new Tuple(1.0f,-2.0f,3.0f);
        Assertions.assertEquals(new Tuple(3.5f,-7,10.5f), a.multiply(3.5f));
    }
    @Test
    void multiplyTupleByFraction() {
        Tuple a = new Tuple(1.0f,-2.0f,3.0f);
        Assertions.assertEquals(new Tuple(0.5f,-1,1.5f), a.multiply(0.5f));
    }
    @Test
    void divideTupleByScalar() {
        Tuple a = new Tuple(1.0f,-2.0f,3.0f);
        Assertions.assertEquals(new Tuple(0.5f,-1,1.5f), a.divide(2));
    }
    @Test
    void computeMagnitudeOfXVector() {
        Vector a = new Vector(1.0f,0.0f,0.0f);
        Assertions.assertEquals(1,a.getMagnitude());
    }
    @Test
    void computeMagnitudeOfYVector() {
        Vector a = new Vector(0.0f,1.0f,0.0f);
        Assertions.assertEquals(1,a.getMagnitude());
    }
    @Test
    void computeMagnitudeOfZVector() {
        Vector a = new Vector(0.0f,0.0f,1.0f);
        Assertions.assertEquals(1,a.getMagnitude(), EPSILON);
    }
    @Test
    void computeMagnitudeOfVector() {
        Vector a = new Vector(1.0f,2.0f,3.0f);
        Assertions.assertEquals((float)Math.sqrt(14),a.getMagnitude(), EPSILON);
    }
    @Test
    void computeMagnitudeOfNegativeVector() {
        Vector a = new Vector(-1.0f,-2.0f,-3.0f);
        Assertions.assertEquals((float)Math.sqrt(14),a.getMagnitude(), EPSILON);
    }
    @Test
    void magnitudeOfNormalizedVector() {
        Vector a = new Vector(1.0f,2.0f,3.0f);
        Vector norm = a.normalize();
        Assertions.assertEquals(1.0f, norm.getMagnitude(), EPSILON);
    }

    @Test
    void normalizeXVector() {
        Vector a = new Vector(4.0f,0.0f,0.0f);
        Vector norm = a.normalize();
        Assertions.assertEquals(new Vector(1.0f,0.0f,0.0f),norm);
    }

    @Test
    void normalizeVector() {
        Vector a = new Vector(1.0f,2.0f,3.0f);
        Assertions.assertEquals(new Vector((float)(1/Math.sqrt(14)),(float)(2/Math.sqrt(14)),(float)(3/Math.sqrt(14))),a.normalize());
    }

    @Test
    void dotProductOfTwoVectors() {
        Vector a = new Vector(1.0f,2.0f,3.0f);
        Vector b = new Vector(2.0f,3.0f,4.0f);
        Assertions.assertEquals(20, a.dotProduct(b));
    }

    @Test
    void crossProductOfTwoVectors() {
        Vector a = new Vector(1.0f,2.0f,3.0f);
        Vector b = new Vector(2.0f,3.0f,4.0f);
        Assertions.assertEquals(new Vector(-1,2,-1), a.crossProduct(b));
        Assertions.assertEquals(new Vector(1,-2,1), b.crossProduct(a));
    }
    @Test
    void addColors() {
        Color a = new Color(0.9f,0.6f,0.75f);
        Color b = new Color(0.7f,0.1f,0.25f);
        Assertions.assertEquals(new Color(1.6f,0.7f,1.0f), a.add(b));
    }
    @Test
    void subtractColors() {
        Color a = new Color(0.9f,0.6f,0.75f);
        Color b = new Color(0.7f,0.1f,0.25f);
        Assertions.assertEquals(new Color(0.2f,0.5f,0.5f), a.subtract(b));
    }
    @Test
    void multiplyColorByScalar() {
        Color a = new Color(0.2f,0.3f,0.4f);
        Assertions.assertEquals(new Color(0.4f,0.6f,0.8f), a.multiply(2));
    }

    @Test
    void multiplyTwoColors() {
        Color a = new Color(1.0f,0.2f,0.4f);
        Color b = new Color(0.9f,1.0f,0.1f);
        Assertions.assertEquals(new Color(0.9f,0.2f,0.04f), a.hadamardProduct(b));
    }

}