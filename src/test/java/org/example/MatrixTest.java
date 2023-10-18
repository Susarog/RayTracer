package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void constructMatrix4() {
        float[] row1 = new float[]{1.0f,2.0f,3.0f,4.0f};
        float[] row2 = new float[]{5.5f,6.5f,7.5f,8.5f};
        float[] row3 = new float[]{9f,10f,11f,12f};
        float[] row4 = new float[]{13.5f,14.5f,15.5f,16.5f};
        float[][] matrix4 = new float[][]{row1,row2,row3,row4};
        Matrix m = new Matrix(matrix4);

        Assertions.assertEquals(1f, m.get(0,0));
        Assertions.assertEquals(4f, m.get(0,3));
        Assertions.assertEquals(5.5f, m.get(1,0));
        Assertions.assertEquals(7.5, m.get(1,2));
        Assertions.assertEquals(11,m.get(2,2));
        Assertions.assertEquals(13.5, m.get(3,0));
        Assertions.assertEquals(15.5, m.get(3,2));
    }
    @Test
    void constructMatrix2() {
        float[] row1 = new float[]{-3f,5f};
        float[] row2 = new float[]{1f,-2f};
        float[][] matrix2 = new float[][]{row1,row2};
        Matrix m = new Matrix(matrix2);

        Assertions.assertEquals(-3f, m.get(0,0));
        Assertions.assertEquals(5f, m.get(0,1));
        Assertions.assertEquals(1f, m.get(1,0));
        Assertions.assertEquals(-2f, m.get(1,1));
    }
    @Test
    void constructMatrix3() {
        float[] row1 = new float[]{-3f,5f,0f};
        float[] row2 = new float[]{1f,-2f,-7f};
        float[] row3 = new float[]{0f,1f,1f};
        float[][] matrix3 = new float[][]{row1,row2,row3};
        Matrix m = new Matrix(matrix3);

        Assertions.assertEquals(-3f, m.get(0,0));
        Assertions.assertEquals(-2f, m.get(1,1));
        Assertions.assertEquals(1f, m.get(2,2));
    }
    @Test
    void matrixEquality() {
        float[] row1 = new float[]{1.0f,2.0f,3.0f,4.0f};
        float[] row2 = new float[]{5.5f,6.5f,7.5f,8.5f};
        float[] row3 = new float[]{9f,10f,11f,12f};
        float[] row4 = new float[]{13.5f,14.5f,15.5f,16.5f};
        float[][] matrix4 = new float[][]{row1,row2,row3,row4};
        Matrix a = new Matrix(matrix4);
        Matrix b = new Matrix(matrix4);

        Assertions.assertEquals(a,b);
    }
    @Test
    void matrixInequality() {
        float[] row1 = new float[]{1.0f,2.0f,3.0f,4.0f};
        float[] row2 = new float[]{5.5f,6.5f,7.5f,8.5f};
        float[] row3 = new float[]{9f,10f,11f,12f};
        float[] row4 = new float[]{13.5f,14.5f,15.5f,16.5f};
        float[][] a = new float[][]{row1,row2,row3,row4};

        float[] row5 = new float[]{2f,3f,4f,5f};
        float[] row6 = new float[]{6f,7f,8f,9f};
        float[] row7 = new float[]{8f,7f,6f,5f};
        float[] row8 = new float[]{4f,3f,2f,1f};
        float[][] b = new float[][]{row5,row6,row7,row8};

        Matrix a4 = new Matrix(a);
        Matrix b4 = new Matrix(b);

        Assertions.assertNotEquals(a4,b4);
    }

    @Test
    void matrixMultiply() {
        float[] row1 = new float[]{1f,2f,3f,4f};
        float[] row2 = new float[]{5f,6f,7f,8f};
        float[] row3 = new float[]{9f,8f,7f,6f};
        float[] row4 = new float[]{5f,4f,3f,2f};
        float[][] a = new float[][]{row1,row2,row3,row4};

        float[] row5 = new float[]{-2f,1f,2f,3f};
        float[] row6 = new float[]{3f,2f,1f,-1f};
        float[] row7 = new float[]{4f,3f,6f,5f};
        float[] row8 = new float[]{1f,2f,7f,8f};
        float[][] b = new float[][]{row5,row6,row7,row8};

        float[] row9 = new float[]{20f,22f,50f,48f};
        float[] row10 = new float[]{44f,54f,114f,108f};
        float[] row11 = new float[]{40f,58f,110f,102f};
        float[] row12 = new float[]{16f,26f,46f,42f};
        float[][] c = new float[][]{row9,row10,row11,row12};

        Matrix a4 = new Matrix(a);
        Matrix b4 = new Matrix(b);

        Matrix c4 = a4.multiply(b4);
        assertEquals(new Matrix(c), c4);
    }
    @Test
    void matrixMultiplyByPoint() {
        float[] row1 = new float[]{1f,2f,3f,4f};
        float[] row2 = new float[]{2f,4f,4f,2f};
        float[] row3 = new float[]{8f,6f,4f,1f};
        float[] row4 = new float[]{0f,0f,0f,1f};
        float[][] a = new float[][]{row1,row2,row3,row4};
        Matrix a4 = new Matrix(a);
        Point b = new Point(1,2,3);

        assertEquals(new Point(18f,24f,33f), a4.multiply(b));
    }

    @Test
    void matrixMultiplyByVector() {
        float[] row1 = new float[]{1f,2f,3f,4f};
        float[] row2 = new float[]{2f,4f,4f,2f};
        float[] row3 = new float[]{8f,6f,4f,1f};
        float[] row4 = new float[]{0f,0f,0f,1f};
        float[][] a = new float[][]{row1,row2,row3,row4};
        Matrix a4 = new Matrix(a);
        Vector b = new Vector(1,2,3);

        assertEquals(new Vector(14f,22f,32f), a4.multiply(b));
    }
    @Test
    void matrixMultiplyByIdentityMatrix() {
        float[] row1 = new float[]{1f,2f,3f,4f};
        float[] row2 = new float[]{2f,4f,4f,2f};
        float[] row3 = new float[]{8f,6f,4f,1f};
        float[] row4 = new float[]{0f,0f,0f,1f};
        float[][] a = new float[][]{row1,row2,row3,row4};
        Matrix a4 = new Matrix(a);

        float[] row5 = new float[]{1f,0f,0f,0f};
        float[] row6 = new float[]{0f,1f,0f,0f};
        float[] row7 = new float[]{0f,0f,1f,0f};
        float[] row8 = new float[]{0f,0f,0f,1f};
        float[][] b = new float[][]{row5,row6,row7,row8};
        Matrix identityMatrix = new Matrix(b);

        assertEquals(a4, a4.multiply(identityMatrix));
    }
    @Test
    void transposingMatrix() {
        float[] row1 = new float[]{0f,9f,3f,0f};
        float[] row2 = new float[]{9f,8f,0f,8f};
        float[] row3 = new float[]{1f,8f,5f,3f};
        float[] row4 = new float[]{0f,0f,5f,8f};
        float[][] a = new float[][]{row1,row2,row3,row4};
        Matrix a4 = new Matrix(a);

        float[] row5 = new float[]{0f,9f,1f,0f};
        float[] row6 = new float[]{9f,8f,8f,0f};
        float[] row7 = new float[]{3f,0f,5f,5f};
        float[] row8 = new float[]{0f,8f,3f,8f};
        float[][] b = new float[][]{row5,row6,row7,row8};
        Matrix transposedMatrix = new Matrix(b);

        assertEquals(transposedMatrix, a4.transpose());
    }

    @Test
    void getDeterminant() {
        float[] row1 = new float[]{1f,5f};
        float[] row2 = new float[]{-3f,2f};
        float[][] a = new float[][]{row1,row2};
        Matrix a2 = new Matrix(a);
        assertEquals(17, a2.getDeterminant());
    }
    @Test
    void matrix4ToMatrix3() {
        float[] row1 = new float[]{-6f,1f,1f,6f};
        float[] row2 = new float[]{-8f,5f,8f,6f};
        float[] row3 = new float[]{-1f,0f,8f,2f};
        float[] row4 = new float[]{-7f,1f,-1f,1f};
        float[][] a = new float[][]{row1,row2,row3,row4};
        Matrix a4 = new Matrix(a);

        float[] row5 = new float[]{-6f,1f,6f};
        float[] row6 = new float[]{-8f,8f,6f};
        float[] row7 = new float[]{-7f,-1f,1f};
        float[][] b = new float[][]{row5,row6,row7};
        Matrix expectedMatrix = new Matrix(b);

        assertEquals(expectedMatrix, a4.subMatrix(2,1));
    }
    @Test
    void matrix3ToMatrix2() {
        float[] row1 = new float[]{1f,5f,0f};
        float[] row2 = new float[]{-3f,2f,7f};
        float[] row3 = new float[]{0f,6f,-3f};
        float[][] a = new float[][]{row1,row2,row3};
        Matrix a3 = new Matrix(a);

        float[] row4 = new float[]{-3f,2f};
        float[] row5 = new float[]{0f,6f};
        float[][] b = new float[][]{row4,row5};
        Matrix expectedMatrix = new Matrix(b);
        assertEquals(expectedMatrix, a3.subMatrix(0,2));
    }

    @Test
    void calculateMinor() {
        float[] row1 = new float[]{3f,5f,0f};
        float[] row2 = new float[]{2f,-1f,-7f};
        float[] row3 = new float[]{6f,-1f,5f};
        float[][] a = new float[][]{row1,row2,row3};
        Matrix a3 = new Matrix(a);

        assertEquals(25, a3.minor(1,0));
    }

    @Test
    void calculateCofactor() {
        float[] row1 = new float[]{3f,5f,0f};
        float[] row2 = new float[]{2f,-1f,-7f};
        float[] row3 = new float[]{6f,-1f,5f};
        float[][] a = new float[][]{row1,row2,row3};
        Matrix a3 = new Matrix(a);

        assertEquals(-12, a3.minor(0,0));
        assertEquals(-12, a3.cofactor(0,0));
        assertEquals(25, a3.minor(1,0));
        assertEquals(-25, a3.cofactor(1,0));
    }

    @Test
    void calculateMatrix3Determinant() {
        float[] row1 = new float[]{1f,2f,6f};
        float[] row2 = new float[]{-5f,8f,-4f};
        float[] row3 = new float[]{2f,6f,4f};
        float[][] a = new float[][]{row1,row2,row3};
        Matrix a3 = new Matrix(a);
        assertEquals(56, a3.cofactor(0,0));
        assertEquals(12, a3.cofactor(0,1));
        assertEquals(-46, a3.cofactor(0,2));
        assertEquals(-196, a3.getDeterminant());
    }
    @Test
    void calculateMatrix4Determinant() {
        float[] row1 = new float[]{-2f,-8f,3f,5f};
        float[] row2 = new float[]{-3f,1f,7f,3f};
        float[] row3 = new float[]{1f,2f,-9f,6f};
        float[] row4 = new float[]{-6f,7f,7f,-9f};
        float[][] a = new float[][]{row1,row2,row3,row4};
        Matrix a4 = new Matrix(a);
        assertEquals(690, a4.cofactor(0,0));
        assertEquals(447, a4.cofactor(0,1));
        assertEquals(210, a4.cofactor(0,2));
        assertEquals(51, a4.cofactor(0,3));
        assertEquals(-4071, a4.getDeterminant());
    }

    @Test
    void matrixIsInvertible() {
        float[] row1 = new float[]{6f,4f,4f,4f};
        float[] row2 = new float[]{5f,5f,7f,6f};
        float[] row3 = new float[]{4f,-9f,3f,-7f};
        float[] row4 = new float[]{9f,1f,7f,-6f};
        float[][] a = new float[][]{row1,row2,row3,row4};
        Matrix a4 = new Matrix(a);
        assertEquals(-2120f, a4.getDeterminant());
        assertTrue(a4.isInvertible());
    }
    @Test
    void matrixIsNotInvertible() {
        float[] row1 = new float[]{-4f,2f,-2f,-3f};
        float[] row2 = new float[]{9f,6f,2f,6f};
        float[] row3 = new float[]{0f,-5f,1f,-5f};
        float[] row4 = new float[]{0f,0f,0f,0f};
        float[][] a = new float[][]{row1,row2,row3,row4};
        Matrix a4 = new Matrix(a);
        assertEquals(0, a4.getDeterminant());
        assertFalse(a4.isInvertible());
    }

    @Test
    void inverseMatrix() {
        float[] row1 = new float[]{-5f,2f,6f,-8f};
        float[] row2 = new float[]{1f,-5f,1f,8f};
        float[] row3 = new float[]{7f,7f,-6f,-7f};
        float[] row4 = new float[]{1f,-3f,7f,4f};
        float[][] a = new float[][]{row1,row2,row3,row4};
        Matrix a4 = new Matrix(a);
        Matrix b4 = a4.inverse();
        assertEquals(532, a4.getDeterminant());
        assertEquals(-160, a4.cofactor(2,3));
        assertEquals((float)-160/532, b4.get(3,2));
        assertEquals(105, a4.cofactor(3,2));
        assertEquals((float)105/532, b4.get(2,3));
        float[] row5 = new float[]{0.21805f,0.45113f,0.24060f,-0.04511f};
        float[] row6 = new float[]{-0.80827f,-1.45677f,-0.44361f,0.52068f};
        float[] row7 = new float[]{-0.07895f,-0.22368f,-0.05263f,0.19737f};
        float[] row8 = new float[]{-0.52256f,-0.81391f,-0.30075f,0.30639f};
        float[][] b = new float[][]{row5,row6,row7,row8};
        Matrix inversedMatrix = new Matrix(b);

        assertEquals(inversedMatrix, b4);
    }
    @Test
    void inverseSecondMatrix() {
        float[] row1 = new float[]{8f, -5f, 9f, 2f};
        float[] row2 = new float[]{7f, 5f, 6f, 1f };
        float[] row3 = new float[]{-6f, 0f, 9f, 6f};
        float[] row4 = new float[]{-3f, 0f, -9f, -4f};
        float[][] a = new float[][]{row1,row2,row3,row4};
        Matrix a4 = new Matrix(a);
        Matrix inverseA4 = a4.inverse();
        float[] row5 = new float[]{-0.15385f, -0.15385f, -0.28205f, -0.53846f};
        float[] row6 = new float[]{-0.07692f, 0.12308f, 0.02564f, 0.03077f};
        float[] row7 = new float[]{0.35897f, 0.35897f, 0.43590f, 0.92308f };
        float[] row8 = new float[]{-0.69231f, -0.69231f, -0.76923f, -1.92308f};
        float[][] b = new float[][]{row5,row6,row7,row8};
        Matrix inversedMatrix = new Matrix(b);

        assertEquals(inversedMatrix, inverseA4);
    }
    @Test
    void inverseThirdMatrix() {
        float[] row1 = new float[]{9f, 3f, 0f, 9f};
        float[] row2 = new float[]{-5f, -2f, -6f, -3f};
        float[] row3 = new float[]{-4f,9f,6f,4f};
        float[] row4 = new float[]{ -7f,6f,6f, 2f};
        float[][] a = new float[][]{row1,row2,row3,row4};
        Matrix a4 = new Matrix(a);
        Matrix inverseA4 = a4.inverse();
        float[] row5 = new float[]{-0.04074f, -0.07778f, 0.14444f, -0.22222f};
        float[] row6 = new float[]{-0.07778f, 0.03333f, 0.36667f, -0.33333f};
        float[] row7 = new float[]{ -0.02901f, -0.14630f,-0.10926f, 0.12963f};
        float[] row8 = new float[]{0.17778f, 0.06667f, -0.26667f, 0.33333f};
        float[][] b = new float[][]{row5,row6,row7,row8};
        Matrix inversedMatrix = new Matrix(b);

        assertEquals(inversedMatrix, inverseA4);
    }
    @Test
    void multiplyProductByInverse() {
        float[] row1 = new float[]{3f,-9f,7f,3f};
        float[] row2 = new float[]{3f,-8f,2f,-9f};
        float[] row3 = new float[]{-4f,4f,4f,1f};
        float[] row4 = new float[]{-6f,5f,-1f,1f};
        float[][] a = new float[][]{row1,row2,row3,row4};
        Matrix a4 = new Matrix(a);
        float[] row5 = new float[]{8f,2f,2f,2f};
        float[] row6 = new float[]{3f,-1f,7f,0f};
        float[] row7 = new float[]{7f,0f,5f,4f};
        float[] row8 = new float[]{6f,-2f,0f,5f};
        float[][] b = new float[][]{row5,row6,row7,row8};
        Matrix b4 = new Matrix(b);
        Matrix c4 = a4.multiply(b4);

        assertEquals(a4, c4.multiply(b4.inverse()));
    }

    @Test
    void multiplyInverseTranslationMatrix() {
        Matrix transform = Matrix.translation(5f,-3f,2f);
        Matrix inv = transform.inverse();
        Point p = new Point(-3f,4f,5f);
        assertEquals(new Point(-8f,7f,3f),inv.multiply(p));
    }
    @Test
    void multiplyTranslationMatrix() {
        Matrix transform = Matrix.translation(5f,-3f,2f);
        Point p = new Point(-3f,4f,5f);
        assertEquals(new Point(2f,1f,7f),transform.multiply(p));
    }
    @Test
    void multiplyTranslationMatrixDoesntAffectVector() {
        Matrix transform = Matrix.translation(5f,-3f,2f);
        Vector v = new Vector(-3f,4f,5f);
        assertEquals(new Vector(-3f,4f,5f),transform.multiply(v));
    }
    @Test
    void multiplyScaledMatrixByPoint() {
        Matrix transform = Matrix.scaling(2f,3f,4f);
        Point v = new Point(-4f,6f,8f);
        assertEquals(new Point(-8f,18f,32f),transform.multiply(v));
    }
    @Test
    void multiplyScaledMatrixByVec() {
        Matrix transform = Matrix.scaling(2f,3f,4f);
        Vector v = new Vector(-4f,6f,8f);
        assertEquals(new Vector(-8f,18f,32f),transform.multiply(v));
    }

    @Test
    void multiplyInverseScaledMatrixByVec() {
        Matrix transform = Matrix.scaling(2f,3f,4f);
        Matrix inv = transform.inverse();
        Vector v = new Vector(-4f,6f,8f);
        assertEquals(new Vector(-2f,2f,2f),inv.multiply(v));
    }
    @Test
    void multiplyReflectedScaledMatrix() {
        Matrix transform = Matrix.scaling(-1f,1f,1f);
        Point v = new Point(2f,3f,4f);
        assertEquals(new Point(-2f,3f,4f),transform.multiply(v));
    }
    @Test
    void multiplyXRotatedMatrix() {
        Matrix halfQuarter = Matrix.xRotation((float) Math.toRadians(45));
        Matrix fullQuarter = Matrix.xRotation((float) Math.toRadians(90));
        Point p = new Point(0f,1f,0f);
        assertEquals(new Point(0f, (float) (Math.sqrt(2)/2), (float) (Math.sqrt(2)/2)),halfQuarter.multiply(p));
        assertEquals(new Point(0f, 0f, 1f),fullQuarter.multiply(p));
    }
    @Test
    void multiplyInverseXRotatedMatrix() {
        Matrix inversedHalfQuarter = Matrix.xRotation((float) Math.toRadians(45)).inverse();
        Point p = new Point(0f,1f,0f);
        assertEquals(new Point(0f, (float) (Math.sqrt(2)/2), (float) -(Math.sqrt(2)/2)),inversedHalfQuarter.multiply(p));
    }

    @Test
    void multiplyYRotatedMatrix() {
        Matrix halfQuarter = Matrix.yRotation((float) Math.toRadians(45));
        Matrix fullQuarter = Matrix.yRotation((float) Math.toRadians(90));
        Point p = new Point(0f,0f,1f);
        assertEquals(new Point((float) (Math.sqrt(2)/2), 0f, (float) (Math.sqrt(2)/2)),halfQuarter.multiply(p));
        assertEquals(new Point(1f, 0f, 0f),fullQuarter.multiply(p));
    }
    @Test
    void multiplyZRotatedMatrix() {
        Matrix halfQuarter = Matrix.zRotation((float) Math.toRadians(45));
        Matrix fullQuarter = Matrix.zRotation((float) Math.toRadians(90));
        Point p = new Point(0f,1f,0f);
        assertEquals(new Point((float) -(Math.sqrt(2)/2), (float) (Math.sqrt(2)/2),0f),halfQuarter.multiply(p));
        assertEquals(new Point(-1f, 0f, 0f),fullQuarter.multiply(p));
    }
    @Test
    void multiplyShearingMatrix() {
        Matrix transform = Matrix.shearing(1,0,0,0,0,0);
        Point p = new Point(2f,3f,4f);
        assertEquals(new Point(5f,3f,4f),transform.multiply(p));
        transform = Matrix.shearing(0,1,0,0,0,0);
        assertEquals(new Point(6f,3f,4f),transform.multiply(p));
        transform = Matrix.shearing(0,0,1,0,0,0);
        assertEquals(new Point(2f,5f,4f),transform.multiply(p));
        transform = Matrix.shearing(0,0,0,1,0,0);
        assertEquals(new Point(2f,7f,4f),transform.multiply(p));
        transform = Matrix.shearing(0,0,0,0,1,0);
        assertEquals(new Point(2f,3f,6f),transform.multiply(p));
        transform = Matrix.shearing(0,0,0,0,0,1);
        assertEquals(new Point(2f,3f,7f),transform.multiply(p));
    }
    @Test
    void individualTransformationMethods() {
        Point p = new Point(1f,0f,1f);
        Matrix a = Matrix.xRotation((float) Math.toRadians(90));
        Matrix b = Matrix.scaling(5f,5f,5f);
        Matrix c = Matrix.translation(10f,5f,7f);
        Point p2 = a.multiply(p);
        Point p3 = b.multiply(p2);
        Point p4 = c.multiply(p3);
        assertEquals(new Point(15f,0f,7f),p4);
    }
    @Test
    void chainTransformationMethods() {
        Point p = new Point(1f,0f,1f);
        Matrix a = Matrix.xRotation((float) Math.toRadians(90));
        Matrix b = Matrix.scaling(5f,5f,5f);
        Matrix c = Matrix.translation(10f,5f,7f);
        Matrix t = c.multiply(b.multiply(a));
        Point p2 = t.multiply(p);
        assertEquals(new Point(15f,0f,7f),p2);
    }

}