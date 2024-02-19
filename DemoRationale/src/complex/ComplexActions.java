package complex;

import rational.RationalActions;
        
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
        throw new java.lang.UnsupportedOperationException();
        //return new Complex(a.getNumerator() * b.getDenominator(), a.getDenominator() * b.getNumerator());
    }
}
