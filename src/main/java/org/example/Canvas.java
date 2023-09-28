package org.example;
import java.util.ArrayList;

public class Canvas {

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        canvas = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            ArrayList<Color> innerList = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                innerList.add(new Color(0.0f,0.0f,0.0f));
            }
            canvas.add(innerList);
        }
    }

    public void writePixel(int row, int column, Color color) {
        canvas.get(column).set(row,color);
    }

    public Color getPixel(int row, int column) {
        return canvas.get(column).get(row);
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
