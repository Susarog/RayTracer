package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class CanvasTest {
    @Test
    void createCanvas() {
        int width = 10;
        int height = 20;
        ArrayList<ArrayList<Color>> canvasArray = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ArrayList<Color> innerList = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                innerList.add(new Color(0.0f,0.0f,0.0f)); // You can add any values you want here
            }
            canvasArray.add(innerList);
        }
        Canvas c = new Canvas(width, height);
        Assertions.assertEquals(width, c.getWidth());
        Assertions.assertEquals(height, c.getHeight());
        Assertions.assertEquals(canvasArray, c.getCanvas());
    }
    @Test
    void writeCanvas() {
        Canvas c = new Canvas(10, 20);
        Color red = new Color(1,0,0);
        c.writePixel(2,3,red);
        Assertions.assertEquals(red, c.getPixel(2,3));
    }
    @Test
    void constructingPPMHeader() {
        Canvas c = new Canvas(5, 3);
        String ppm = PPMConverter.convertToPPM(c);
        String pixelData = """
                0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
                0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
                0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
                """;

        Assertions.assertEquals("P3\n5 3\n255\n" + pixelData + "\n", ppm);
    }
    @Test
    void constructingPPMPixelData() {
        Canvas c = new Canvas(5, 3);
        Color c1 = new Color(1.5f,0,0);
        Color c2 = new Color(0f,0.5f,0);
        Color c3 = new Color(-0.5f,0,1.0f);
        c.writePixel(0,0,c1);
        c.writePixel(2,1,c2);
        c.writePixel(4,2,c3);
        String ppm = PPMConverter.convertToPPM(c);
        String pixelData = """
                            255 0 0 0 0 0 0 0 0 0 0 0 0 0 0
                            0 0 0 0 0 0 0 128 0 0 0 0 0 0 0
                            0 0 0 0 0 0 0 0 0 0 0 0 0 0 255
                            """;
        Assertions.assertEquals("P3\n5 3\n255\n" + pixelData + "\n", ppm);
    }
    @Test
    void SplitLongLinesInPPMFile() {
        Canvas c = new Canvas(10, 2);
        Color c1 = new Color(1.0f,0.8f,0.6f);
        ArrayList<ArrayList<Color>> pixels = c.getCanvas();
        for (int column = 0; column < pixels.size(); column++) {
            for (int row = 0; row < pixels.get(column).size(); row++) {
                c.writePixel(row,column,c1);
            }
        }
        String ppm = PPMConverter.convertToPPM(c);
        String pixelData = """
                            255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204
                            153 255 204 153 255 204 153 255 204 153 255 204 153
                            255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204
                            153 255 204 153 255 204 153 255 204 153 255 204 153
                            """;
        Assertions.assertEquals("P3\n10 2\n255\n" + pixelData + "\n", ppm);
    }
    @Test
    void PPMFileTerminatedByNewLineChar() {
        Canvas c = new Canvas(10, 2);
        Color c1 = new Color(1.0f,0.8f,0.6f);
        ArrayList<ArrayList<Color>> pixels = c.getCanvas();
        for (int column = 0; column < pixels.size(); column++) {
            for (int row = 0; row < pixels.get(column).size(); row++) {
                c.writePixel(row,column,c1);
            }
        }
        String ppm = PPMConverter.convertToPPM(c);
        String pixelData = """
                            255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204
                            153 255 204 153 255 204 153 255 204 153 255 204 153
                            255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204
                            153 255 204 153 255 204 153 255 204 153 255 204 153
                            """;
        Assertions.assertEquals("P3\n10 2\n255\n" + pixelData + "\n", ppm);
    }
}