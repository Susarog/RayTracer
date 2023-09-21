package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TupleTest {
    @Test
    public void aTupleGivenOneIsAPoint() {
        Tuple pointTuple = new Tuple(4.3f, -4.2f, 3.1f, 1.0f);
        Assertions.assertEquals(4.3f, pointTuple.getX(), 0.0);
        Assertions.assertEquals(-4.2f, pointTuple.getY(), 0.0);
        Assertions.assertEquals(3.1f, pointTuple.getZ(), 0.0);
        Assertions.assertEquals(1.0f, pointTuple.getW(), 0.0);
        Assertions.assertTrue(pointTuple.isPoint());
    }
    @Test
    public void aTupleGivenOneIsAVector() {
        Tuple pointTuple = new Tuple(4.3f, -4.2f, 3.1f, 0.0f);
        Assertions.assertEquals(4.3f, pointTuple.getX(), 0.0);
        Assertions.assertEquals(-4.2f, pointTuple.getY(), 0.0);
        Assertions.assertEquals(3.1f, pointTuple.getZ(), 0.0);
        Assertions.assertEquals(0.0f, pointTuple.getW(), 0.0);
        Assertions.assertFalse(pointTuple.isPoint());
    }
    @Test
    public void pointCreatesTuples() {
        Tuple p = Tuple.point(4.0f,-4.0f,3.0f);
        Assertions.assertEquals(p, new Tuple(4.0f,-4.0f,3.0f, 1.0f));

    }
    @Test
    public void vectorCreatesTuples() {
        Tuple v = Tuple.vector(4.0f,-4.0f,3.0f);
        Assertions.assertEquals(v, new Tuple(4.0f,-4.0f,3.0f, 1.0f));
    }
    @Test
    void addPointAndVector() throws Tuple.TupleException {
        Tuple a = new Tuple(3.0f,-2.0f,5.0f,1.0f);
        Tuple b = new Tuple(-2.0f,3.0f,1.0f,0.0f);
        Assertions.assertEquals(a.add(b), new Tuple(1.0f,1.0f,6.0f, 1.0f));
    }
    @Test
    void addTwoPoints() {
        Tuple a = Tuple.point(3.0f,-2.0f,5.0f);
        Tuple b = Tuple.point(-2.0f,3.0f,1.0f);
        Assertions.assertThrows(Tuple.TupleException.class, () -> a.add(b));
    }
    @Test
    void addTwoVectors() throws Tuple.TupleException {
        Tuple a = Tuple.vector(3.0f,-2.0f,5.0f);
        Tuple b = Tuple.vector(-2.0f,3.0f,1.0f);
        Assertions.assertEquals(a.add(b), new Tuple(1.0f,1.0f,6.0f, 0.0f));
    }
    @Test
    void subtractTwoPoints() throws Tuple.TupleException {
        Tuple a = Tuple.point(3.0f,2.0f,1.0f);
        Tuple b = Tuple.point(5.0f,6.0f,7.0f);
        Assertions.assertEquals(a.subtract(b), Tuple.vector(-2.0f,-4.0f,-6.0f));
    }
    @Test
    void subtractTwoVectors() throws Tuple.TupleException {
        Tuple a = Tuple.vector(3.0f,2.0f,1.0f);
        Tuple b = Tuple.vector(5.0f,6.0f,7.0f);
        Assertions.assertEquals(a.subtract(b), Tuple.vector(-2.0f,-4.0f,-6.0f));
    }

    @Test
    void subtractVectorFromPoint() throws Tuple.TupleException {
        Tuple p = Tuple.point(3.0f,2.0f,1.0f);
        Tuple v = Tuple.vector(5.0f,6.0f,7.0f);
        Assertions.assertEquals(p.subtract(v), Tuple.vector(-2.0f,-4.0f,-6.0f));
    }
    @Test
    void subtractVectorFromZeroVector() throws Tuple.TupleException {
        Tuple v = Tuple.vector(1.0f,-2.0f,3.0f);
        Tuple zero = Tuple.vector(0.0f,0.0f,0.0f);
        Assertions.assertEquals(zero.subtract(v), Tuple.vector(-1.0f,2.0f,-3.0f));
    }

    @Test
    void negateTuple() {
        Tuple a = new Tuple(1.0f,-2.0f,3.0f, -4.0f);
        Tuple negativeA = a.negate();
        Assertions.assertEquals(negativeA, new Tuple(-1.0f,2.0f,-3.0f,4.0f));
    }
}