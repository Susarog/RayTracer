package org.example;

public class Tuple {

    public Tuple(float v, float v1, float v2, float v3) {
        x = v;
        y = v1;
        z = v2;
        w = v3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Tuple other)) {
            return false;
        }
        return (Math.abs(this.z - other.z) < EPSILON) && (Math.abs(this.x - other.x) < EPSILON) && (Math.abs(this.y - other.y) < EPSILON);
    }
    public static Tuple point(float v, float v1, float v2) {
        return new Tuple(v,v1,v2,1.0f);
    }
    public static Tuple vector(float v, float v1, float v2) {
        return new Tuple(v,v1,v2,0.0f);
    }

    public Tuple add(Tuple b) {
        float x = this.x + b.x;
        float y = this.y + b.y;
        float z = this.z + b.z;
        float w = this.w + b.w;
        return new Tuple(x,y,z,w);
    }

    public Tuple subtract(Tuple b) {
        return this.add(b.negate());
    }
    public Tuple negate() {
        return new Tuple(-(this.x),-(this.y),-(this.z),-(this.w));
    }
    public Tuple multiply(float scalar) {
        float scaledX = (this.x) * scalar;
        float scaledY = (this.y) * scalar;
        float scaledZ = (this.z) * scalar;
        float scaledW = (this.w) * scalar;
        return new Tuple(scaledX,scaledY,scaledZ,scaledW);
    }
    public Tuple divide(float scalar) {
        return this.multiply(1/scalar);
    }

    public float getMagnitude() {
        return (float)(Math.sqrt((this.x) * (this.x) +(this.y) * (this.y) + (this.z) * (this.z)));
    }

    public Tuple normalize() {
        float magnitude = this.getMagnitude();
        return new Tuple (this.x / magnitude, this.y / magnitude, this.z / magnitude, this.w / magnitude);
    }

    public float dotProduct(Tuple b) {
        return (this.x) * (b.x) +(this.y) * (b.y) + (this.z) * (b.z) + (this.w) * (b.w);
    }

    public Tuple crossProduct(Tuple b) {
        return Tuple.vector(this.y * b.z - this.z * b.y, this.z * b.x - this.x * b.z, this.x * b.y - this.y * b.x);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getW() {
        return w;
    }

    public boolean isPoint() {
        return w == 1.0f;
    }

    private final float x;
    private final float y;
    private final float z;
    private final float w;
    private final static double EPSILON = 0.00001;
}
