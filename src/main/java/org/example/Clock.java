package org.example;

import java.io.FileOutputStream;
import java.io.IOException;

public class Clock {
    public static void main(String[] args) throws IOException {

        Point p = new Point(0f,0f,100f);
        Canvas canvas = new Canvas(900, 550);
        for (int i = 0; i < 360; i += 30) {
            Matrix transform = Matrix.yRotation((float) Math.toRadians(i));
            Point newPoint = transform.multiply(p);
            canvas.writePixel(Math.round(newPoint.getX()) + canvas.getWidth()/2,Math.round(newPoint.getZ()) + canvas.getHeight()/2, new Color(1f,1f,1f));
        }

        FileOutputStream fos = new FileOutputStream("./images/clock.ppm");
        fos.write(PPMConverter.convertToPPM(canvas).getBytes());
        fos.close();
    }
}
