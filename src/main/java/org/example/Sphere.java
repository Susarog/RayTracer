package org.example;

import java.io.FileOutputStream;
import java.io.IOException;

public class Sphere {
    public static void main(String[] args) throws IOException {
        float zWall = 10.0f;
        float wallSize = 7.0f;
        int canvasPixels = 500;
        float pixelSize = wallSize / canvasPixels;
        float half = wallSize/2;
        Sphere s = new Sphere();
        s.getMaterial().setColor(new Color(1,0.2f,1));
        Point rayOrigin = new Point(0f,0f,-5f);
        Point lightPosition = new Point(-10,10,-10);
        Color lightColor = new Color(1,1,1);
        Light light = new Light(lightPosition, lightColor);
        Canvas canvas = new Canvas(canvasPixels, canvasPixels);
        for (int y = 0; y < canvasPixels; y++) {
            float yCoords = (half - (pixelSize * y));
            for (int x = 0; x < canvasPixels; x++) {
                float xCoords = (-half + (pixelSize * x));
                Point currentPosition = new Point(xCoords,yCoords,zWall);
                Ray r = new Ray(rayOrigin,currentPosition.subtract(rayOrigin).normalize());
                Intersection[] xs = r.intersect(s);
                Intersection hitIntersection = Intersection.hit(xs);
                if(hitIntersection != null) {
                    Point pointAtIntersection = r.position(hitIntersection.getTime());
                    Vector eye = r.getDirection().normalize().negate();
                    Vector normal = hitIntersection.getObject().normalAt(pointAtIntersection);
                    Color color = light.lighting(hitIntersection.getObject().getMaterial(), pointAtIntersection, eye, normal);
                    canvas.writePixel(x,y,color);
                }

            }
        }

        FileOutputStream fos = new FileOutputStream("./images/sphere.ppm");
        fos.write(PPMConverter.convertToPPM(canvas).getBytes());
        fos.close();
    }
    private Point origin;
    private Matrix transform;

    private Material material;

    public Sphere() {
        origin = new Point(0,0,0);
        transform = new Matrix();
        material = new Material();
    }
    public Sphere(Matrix transform) {
        origin = new Point(0,0,0);
        this.transform = transform;
    }

    public Vector normalAt(Point point) {
        Point objectPoint = transform.inverse().multiply(point);
        Vector objectNormal = objectPoint.subtract(origin);
        Vector worldNormal = transform.inverse().transpose().multiply(objectNormal);
        return worldNormal.normalize();
    }

    public Point getOrigin() {
        return origin;
    }

    public Matrix getTransform() {
        return transform;
    }

    public void setTransform(Matrix transform) {
        this.transform = transform;
    }

    public Material getMaterial() {
        return material;
    }
}
