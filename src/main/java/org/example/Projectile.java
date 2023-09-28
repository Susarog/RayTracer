package org.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Statement;

public class Projectile {
    public Projectile(Point position, Vector vector) {
        this.position = position;
        this.velocity = vector;
    }

    public static void main(String[] args) throws IOException {
        Projectile p = new Projectile(new Point(0.0f, 1.0f, 0.0f),
                (new Vector(1.0f, 1.8f, 0.0f).normalize()).multiply(11.25f));
        Environment e = new Environment(new Vector(0.0f, -0.1f, 0.0f),
                new Vector(-0.01f, 0.0f, 0.0f));
        Canvas canvas = new Canvas(900, 550);
        int tickCount = 0;
        while (p.getPosition().getY() > 0) {
            tickCount++;
            canvas.writePixel(Math.round(p.getPosition().getX()), canvas.getHeight() - Math.round((p.getPosition().getY())), new Color(1.0f, 0.0f, 0.0f));
            System.out.println(p.getPosition().getX());
            p = Projectile.tick(e, p);
        }
        System.out.println(tickCount);

        FileOutputStream fos = new FileOutputStream("./images/projectile.ppm");
        fos.write(PPMConverter.convertToPPM(canvas).getBytes());
        fos.close();
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
