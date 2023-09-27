package org.example;
import java.util.ArrayList;

public class Canvas {

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        canvas = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            ArrayList<Color> innerList = new ArrayList<>();
            for (int j = 0; j < height; j++) {
                innerList.add(new Color(0.0f,0.0f,0.0f)); // You can add any values you want here
            }
            canvas.add(innerList);
        }
    }

    public void writePixel(int row, int column, Color color) {
        canvas.get(row).set(column,color);
    }

    public Color getPixel(int row, int column) {
        return canvas.get(row).get(column);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ArrayList<ArrayList<Color>> getCanvas() {
        return canvas;
    }

    private int width;
    private int height;
    private ArrayList<ArrayList<Color>>canvas;


}
