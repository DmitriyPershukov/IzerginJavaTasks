package demosquare;

import square.LineSegment;
import square.Square;
import square.Point;

public class DemoSquare {

    public static void main(String[] args) {
        Point p1 = new Point(1, 4);
        Point p2 = new Point(4, 4);
        Point p3 = new Point(4, 1);
        Point p4 = new Point(1, 1);
        LineSegment ls1 = new LineSegment(p1, p2);
        LineSegment ls2 = new LineSegment(p2, p3);
        LineSegment ls3 = new LineSegment(p3, p4);
        LineSegment ls4 = new LineSegment(p4, p1);
        Square sq = new Square(ls1, ls2, ls3, ls4, "red");
        System.out.println(sq);
        System.out.println(sq.scaleSquareUp(2));
        System.out.println(sq.scaleSquareDown(0.5));
        System.out.println(sq.rotateSquare(90));
        sq.setColour("green");
    }
}
