package complex;

import rational.RationalActions;
import rational.Rational;
        
public class ComplexActions {
    public static Complex add(Complex a, Complex b){
        return new Complex(RationalActions.add(a.getReal(), b.getReal()), RationalActions.add(a.getImaginary(), b.getImaginary()));
    }
    
    public static Complex subtract(Complex a, Complex b){
        return new Complex(RationalActions.subtract(a.getReal(), b.getReal()), RationalActions.subtract(a.getImaginary(), b.getImaginary()));
    }
    
    public static Complex multiply(Complex a, Complex b){
        return new Complex(RationalActions.subtract(RationalActions.multiply(a.getReal(), b.getReal()), RationalActions.multiply(a.getImaginary(), b.getImaginary())), RationalActions.add(RationalActions.multiply(a.getReal(), b.getImaginary()), RationalActions.multiply(a.getImaginary(), b.getReal())));
    }
    
    public static Complex divide(Complex a, Complex b){
        Rational realPartNumenator = RationalActions.add(RationalActions.multiply(a.getReal(), b.getReal()), RationalActions.multiply(a.getImaginary(), b.getImaginary()));
        Rational complexDenominator = RationalActions.add(RationalActions.multiply(b.getReal(), b.getReal()), RationalActions.multiply(b.getImaginary(), b.getImaginary()));
        Rational imaginaryPartNumenator = RationalActions.subtract(RationalActions.multiply(a.getImaginary(), b.getReal()), RationalActions.multiply(a.getReal(), b.getImaginary()));
        Rational realPart = RationalActions.divide(realPartNumenator, complexDenominator);
        Rational imaginaryPart = RationalActions.divide(imaginaryPartNumenator, complexDenominator);
        return new Complex(realPart, imaginaryPart);
    }
}
