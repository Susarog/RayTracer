package org.example;

public class Tuple {

    public Tuple(float v, float v1, float v2) {
        value = v;
        value1 = v1;
        value2 = v2;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Tuple other)) {
            return false;
        }
        return (Math.abs(this.value2 - other.value2) < EPSILON) && (Math.abs(this.value - other.value) < EPSILON) && (Math.abs(this.value1 - other.value1) < EPSILON);
    }

    public Tuple add(Tuple b) {
        float x = this.value + b.value;
        float y = this.value1 + b.value1;
        float z = this.value2 + b.value2;
        return new Tuple(x,y,z);
    }

    public Tuple subtract(Tuple b) {
        return this.add(b.negate());
    }
    public Tuple negate() {
        return new Tuple(-(this.value),-(this.value1),-(this.value2));
    }
    public Tuple multiply(float scalar) {
        float scaledX = (this.value) * scalar;
        float scaledY = (this.value1) * scalar;
        float scaledZ = (this.value2) * scalar;
        return new Tuple(scaledX,scaledY,scaledZ);
    }
    public Tuple divide(float scalar) {
        return this.multiply(1/scalar);
    }

    public float getValue() {
        return value;
    }

    public float getValue1() {
        return value1;
    }

    public float getValue2() {
        return value2;
    }

    private final float value;
    private final float value1;
    private final float value2;
    private final static double EPSILON = 0.00001;
}
