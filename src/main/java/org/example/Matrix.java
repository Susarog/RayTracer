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
            for (int j = 0; j < column; j++) {
                if (Math.abs(this.matrix[i][j] - otherMatrix.matrix[i][j]) > EPSILON) {
                    return false;
                }
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

    public Matrix multiply(Matrix other) {
        if(matrix[0].length != other.matrix.length) {
            //throw or smth
        }
        float val = 0;
        float[][] newMatrix = new float[matrix.length][other.matrix[0].length];
        for(int k = 0; k < newMatrix.length; k++) {
            float[] temp = new float[other.matrix[0].length];
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


    public Point multiply(Point p) {
        if(matrix[0].length != 4) {
            //throw or smth
        }
        float val = 0;
        float[] coords = new float[]{p.getX(), p.getY(), p.getZ(), p.getW()};
        float[] newPoint = new float[coords.length];
        for(int i = 0; i < matrix.length; i++) {
            float[] temp = matrix[i];
            for(int j = 0; j < coords.length; j++) {
                val += temp[j] * coords[j];
            }
            newPoint[i] = val;
            val = 0;
        }
        return new Point(newPoint);
    }

    public Vector multiply(Vector v) {
        if(matrix[0].length != 4) {
            //throw or smth
        }
        float val = 0;
        float[] coords = new float[]{v.getX(), v.getY(), v.getZ(), v.getW()};
        float[] newVector = new float[coords.length];
        for(int i = 0; i < matrix.length; i++) {
            float[] temp = matrix[i];
            for(int j = 0; j < coords.length; j++) {
                val += temp[j] * coords[j];
            }
            newVector[i] = val;
            val = 0;
        }
        return new Vector(newVector);
    }

    public Matrix transpose() {
        float[][] transposedMatrix = new float[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            transposedMatrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        for(int i = 0; i < transposedMatrix.length; i++) {
            for(int j = i; j < transposedMatrix[0].length; j++) {
                float tmp = transposedMatrix[i][j];
                transposedMatrix[i][j] = transposedMatrix[j][i];
                transposedMatrix[j][i] = tmp;
            }
        }
        return new Matrix(transposedMatrix);
    }

    public float getDeterminant() {
        if (matrix.length ==2 && matrix[0].length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        float determinant = 0;
        for (int i = 0; i < matrix.length; i++) {
            determinant += matrix[0][i]* cofactor(0,i);
        }
        return determinant;
    }

    public Matrix subMatrix(int row, int column) {
        float[][] newMatrix = new float[matrix.length - 1][matrix[0].length - 1];
        int rowIdx = 0;
        int colIdx = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (row != i) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (column != j) {
                        newMatrix[rowIdx][colIdx++] = matrix[i][j];
                    }
                }
                colIdx = 0;
                rowIdx++;
            }
        }
        return new Matrix(newMatrix);
    }

    public float minor(int row, int column) {
        Matrix newMatrix = subMatrix(row,column);
        return newMatrix.getDeterminant();
    }

    public float cofactor(int row, int column) {
        float minorVal = minor(row,column);
        return (row + column) % 2 == 1 ? -(minorVal) : minorVal;
    }

    public boolean isInvertible() {
        return getDeterminant() != 0;
    }

    public Matrix inverse() {
        if(!(isInvertible())) {
            //throw
        }
        float[][] newMatrix = new float[matrix.length][matrix[0].length];
        float determinant = getDeterminant();
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                float cofactor = this.cofactor(i,j);
                // transposing by switching rows and columns
                newMatrix[j][i] = (float) cofactor / determinant;
            }
        }
        return new Matrix(newMatrix);
    }

    private float[][] matrix;
    private int row;
    private int column;
    private final static double EPSILON = 0.00001;

}
