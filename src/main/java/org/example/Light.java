package org.example;

public class Light {
    public Light() {
        position = new Point(0,0,0);
        intensity = new Color(1,1,1);
    }
    public Light(Point position, Color intensity) {
        this.position = position;
        this.intensity = intensity;
    }

    public Point getPosition() {
        return position;
    }
    public void setPosition(Point position) {
        this.position = position;
    }
    public Color getIntensity() {
        return intensity;
    }
    public void setIntensity(Color intensity) {
        this.intensity = intensity;
    }
    private Point position;
    private Color intensity;
}
