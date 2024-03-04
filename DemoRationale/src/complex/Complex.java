package complex;

import rational.Rational;

public class Complex {
    private Rational real;
    private Rational imaginary;
    
    public Complex(Rational real, Rational imaginary){
        this.real = new Rational(real.getNumerator(), real.getDenominator());
        this.imaginary = new Rational(imaginary.getNumerator(), imaginary.getDenominator());
    }
    
    public Complex(Rational real){
        this.real = new Rational(real.getNumerator(), real.getDenominator());
        this.imaginary = new Rational(0);
    }
    
    public Rational getReal(){
        return new Rational(this.real.getNumerator(), this.real.getDenominator());
    }
    
    public Rational getImaginary(){
        return new Rational(this.imaginary.getNumerator(), this.imaginary.getDenominator());
    }
    
    @Override
    public String toString(){
        if(this.imaginary.getNumerator() >= 0){
            return real + " + " + imaginary + "i";
        }
        else{
            return real + " - " + new Rational(-1 * imaginary.getNumerator(), imaginary.getDenominator()) + "i";
        }
    }
    
    @Override
    public boolean equals(Object o){
        if (o == this){
            return true;
        }
        
        if (!(o instanceof Complex)){
            return false;
        }
        
        Complex c = (Complex)o;
        
        return (this.getReal().equals(c.getReal())) && (this.getImaginary().equals(c.getImaginary()));
    }
}
