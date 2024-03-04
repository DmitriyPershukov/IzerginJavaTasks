package demorationale;

import rational.Rational;
import rational.RationalActions;
import complex.Complex;
import complex.ComplexActions;
import polynomial.Polynomial;
import polynomial.PolynomialActions;

public class DemoRationale {
    
    public static void main(String[] args) {
        Complex c1 = new Complex(new Rational(6));
        Complex c2 = new Complex(new Rational(0));
        Complex c3 = new Complex(new Rational(2));
        Complex c4 = new Complex(new Rational(5));
        Polynomial p3 = new Polynomial(c1, c2, c3, c4);
        Polynomial p1 = new Polynomial(new Complex[]{c1, c2, c3, c4});
        Complex c12 = new Complex(new Rational(6));
        Complex c22 = new Complex(new Rational(0));
        Complex c32 = new Complex(new Rational(2));
        Complex c42 = new Complex(new Rational(3));
        Complex c52 = new Complex(new Rational(4));
        Polynomial p2 = new Polynomial(new Complex[]{c12, c22, c32, c42, c52});
        System.out.println(PolynomialActions.multiply(p1, p2));
    }    
}
