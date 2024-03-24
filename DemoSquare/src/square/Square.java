package square;

public class Square {
    private LineSegment side1;
    private LineSegment side2;
    private LineSegment side3;
    private LineSegment side4;
    private String colour;

    public Square(LineSegment side1, LineSegment side2, LineSegment side3, LineSegment side4, String colour) {
        if(sidesFormSquare(side1, side2, side3, side4)){
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
            this.side4 = side4;
            this.colour = colour;
        } else{
            throw new java.lang.IllegalArgumentException("Стороны не образуют квадрат");
        }
    }
    
    public void setSides(LineSegment side1, LineSegment side2, LineSegment side3, LineSegment side4){
        if(sidesFormSquare(side1, side2, side3, side4)){
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
            this.side4 = side4;
        } else{
            throw new java.lang.IllegalArgumentException("Стороны не образуют квадрат");
        }
    }
    
    private boolean sidesFormSquare(LineSegment side1, LineSegment side2, LineSegment side3, LineSegment side4){
        boolean sidesEqual = side1.getLength() == side2.getLength() && side2.getLength() == side3.getLength() && side3.getLength() == side4.getLength();
        boolean diagonalsEqual = (new LineSegment(side1.getA(), side2.getB())).getLength() == (new LineSegment(side1.getB(), side4.getA())).getLength();
        return sidesEqual && diagonalsEqual;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public String getColour() {
        return colour;
    }

    public LineSegment getSide1() {
        return side1.copy();
    }

    public LineSegment getSide2() {
        return side2.copy();
    }

    public LineSegment getSide3() {
        return side3.copy();
    }

    public LineSegment getSide4() {
        return side4.copy();
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if(other != null && other.getClass() == this.getClass()){
            Square otherSquare = (Square)other;
            boolean sides1Equal = this.side1.equals(otherSquare.getSide1());
            boolean sides2Equal = this.side2.equals(otherSquare.getSide2());
            boolean sides3Equal = this.side3.equals(otherSquare.getSide3());
            boolean sides4Equal = this.side4.equals(otherSquare.getSide4());
            return sides1Equal && sides2Equal && sides3Equal && sides4Equal;
        } else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.side1.hashCode();
        result = prime * result + this.side2.hashCode();
        result = prime * result + this.side3.hashCode();
        result = prime * result + this.side4.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("{side1:%s; side2:%s; side3:%s; side4:%s}", side1, side2, side3, side4);
    }
    
    private Square buildSquareFromTwoLineSegments(LineSegment side1, LineSegment side4){
        double side1DirectionVectorX = side1.getB().getX() - side1.getA().getX();
        double side1DirectionVectorY = side1.getB().getY() - side1.getA().getY();
        Point side3PointA = new Point(side4.getA().getX()+side1DirectionVectorX, side4.getA().getY()+side1DirectionVectorY);
        Point side3PointB = side4.getA().copy();
        LineSegment side3 = new LineSegment(side3PointA, side3PointB);
        LineSegment side2 = new LineSegment(side1.getB().copy(), side3.getA().copy());
        return new Square(side1, side2, side3, side4, this.colour);
    }
    
    public Square scaleSquareUp(double valueToScaleUpBy){
        if(valueToScaleUpBy <= 1){
            throw new java.lang.IllegalArgumentException("Значение valueToScaleUpBy должно быть больше единицы.");
        }
        LineSegment scaleSide1 = this.side1.changeLengthMovingB(valueToScaleUpBy);
        LineSegment scaleSide4 = this.side4.changeLengthMovingA(valueToScaleUpBy);
        return buildSquareFromTwoLineSegments(scaleSide1, scaleSide4);
    }
    
    public Square scaleSquareDown(double valueToScaleDownBy){
        if(valueToScaleDownBy >= 1 && valueToScaleDownBy <= 0){
            throw new java.lang.IllegalArgumentException("Значение valueToScaleDownBy должно быть меньше единицы и больше нуля.");
        }
        LineSegment scaleSide1 = this.side1.changeLengthMovingB(valueToScaleDownBy);
        LineSegment scaleSide4 = this.side4.changeLengthMovingA(valueToScaleDownBy);
        return buildSquareFromTwoLineSegments(scaleSide1, scaleSide4);
    }
    
    private Point getCenter(){
        double diagonalCenterX = (this.side1.getA().getX() + this.side2.getB().getX()) / 2;
        double diagonalCenterY = (this.side1.getA().getY() + this.side2.getB().getY()) / 2;
        return new Point(diagonalCenterX, diagonalCenterY);
    }
    
    public Square rotateSquare(double angleDegrees){
        Point centerOfRotation = getCenter();
        Point p1 = this.side1.getA();
        Point p2 = this.side2.getA();
        Point p3 = this.side3.getA();
        Point p4 = this.side4.getA();
        Point newP1 = p1.rotateAroundOtherPoint(centerOfRotation, angleDegrees);
        Point newP2 = p2.rotateAroundOtherPoint(centerOfRotation, angleDegrees);
        Point newP3 = p3.rotateAroundOtherPoint(centerOfRotation, angleDegrees);
        Point newP4 = p4.rotateAroundOtherPoint(centerOfRotation, angleDegrees);
        LineSegment newSide1 = new LineSegment(newP1, newP2);
        LineSegment newSide2 = new LineSegment(newP2, newP3);
        LineSegment newSide3 = new LineSegment(newP3, newP4);
        LineSegment newSide4 = new LineSegment(newP4, newP1);
        return new Square(newSide1, newSide2, newSide3, newSide4, this.colour);
    }
}
