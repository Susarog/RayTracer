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
        Vector lightVec = this.position.subtract(position).normalize();
        Color ambient = effectiveColor.multiply(material.getAmbient());
        Color diffuse = new Color(0,0,0);
        Color specular = new Color(0,0,0);
        float lightDotNormal = lightVec.dotProduct(normalVec);
        if (lightDotNormal >= 0 ) {
            diffuse = effectiveColor.multiply(material.getDiffuse()).multiply(lightDotNormal);
            Vector reflectVec = lightVec.negate().reflect(normalVec);
            float reflectDotEye = reflectVec.dotProduct(eyeVec);

            if (reflectDotEye > 0) {
                float factor = (float) Math.pow(reflectDotEye,material.getShininess());
                specular = intensity.multiply(material.getSpecular()).multiply(factor);
            }
        }
        return ambient.add(diffuse).add(specular);
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
