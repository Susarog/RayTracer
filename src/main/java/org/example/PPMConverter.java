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
        int charCounter = 0;
        for (ArrayList<Color> row : pixels) {
            int numCols = row.size();
            for (int j = 0; j < numCols; j++) {
                Color color = row.get(j);
                int r = Math.round(updateColorBounds(color.getRed()) * 255);
                int g = Math.round(updateColorBounds(color.getGreen()) * 255);
                int b = Math.round(updateColorBounds(color.getBlue()) * 255);
                String colorValue = r + " " + g + " " + b;
                /*
                charCounter += colorValue.length();
                if(charCounter > CHARACTER_LIMIT) {
                    charCounter = colorValue.length();
                    PPM.append("\n");
                }
                 */
                PPM.append(colorValue);
                if (j < numCols - 1) {
                    PPM.append(" ");
                }
            }
            PPM.append("\n");
        }
        return PPM.toString();
    }
}
