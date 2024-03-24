package square;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
   
    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if(other != null && other.getClass() == this.getClass()){
            Point otherPoint = (Point)other;
            return this.x == otherPoint.getX() && this.y == otherPoint.getY();
        } else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int)this.x;
        result = prime * result + (int)this.y;
        return result;
    }

    @Override
    public String toString() {
        return "x:" + this.x + " y:" + this.y;
    }
    
    public Point copy(){
        return new Point(this.x, this.y);
    }
    
    public Point rotateAroundOtherPoint(Point centerOfRotation, double angleDegrees){
        double originX = this.x - centerOfRotation.getX();
        double originY = this.y - centerOfRotation.getY();
        double sinAngle =Math.sin((Math.PI / 180) * angleDegrees);
        double cosAngle =Math.cos((Math.PI / 180) * angleDegrees);
        double newX = originX * cosAngle - originY * sinAngle;
        double newY = originX * sinAngle + originY * cosAngle;
        return new Point(newX + centerOfRotation.getX(), newY + centerOfRotation.getY());
    }
}
