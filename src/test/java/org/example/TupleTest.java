package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TupleTest {
    private final static double EPSILON = 0.00001;
    @Test
    public void aTupleGivenOneIsAPoint() {
        Tuple pointTuple = new Tuple(4.3f, -4.2f, 3.1f, 1.0f);
        Assertions.assertEquals(pointTuple.getX(), 4.3f);
        Assertions.assertEquals(pointTuple.getY(), -4.2f);
        Assertions.assertEquals(pointTuple.getZ(), 3.1f);
        Assertions.assertEquals(pointTuple.getW(), 1.0f);
        Assertions.assertTrue(pointTuple.isPoint());
    }
    @Test
    public void aTupleGivenOneIsAVector() {
        Tuple pointTuple = new Tuple(4.3f, -4.2f, 3.1f, 0.0f);
        Assertions.assertEquals(pointTuple.getX(), 4.3f);
        Assertions.assertEquals(pointTuple.getY(), -4.2f);
        Assertions.assertEquals(pointTuple.getZ(), 3.1f);
        Assertions.assertEquals(pointTuple.getW(), 0.0f);
        Assertions.assertFalse(pointTuple.isPoint());
    }
    @Test
    public void pointCreatesTuples() {
        Tuple p = Tuple.point(4.0f,-4.0f,3.0f);
        Assertions.assertEquals(new Tuple(4.0f,-4.0f,3.0f, 1.0f), p);

    }
    @Test
    public void vectorCreatesTuples() {
        Tuple v = Tuple.vector(4.0f,-4.0f,3.0f);
        Assertions.assertEquals(new Tuple(4.0f,-4.0f,3.0f, 1.0f), v);
    }
    @Test
    void addPointAndVector() {
        Tuple a = new Tuple(3.0f,-2.0f,5.0f,1.0f);
        Tuple b = new Tuple(-2.0f,3.0f,1.0f,0.0f);
        Assertions.assertEquals(new Tuple(1.0f,1.0f,6.0f, 1.0f), a.add(b));
    }
    @Test
    void addTwoVectors() {
        Tuple a = Tuple.vector(3.0f,-2.0f,5.0f);
        Tuple b = Tuple.vector(-2.0f,3.0f,1.0f);
        Assertions.assertEquals(new Tuple(1.0f,1.0f,6.0f, 0.0f), a.add(b));
    }
    @Test
    void subtractTwoPoints() {
        Tuple a = Tuple.point(3.0f,2.0f,1.0f);
        Tuple b = Tuple.point(5.0f,6.0f,7.0f);
        Assertions.assertEquals(Tuple.vector(-2.0f,-4.0f,-6.0f), a.subtract(b));
    }
    @Test
    void subtractTwoVectors() {
        Tuple a = Tuple.vector(3.0f,2.0f,1.0f);
        Tuple b = Tuple.vector(5.0f,6.0f,7.0f);
        Assertions.assertEquals(Tuple.vector(-2.0f,-4.0f,-6.0f), a.subtract(b));
    }

    @Test
    void subtractVectorFromPoint() {
        Tuple p = Tuple.point(3.0f,2.0f,1.0f);
        Tuple v = Tuple.vector(5.0f,6.0f,7.0f);
        Assertions.assertEquals(Tuple.vector(-2.0f,-4.0f,-6.0f), p.subtract(v));
    }
    @Test
    void subtractVectorFromZeroVector() {
        Tuple v = Tuple.vector(1.0f,-2.0f,3.0f);
        Tuple zero = Tuple.vector(0.0f,0.0f,0.0f);
        Assertions.assertEquals(Tuple.vector(-1.0f,2.0f,-3.0f), zero.subtract(v));
    }

    @Test
    void negateTuple() {
        Tuple a = new Tuple(1.0f,-2.0f,3.0f, -4.0f);
        Tuple negativeA = a.negate();
        Assertions.assertEquals(new Tuple(-1.0f,2.0f,-3.0f,4.0f), negativeA);
    }

    @Test
    void multiplyTupleByScalar() {
        Tuple a = new Tuple(1.0f,-2.0f,3.0f, -4.0f);
        Assertions.assertEquals(new Tuple(3.5f,-7,10.5f,-14.0f), a.multiply(3.5f));
    }
    @Test
    void multiplyTupleByFraction() {
        Tuple a = new Tuple(1.0f,-2.0f,3.0f, -4.0f);
        Assertions.assertEquals(new Tuple(0.5f,-1,1.5f,2.0f), a.multiply(0.5f));
    }
    @Test
    void divideTupleByScalar() {
        Tuple a = new Tuple(1.0f,-2.0f,3.0f, -4.0f);
        Assertions.assertEquals(new Tuple(0.5f,-1,1.5f,2.0f), a.divide(2));
    }
    @Test
    void computeMagnitudeOfXVector() {
        Tuple a = Tuple.vector(1.0f,0.0f,0.0f);
        Assertions.assertEquals(1,a.getMagnitude());
    }
    @Test
    void computeMagnitudeOfYVector() {
        Tuple a = Tuple.vector(0.0f,1.0f,0.0f);
        Assertions.assertEquals(1,a.getMagnitude());
    }
    @Test
    void computeMagnitudeOfZVector() {
        Tuple a = Tuple.vector(0.0f,0.0f,1.0f);
        Assertions.assertEquals(1,a.getMagnitude(), EPSILON);
    }
    @Test
    void computeMagnitudeOfVector() {
        Tuple a = Tuple.vector(1.0f,2.0f,3.0f);
        Assertions.assertEquals((float)Math.sqrt(14),a.getMagnitude(), EPSILON);
    }
    @Test
    void computeMagnitudeOfNegativeVector() {
        Tuple a = Tuple.vector(-1.0f,-2.0f,-3.0f);
        Assertions.assertEquals((float)Math.sqrt(14),a.getMagnitude(), EPSILON);
    }
    @Test
    void magnitudeOfNormalizedVector() {
        Tuple a = Tuple.vector(1.0f,2.0f,3.0f);
        Tuple norm = a.normalize();
        Assertions.assertEquals(1.0f, norm.getMagnitude(), EPSILON);
    }

    @Test
    void normalizeXVector() {
        Tuple a = Tuple.vector(4.0f,0.0f,0.0f);
        Assertions.assertEquals(Tuple.vector(1.0f,0.0f,0.0f),a.normalize());
    }

    @Test
    void normalizeVector() {
        Tuple a = Tuple.vector(1.0f,2.0f,3.0f);
        Assertions.assertEquals(Tuple.vector((float)(1/Math.sqrt(14)),(float)(2/Math.sqrt(14)),(float)(3/Math.sqrt(14))),a.normalize());
    }

    @Test
    void dotProductOfTwoVectors() {
        Tuple a = Tuple.vector(1.0f,2.0f,3.0f);
        Tuple b = Tuple.vector(2.0f,3.0f,4.0f);
        Assertions.assertEquals(20, a.dotProduct(b));
    }

    @Test
    void crossProductOfTwoVectors() {
        Tuple a = Tuple.vector(1.0f,2.0f,3.0f);
        Tuple b = Tuple.vector(2.0f,3.0f,4.0f);
        Assertions.assertEquals(Tuple.vector(-1,2,-1), a.crossProduct(b));
        Assertions.assertEquals(Tuple.vector(1,-2,1), b.crossProduct(a));
    }
}