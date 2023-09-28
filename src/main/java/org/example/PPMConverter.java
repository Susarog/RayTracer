package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PPMConverter {

    private static float updateColorBounds(float colorValue) {
        if(colorValue >= 0.0f && colorValue <= 1.0f) {
            return colorValue;
        } else if (colorValue < 0.0f) {
            return 0.0f;
        } else {
            return 1.0f;
        }
    }
    public static String convertToPPM(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        String magicNumber ="P3\n";
        String dimensions = width + " " + height + "\n";
        String maxColorValue = "255\n";
        ArrayList<ArrayList<Color>> pixels = canvas.getCanvas();
        StringBuilder PPM = new StringBuilder();
        PPM.append(magicNumber).append(dimensions).append(maxColorValue);
        final int CHARACTER_LIMIT = 70;
        for (int i = 0; i < pixels.size(); i++) {
            int charCounter = 0;
            ArrayList<Color> row = pixels.get(i);
            int numCols = row.size();
            for (int j = 0; j < numCols; j++) {
                Color color = row.get(j);
                String r = String.valueOf(Math.round(updateColorBounds(color.getRed()) * 255));
                String g = String.valueOf(Math.round(updateColorBounds(color.getGreen()) * 255));
                String b = String.valueOf(Math.round(updateColorBounds(color.getBlue()) * 255));
                String[] colorTuple = new String[]{r, g, b};

                for (int k = 0; k < colorTuple.length; k++) {
                    String colorValue = colorTuple[k];
                    if (i == 0 && j == 0 && k == 0) {
                        charCounter += colorValue.length();
                    } else {
                        charCounter += colorValue.length() + 1;
                    }

                    if (charCounter > CHARACTER_LIMIT) {
                        charCounter = colorValue.length();
                        PPM.append("\n");
                    } else if(!(j == 0 && k == 0)){
                        colorValue = " " + colorValue;
                    }
                    PPM.append(colorValue);
                }
            }
            PPM.append("\n");
        }
        return PPM.append("\n").toString();
    }
}
