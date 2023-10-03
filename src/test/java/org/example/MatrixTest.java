package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
}