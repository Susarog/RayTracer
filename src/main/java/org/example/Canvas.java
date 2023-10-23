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

    public void writePixel(int column, int row, Color color) {
        canvas.get(row).set(column,color);
    }

    public Color getPixel(int column, int row) {
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
