package demorationale;

import rational.Rational;
import rational.RationalActions;
import complex.Complex;
import complex.ComplexActions;
import polynomial.Polynomial;
import polynomial.PolynomialActions;

public class DemoRationale {
    
    public static void main(String[] args) {
        Rational r1 = new Rational(5, 3);
        Rational r2 = new Rational(6, 8);
        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);
        System.out.println("add(r1, r2): " + RationalActions.add(r1, r2));
        System.out.println("divide(r2, r1): " + RationalActions.divide(r2, r1));
        System.out.println("subtract(r2, r1): " + RationalActions.subtract(r2, r1));
        System.out.println("multiply(r1, r2): " + RationalActions.multiply(r1, r2));
        Complex c1 = new Complex(new Rational(6));
        Complex c2 = new Complex(new Rational(0));
        System.out.println("c1: " + c1);
        System.out.println("c2: " + c2);
        System.out.println("add(c1, c2): " + ComplexActions.add(c1, c2));
        System.out.println("divide(c2, c1): " + ComplexActions.divide(c2, c1));
        System.out.println("subtract(c2, c1): " + ComplexActions.subtract(c2, c1));
        System.out.println("multiply(c1, c2): " + ComplexActions.multiply(c1, c2));
        Polynomial p1 = Polynomial.createPolynomialFromCoefficients(c2, c1);
        Polynomial p2 = new Polynomial(new Complex[]{c1, c2, new Complex(new Rational(7, 9))});
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("add(p1, p2): " + PolynomialActions.add(p1, p2));
        System.out.println("differentiate(p2): " + PolynomialActions.differentiate(p2));
        System.out.println("divide(p1, p2): " + PolynomialActions.divide(p2, p1));
        System.out.println("integrate(p2): " + PolynomialActions.integrate(p2));
        System.out.println("subtract(p1, p2): " + PolynomialActions.subtract(p1, p2));
        System.out.println("multiply(p1, p2): " + PolynomialActions.multiply(p1, p2));

    }    
}
