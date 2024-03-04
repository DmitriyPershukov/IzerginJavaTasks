package polynomial;

import rational.Rational;
import complex.Complex;
import complex.ComplexActions;
import java.lang.StringBuilder;

public class Polynomial {
    private Complex[] coefficients;
    
//    public Polynomial(Complex[] coefficients){
//        this.coefficients = new Complex[coefficients.length];
//        for(int i = 0; i < coefficients.length; i++){
//            this.coefficients[i] = new Complex(coefficients[i].getReal(), coefficients[i].getImaginary());
//        }
//    }
    
    public Polynomial(Object... input){
        if(input[0] instanceof Complex[]){
            Complex[] coefficients = (Complex[])input[0];
            this.coefficients = new Complex[coefficients.length];
            for(int i = 0; i < coefficients.length; i++){
                this.coefficients[i] = new Complex(coefficients[i].getReal(), coefficients[i].getImaginary());
            }
        } else {
            try{
                this.coefficients = new Complex[input.length];
                for(int i = 0; i < input.length; i++){
                    Complex temp = (Complex)input[i];
                    this.coefficients[i] = new Complex(temp.getReal(), temp.getImaginary());
                }  
            } catch (ClassCastException e){
                throw new IllegalArgumentException("Constructor arguments should be single Complex[] instance or multiple Complex instances");
            }

        }
    }
    
//    public Polynomial(Complex... coefficients){
//        this.coefficients = new Complex[coefficients.length];
//        for(int i = 0; i < coefficients.length; i++){
//            this.coefficients[i] = new Complex(coefficients[i].getReal(), coefficients[i].getImaginary());
//        }
//    }
    
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
        buffer.append("(");
        buffer.append(this.coefficients[0]);
        buffer.append(")");
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
