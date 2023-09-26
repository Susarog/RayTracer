package org.example;

public class Main {
    public static void main(String[] args) {
        Projectile p = new Projectile(new Point(0.0f,1.0f,0.0f),
                (new Vector(1.0f,1.0f,0.0f).normalize()).multiply(1));
        Environment e = new Environment(new Vector(0.0f,-0.1f,0.0f),
                new Vector(-0.01f,0.0f,0.0f));

        int tickCount = 0;
        while (p.getPosition().getY() > 0) {
            tickCount++;
            System.out.println(p.getPosition().getX());
            p = Projectile.tick(e,p);
        }
        System.out.println(tickCount);

    }
}