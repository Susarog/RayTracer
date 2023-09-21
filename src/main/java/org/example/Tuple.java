package org.example;

public class Tuple {

    // Define a custom exception class
    public static class TupleException extends Exception {
        public TupleException(String message) {
            super(message);
        }
    }

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

    public Tuple add(Tuple b) throws TupleException {
        if (this.w + b.w > 1) {
            throw new TupleException("You can't add two points with each other");
        }

        float x = this.x + b.x;
        float y = this.y + b.y;
        float z = this.z + b.z;
        float w = this.w + b.w;
        return new Tuple(x,y,z,w);
    }

    public Tuple subtract(Tuple b) throws TupleException {
        if (this.w - b.w < 0 ) {
            throw new TupleException("You can't subtract two points with each other");
        }

        float x = this.x - b.x;
        float y = this.y - b.y;
        float z = this.z - b.z;
        float w = this.w - b.w;
        return new Tuple(x,y,z,w);
    }
    public Tuple negate() {
        return new Tuple(-(this.x),-(this.y),-(this.z),-(this.w));
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
