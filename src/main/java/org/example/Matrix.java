package org.example;

import java.util.Arrays;

public class Matrix {
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Matrix otherMatrix = (Matrix) obj;

        if (this.row != otherMatrix.row || column != otherMatrix.column) {
            return false;
        }

        for (int i = 0; i < row; i++) {
            if (!Arrays.equals(matrix[i], otherMatrix.matrix[i])) {
                return false;
            }
        }

        return true;
    }

    public Matrix(float[][] matrix) {
        row = matrix.length;
        column = matrix[0].length;
        this.matrix = matrix;
    }

    public float get(int row,int col) {
        return matrix[row][col];
    }

    /*
     * this's row and other's col
     * have to ensure they have the same length for respective column and row
     *
     *
     */

    public Matrix multiply(Matrix other) {
        if(matrix[0].length != other.matrix.length) {
            //throw or smth
        }
        float val = 0;
        float[][] newMatrix = new float[matrix.length][other.matrix[0].length];
        for(int k = 0; k < newMatrix.length; k++) {
            float[] temp = new float[other.matrix[0].length];
            //TODO fix matrix multiplication shit
            for(int i = 0; i < temp.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    val += matrix[k][j] * other.matrix[j][i];
                }
                temp[i] = val;
                val = 0;
            }
            newMatrix[k] = temp;
        }
        return new Matrix(newMatrix);
    }

    private float[][] matrix;
    private int row;
    private int column;
}
