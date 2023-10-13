package org.example;

public class Main {
    public static void main(String[] args) {
        float[] row1 = new float[]{1f,0f,0f,0f};
        float[] row2 = new float[]{0f,1f,0f,0f};
        float[] row3 = new float[]{0f,0f,1f,0f};
        float[] row4 = new float[]{0f,0f,0f,1f};
        float[][] a = new float[][]{row1,row2,row3,row4};
        Matrix identityMatrix = new Matrix(a);

        Matrix invertedIdentityMatrix = identityMatrix.inverse();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < invertedIdentityMatrix.getRowLength(); i++) {
            for(int j = 0; j < invertedIdentityMatrix.getColumnLength(); j++) {
                str.append(invertedIdentityMatrix.get(i,j) + " ");
            }
            str.append('\n');
        }
        System.out.println(str);

    }
}