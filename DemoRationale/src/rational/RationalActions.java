/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rational;

/**
 *
 * @author user
 */
public class RationalActions{
    public static Rational add(Rational a, Rational b){
        return new Rational(a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator(), a.getDenominator() * b.getDenominator());
    }
    
    public static Rational subtract(Rational a, Rational b){
        return new Rational(a.getNumerator() * b.getDenominator() - b.getNumerator() * a.getDenominator(), a.getDenominator() * b.getDenominator());
    }
    
    public static Rational multiply(Rational a, Rational b){
        return new Rational(a.getNumerator() * b.getNumerator(), a.getDenominator() * b.getDenominator());
    }
    
    public static Rational divide(Rational a, Rational b){
        return new Rational(a.getNumerator() * b.getDenominator(), a.getDenominator() * b.getNumerator());
    }
}
