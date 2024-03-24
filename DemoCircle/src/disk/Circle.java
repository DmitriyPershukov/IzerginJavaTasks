package disk;

public class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center.copy();
        this.radius = radius;
    }

    public Point getCenter() {
        return center.copy();
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public Circle copy(){
        return new Circle(this.center.copy(), radius);
    }
    
    public boolean IsPointInsideCircle(Point point){
        return Math.pow(this.center.getX() - point.getX(), 2) + Math.pow(this.center.getY() - point.getY(), 2) <= Math.pow(radius, 2);
    }
}
