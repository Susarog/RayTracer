package org.example;

public class Material {
    public Material() {
        color = new Color(1,1,1);
        ambient = 0.1f;
        diffuse = 0.9f;
        specular = 0.9f;
        shininess = 200f;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Material other)) {
            return false;
        }

        return (this.shininess == other.shininess && this.diffuse == other.diffuse && this.color.equals(other.color) && this.ambient == other.ambient && this.specular == other.specular);
    }
    private Color color;
    private float ambient;
    private float diffuse;
    private float specular;
    private float shininess;


    public float getAmbient() {
        return ambient;
    }

    public void setAmbient(float ambient) {
        if (ambient < 0 || ambient > 1) {
            System.err.println("Value must be between 0-1");
            System.exit(1);
        }
        this.ambient = ambient;
    }

    public float getDiffuse() {
        return diffuse;
    }

    public void setDiffuse(float diffuse) {
        if (ambient < 0 || ambient > 1) {
            System.err.println("Value must be between 0-1");
            System.exit(1);
        }
        this.diffuse = diffuse;
    }

    public float getSpecular() {
        return specular;
    }

    public void setSpecular(float specular) {
        if (ambient < 0 || ambient > 1) {
            System.err.println("Value must be between 0-1");
            System.exit(1);
        }
        this.specular = specular;
    }

    public float getShininess() {
        return shininess;
    }

    public void setShininess(float shininess) {
        this.shininess = shininess;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
