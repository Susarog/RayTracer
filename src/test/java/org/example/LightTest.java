package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class LightTest {
    @Test
    void reflectVectorApproachingSlantedSurface(){
        Point position = new Point(1,1,1);
        Color intensity = new Color(0,0,0);
        Light light = new Light(position, intensity);
        Assertions.assertEquals(position, light.getPosition());
        Assertions.assertEquals(intensity, light.getIntensity());

    }

}