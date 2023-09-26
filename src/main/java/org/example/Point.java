package org.example;

public class Point {
    public Point(float x, float y, float z) {
        coordinate = new Tuple(x,y,z);
    }

    public Point(Tuple a) {
        coordinate = a;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Point other)) {
            return false;
        }
        return coordinate.equals(other.coordinate);
    }

    public float getX() {
        return coordinate.getValue();
    }

    public float getY() {
        return coordinate.getValue1();
    }

    public float getZ() {
        return coordinate.getValue2();
    }

    public Point add(Point b){
        return new Point(this.coordinate.add(b.coordinate));
    }
    public Point add(Vector b){
        return new Point(this.coordinate.add(b.getTuple()));
    }

    public Point subtract(Point b) {
        return new Point(this.coordinate.subtract(b.coordinate));

    }
    public Point multiply(float scalar) {
        return new Point(this.coordinate.multiply(scalar));
    }
    public Point divide(float scalar) {
        return new Point(this.coordinate.divide(scalar));
    }

    public Point negate() {
        return new Point(-(this.getX()),-(this.getY()),-(this.getZ()));
    }

    private Tuple coordinate;

}
