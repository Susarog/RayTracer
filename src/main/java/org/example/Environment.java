package org.example;

public class Environment {
    public Environment(Tuple gravity, Tuple wind) {
        this.gravity = gravity;
        this.wind = wind;
    }
    public Tuple getGravity() {
        return gravity;
    }

    public Tuple getWind() {
        return wind;
    }
    private Tuple gravity;
    private Tuple wind;
}
