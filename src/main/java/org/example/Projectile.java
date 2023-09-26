package org.example;

import java.sql.Statement;

public class Projectile {
    public Projectile(Point position, Vector vector) {
        this.position = position;
        this.velocity = vector;
    }

    public static Projectile tick(Environment env, Projectile proj) {
        Point position = proj.getPosition().add(proj.getVelocity());
        Vector velocity = proj.getVelocity().add(env.getGravity().add(env.getWind()));
        return new Projectile(position, velocity);
    }

    public Point getPosition() {
        return position;
    }

    public Vector getVelocity() {
        return velocity;
    }
    private Point position;
    private Vector velocity;
}
