package square;

public class LineSegment {
    private Point a;
    private Point b;
    
    public LineSegment(Point a, Point b){
        this.a = a.copy();
        this.b = b.copy();
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }
    
    public double getLength(){
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
    
    public LineSegment copy(){
        return new LineSegment(this.a, this.b);
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if(other != null && other.getClass() == this.getClass()){
            LineSegment otherSegment = (LineSegment)other;
            return (otherSegment.getA().equals(this.a) && otherSegment.getB().equals(this.b)) || (otherSegment.getA().equals(this.b) && otherSegment.getB().equals(this.a));
        } else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.a.hashCode();
        result = prime * result + this.b.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{" + this.a + "; " + this.b + "}";
    }
    
    public LineSegment changeLengthMovingB(double changeCoefficient){
        double newLength = this.getLength() * changeCoefficient;
        double unnormalizedDirectionVectorX = this.b.getX() - this.a.getX();
        double unnormalizedDirectionVectorY = this.b.getY() - this.a.getY();
        double directionUnitVectorX = unnormalizedDirectionVectorX / this.getLength();
        double directionUnitVectorY = unnormalizedDirectionVectorY / this.getLength();
        double directionVectorX = directionUnitVectorX * newLength;
        double directionVectorY = directionUnitVectorY * newLength;
        Point newB = new Point(this.a.getX() + directionVectorX, this.a.getY() + directionVectorY);
        return new LineSegment(this.a.copy(), newB);
    }
    
        public LineSegment changeLengthMovingA(double changeCoefficient){
        double newLength = this.getLength() * changeCoefficient;
        double unnormalizedDirectionVectorX = this.a.getX() - this.b.getX();
        double unnormalizedDirectionVectorY = this.a.getY() - this.b.getY();
        double directionUnitVectorX = unnormalizedDirectionVectorX / this.getLength();
        double directionUnitVectorY = unnormalizedDirectionVectorY / this.getLength();
        double directionVectorX = directionUnitVectorX * newLength;
        double directionVectorY = directionUnitVectorY * newLength;
        Point newA = new Point(this.b.getX() + directionVectorX, this.b.getY() + directionVectorY);
        return new LineSegment(newA, this.b.copy());
    }
}
