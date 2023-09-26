package org.example;

public class Vector {

    public Vector(float x, float y, float z) {
        tuple = new Tuple(x,y,z);
    }

    public Vector(Tuple a) {
        tuple = a;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Vector other)) {
            return false;
        }
        return tuple.equals(other.tuple);
    }

    public float getX() {
        return tuple.getValue();
    }

    public float getY() {
        return tuple.getValue1();
    }

    public float getZ() {
        return tuple.getValue2();
    }

    public Tuple getTuple() {
        return tuple;
    }

    public Vector add(Vector b){
        return new Vector(this.tuple.add(b.tuple));
    }


    public Vector subtract(Vector b) {
        return new Vector(this.tuple.subtract(b.tuple));

    }
    public Vector multiply(float scalar) {
        return new Vector(this.tuple.multiply(scalar));
    }
    public Vector divide(float scalar) {
        return new Vector(this.tuple.divide(scalar));
    }

    public Vector negate() {
        return new Vector(-(this.getX()),-(this.getY()),-(this.getZ()));
    }


    public float getMagnitude() {
        return (float) Math.sqrt((this.getX()) * (this.getX()) + (this.getY()) * (this.getY()) + (this.getZ()) * (this.getZ()));
    }

    public Vector normalize() {
        float magnitude = this.getMagnitude();
        return new Vector ((this.getX()) / magnitude, (this.getY()) / magnitude, (this.getZ()) / magnitude);
    }

    public float dotProduct(Vector b) {
        return (float) ((this.getX()) * (b.getX()) +(this.getY()) * (b.getY()) + (this.getZ()) * (b.getZ()));
    }

    public Vector crossProduct(Vector b) {
        return new Vector((this.getY()) *(b.getZ()) - (this.getZ()) * (b.getY()), (this.getZ()) * (b.getX()) - (this.getX()) * (b.getZ()), (this.getX()) * (b.getY()) - (this.getY()) * (b.getX()));
    }
    private Tuple tuple;
}
