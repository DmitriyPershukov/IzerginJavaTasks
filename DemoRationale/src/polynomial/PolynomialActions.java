package polynomial;

import rational.Rational;
import complex.Complex;
import complex.ComplexActions;
import java.util.Arrays;

public class PolynomialActions {
    public static Polynomial add(Polynomial a, Polynomial b){
        Complex[] sumCoefficients = new Complex[((a.getDegree() > b.getDegree())? a.getDegree(): b.getDegree()) + 1];
        for(int i = 0; i < sumCoefficients.length; i++){
            if(i < a.getDegree()+1 && i < b.getDegree()+1){
                sumCoefficients[i] = ComplexActions.add(a.getCoefficient(i), b.getCoefficient(i));
            } else if (i < a.getDegree()+1){
                sumCoefficients[i] = new Complex(a.getCoefficient(i).getReal(), a.getCoefficient(i).getImaginary());
            } else{
                sumCoefficients[i] = new Complex(b.getCoefficient(i).getReal(), b.getCoefficient(i).getImaginary());
            }
        }
        return new Polynomial(cutZeroCoefficients(sumCoefficients));
    }
    
    public static Polynomial subtract(Polynomial a, Polynomial b){
        Complex[] differenceCoefficients = new Complex[((a.getDegree() > b.getDegree())? a.getDegree(): b.getDegree()) + 1];
        for(int i = 0; i < differenceCoefficients.length; i++){
            if(i < a.getDegree()+1 && i < b.getDegree()+1){
                differenceCoefficients[i] = ComplexActions.subtract(a.getCoefficient(i), b.getCoefficient(i));
            } else if (i < a.getDegree()+1){
                differenceCoefficients[i] = new Complex(a.getCoefficient(i).getReal(), a.getCoefficient(i).getImaginary());
            } else{
                differenceCoefficients[i] = ComplexActions.subtract(new Complex(new Rational(0), new Rational(0)), b.getCoefficient(i));
            }
        }
        return new Polynomial(cutZeroCoefficients(differenceCoefficients));
    }
    
    private static Complex[] cutZeroCoefficients(Complex[] coefficients){
        int positionsToCutOff = 0;
        for(int i = coefficients.length-1; i >= 0; i--){
            if(coefficients[i].equals(new Complex(new Rational(0)))){
                positionsToCutOff++;
            } else{
                break;
            }
        }
        return Arrays.copyOfRange(coefficients, 0, coefficients.length - positionsToCutOff);
    }
    
    public static Polynomial multiply(Polynomial a, Polynomial b){
        Complex[] productCoefficients = new Complex[a.getDegree()+b.getDegree()+1];
        for(int i = 0; i < productCoefficients.length; i++){
            productCoefficients[i] = new Complex(new Rational(0));
        }
        for(int i = 0; i < a.getDegree()+1; i++){
            for(int j = 0; j < b.getDegree()+1; j++){
                Complex product = ComplexActions.multiply(a.getCoefficient(i), b.getCoefficient(j));
                productCoefficients[i+j] = ComplexActions.add(productCoefficients[i+j], product);
            }
        }
        return new Polynomial(productCoefficients);
    }
    
    public static Polynomial differentiate(Polynomial p){
        Complex[] coefficientsOfDifferential = new Complex[p.getDegree()];
        for(int i = coefficientsOfDifferential.length - 1; i >=0; i--){
            coefficientsOfDifferential[i] = ComplexActions.multiply(new Complex(new Rational(i+1)), p.getCoefficient(i+1));
        }
        return new Polynomial(coefficientsOfDifferential);
    }
    
    public static Polynomial integrate(Polynomial p){
        Complex[] coefficientsOfIntegral = new Complex[p.getDegree() + 2];
        if(p.getDegree() >= 0){
            coefficientsOfIntegral[0] = null;
        }
        for(int i = 1; i < coefficientsOfIntegral.length; i++){
            coefficientsOfIntegral[i] = ComplexActions.divide(p.getCoefficient(i-1), new Complex(new Rational(i)));
        }
        return new Polynomial(coefficientsOfIntegral);
    }
    
    public static Polynomial divide(Polynomial divisible, Polynomial divider){
        if(divider.getDegree() == 0 && divider.getCoefficient(0).equals(new Complex(new Rational(0)))){
            throw new java.lang.ArithmeticException("Division by zero polynomial");
        }
        
        if(divisible.getDegree() < divider.getDegree()){
            return new Polynomial(0);
        }
        
        Polynomial newDivisible = divisible;
        Polynomial quotient = new Polynomial(divisible.getDegree() - divider.getDegree());
        int i = quotient.getDegree();
        
        while(newDivisible.getDegree() >= divider.getDegree()){
            Complex newResultCoefficient = ComplexActions.divide(newDivisible.getCoefficient(newDivisible.getDegree()), divider.getCoefficient(divider.getDegree()));
            quotient.setCoefficient(i, newResultCoefficient);
            Polynomial multiplyer = new Polynomial(i);
            multiplyer.setCoefficient(i, newResultCoefficient);
            i--;
            Polynomial temp = PolynomialActions.multiply(multiplyer, divider);
            newDivisible = PolynomialActions.subtract(newDivisible, temp);
        }
        return quotient;
    }
}
