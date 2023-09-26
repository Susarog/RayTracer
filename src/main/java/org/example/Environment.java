package org.example;

public class Environment {
    public Environment(Vector gravity, Vector wind) {
        this.gravity = gravity;
        this.wind = wind;
    }
    public Vector getGravity() {
        return gravity;
    }

    public Vector getWind() {
        return wind;
    }
    private Vector gravity;
    private Vector wind;
}
