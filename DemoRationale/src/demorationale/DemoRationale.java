package demorationale;

import rational.Rational;
import rational.RationalActions;
import complex.Complex;
import complex.ComplexActions;

public class DemoRationale {
    
    public static void main(String[] args) {
        Rational rational1 = new Rational(2);
        Rational rational2 = new Rational(3);
        Complex c1 = new Complex(rational1, rational2);
        Rational rational3 = new Rational(-1);
        Rational rational4 = new Rational(1);
        Complex c2 = new Complex(rational3, rational4);
        System.out.println(ComplexActions.multiply(c1, c2));
    }    
}
