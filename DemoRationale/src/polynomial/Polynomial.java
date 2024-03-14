package polynomial;

import rational.Rational;
import complex.Complex;
import complex.ComplexActions;
import java.lang.StringBuilder;

public class Polynomial {
    private Complex[] coefficients;
    
    public Polynomial(Complex[] coefficients){
        this.coefficients = new Complex[coefficients.length];
        for(int i = 0; i < coefficients.length; i++){
            if(coefficients[i] == null){
                this.coefficients[i] = null;
            } else{
                this.coefficients[i] = new Complex(coefficients[i].getReal(), coefficients[i].getImaginary());
            }
        }
    }
    
    public static Polynomial createPolynomialFromCoefficients(Complex... coefficients){
        return new Polynomial(coefficients);
    }
    
    public Polynomial(int degree){
        this.coefficients = new Complex[degree + 1];
        for(int i = 0; i < this.coefficients.length; i++){
            this.coefficients[i] = new Complex(new Rational(0), new Rational(0));
        }
    }
    
    public void setCoefficient(int index, Complex newCoefficient){
        this.coefficients[index] = new Complex(newCoefficient.getReal(), newCoefficient.getImaginary());
    }
    
    public Complex getCoefficient(int index){
        return this.coefficients[index];
    }
    
    public int getDegree(){
        return this.coefficients.length - 1;
    }
    
    public Complex evaluate(Complex x){
        Complex b = this.coefficients[this.coefficients.length - 1];
        for(int i = this.coefficients.length - 2; i >= 0; i--){
            b = ComplexActions.add(this.coefficients[i], ComplexActions.multiply(b, x));
        }
        return b;
    }
    
    @Override
    public String toString(){
            if(this.coefficients.length == 0){
            return "";
        }
        StringBuilder buffer = new StringBuilder("");
        for(int i = this.coefficients.length - 1; i > 0; i--){
            if(!(this.coefficients[i].getReal().equals(new Rational(0)) && this.coefficients[i].getImaginary().equals(new Rational(0)))){
                buffer.append("(");
                buffer.append(this.coefficients[i].toString());
                buffer.append(")*x^");
                buffer.append(i);
                buffer.append(" + ");
            }
        }
        if(this.coefficients[0] == null){
            buffer.append("C");
        } else{
            if(!(this.coefficients[0].getReal().equals(new Rational(0)) && this.coefficients[0].getImaginary().equals(new Rational(0)))){
                buffer.append("(");
                buffer.append(this.coefficients[0]);
                buffer.append(")");
            } else{
                buffer.delete(buffer.length()-3, buffer.length());
            }
        }
        return buffer.toString();
    }
    
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        
        if (!(o instanceof Polynomial)){
            return false;
        }
        
        Polynomial p = (Polynomial)o;
        
        if(this.getDegree() != p.getDegree()){
            return false;
        }
        
        for(int i = 0; i < this.coefficients.length; i++){
            if(!this.getCoefficient(i).equals(p.getCoefficient(i))){
                return false;
            }
        }      
        return true;
    }
}
