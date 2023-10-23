package org.example;


public class Ray {
    public Point position(float time) {
        Vector scaledDirection = direction.multiply(time);
        return origin.add(scaledDirection);
    }

    public Ray(Point origin, Vector direction){
        this.origin = origin;
        this.direction = direction;
    }
    //TODO make intersect work with more complex scenes
    public Intersection[] intersect(Sphere obj) {
        Ray newRay = this.transform(obj.getTransform().inverse());
        Vector sphereToRay = newRay.origin.subtract(obj.getOrigin());
        float a = newRay.direction.dotProduct(newRay.direction);
        float b = newRay.direction.dotProduct(sphereToRay) * 2;
        float c = sphereToRay.dotProduct(sphereToRay) - 1;
        float discriminant = b*b - 4 * a * c;
        if (discriminant < 0) {
            return new Intersection[]{};
        }
        float t1 = (float) ((-b - Math.sqrt(discriminant))/(2*a));
        float t2 = (float) ((-b + Math.sqrt(discriminant))/(2*a));
        Intersection i1 = new Intersection(t1,obj);
        Intersection i2 = new Intersection(t2,obj);
        return Intersection.intersections(i1,i2);
    }

    public Ray transform(Matrix transform) {
        Point newOrigin = transform.multiply(origin);
        Vector newDirection = transform.multiply(direction);
        return new Ray(newOrigin,newDirection);
    }

    private Point origin;
    private Vector direction;

    public Point getOrigin() {
        return origin;
    }

    public Vector getDirection() {
        return direction;
    }
}
