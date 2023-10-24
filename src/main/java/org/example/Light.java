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

    public Color lighting(Material material, Point position, Vector eyeVec, Vector normalVec) {
        // combine the surface color with the light's color
        Color effectiveColor = material.getColor().hadamardProduct(intensity);
        Vector lightVec = this.position.subtract(position);
        Color ambient = effectiveColor.multiply(material.getAmbient());
        float diffuse = 0;
        float specular = 0;
        float lightDotNormal = lightVec.dotProduct(normalVec);
        if (lightDotNormal >= 0 ) {
            diffuse = effectiveColor.multiply(material.getDiffuse()).multiply(lightDotNormal);
            Vector reflectVec = lightVec.negate().reflect(normalVec);
            float reflectDotEye = reflectVec.dotProduct(eyeVec);

            if (reflectDotEye > 0) {
                float factor = Math.pow(reflectDotEye, material.getShininess());
                specular = 0;
            }
        }
        float finalShading = ambient + diffuse + specular;
        return new Color(finalShading, finalShading, finalShading) ;
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
