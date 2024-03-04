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
        return new Polynomial(sumCoefficients);
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
        return new Polynomial(differenceCoefficients);
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
        int positionsToCutOff = 0;
        for(int i = productCoefficients.length-1; i >= 0; i--){
            if(productCoefficients[i].equals(new Complex(new Rational(0)))){
                positionsToCutOff++;
            }
        }
        return new Polynomial(Arrays.copyOfRange(productCoefficients, 0, productCoefficients.length + 1 - positionsToCutOff));
    }
}
