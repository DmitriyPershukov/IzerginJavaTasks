package rational;

public class Rational {
    private int numenator;
    private int denominator;
    
    public Rational(int numerator, int denominator){
        this.numenator = numerator;
        setDenominator(denominator);
        normalize();
    }
    
    public Rational(int numerator){
        this.numenator = numerator;
        setDenominator(1);
        normalize();
    }
    
    static int greatestCommonDenominator(int a, int b){
        while(b!=0){
            var t = b;
            b = a % b;
            a = t;
        }
        return Math.abs(a);
    }
    
    public int getNumerator(){
        return this.numenator;
    }
    
    void normalize(){
        var tmp = greatestCommonDenominator(this.numenator, this.denominator);
        if(tmp > 1){
            this.numenator /= tmp;
            this.denominator /= tmp;
        }
    }
    
    public int getDenominator(){
        return this.denominator;
    }
    
    public void setNumebator(int numerator){
        this.numenator = numerator;
        normalize();
    }
    
    public void setDenominator(int denominator){
        if(denominator == 0){
            throw new IllegalArgumentException("Denumenator must not be zero");
        }
        this.denominator = denominator;
        normalize();
    }
    
    @Override
    public String toString(){
        if(this.denominator == 1){
            return this.numenator + "";
        }
        else{
            return this.numenator + "/" + this.denominator;
        }
    }
}
