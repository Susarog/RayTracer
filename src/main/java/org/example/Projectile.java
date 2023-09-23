package org.example;

import java.sql.Statement;

public class Projectile {
    public Projectile(Tuple point, Tuple vector) {
        this.position = point;
        this.velocity = vector;
    }

    public static Projectile tick(Environment env, Projectile proj) {
        Tuple position = proj.getPosition().add(proj.getVelocity());
        Tuple velocity = proj.getVelocity().add(env.getGravity().add(env.getWind()));
        return new Projectile(position, velocity);
    }

    public Tuple getPosition() {
        return position;
    }

    public Tuple getVelocity() {
        return velocity;
    }
    private Tuple position;
    private Tuple velocity;
}
