package vector;

public class VectorActions {
    public static double dotProduct(Vector a, Vector b){
        if(a.getLength() != b.getLength()){
            throw new java.lang.IllegalArgumentException("Vector should be of the same size");
        }
        double sum = 0;
        for(int i = 0; i < a.getLength(); i++){
            sum += a.getElement(i) * b.getElement(i);
        }
        return sum;
    }
    
    public static Vector subtract(Vector a, Vector b){
        if(a.getLength() != b.getLength()){
            throw new java.lang.IllegalArgumentException("Vector should be of the same size");
        }
        double[] differenceElements = new double[a.getLength()];
        for(int i = 0; i < a.getLength(); i++){
            differenceElements[i] = a.getElement(i) - b.getElement(i);
        }
        return new Vector(differenceElements);
    }
    
    public static Vector add(Vector a, Vector b){
        if(a.getLength() != b.getLength()){
            throw new java.lang.IllegalArgumentException("Vector should be of the same size");
        }
        double[] sumElements = new double[a.getLength()];
        for(int i = 0; i < a.getLength(); i++){
            sumElements[i] = a.getElement(i) + b.getElement(i);
        }
        return new Vector(sumElements);
    }
    
    public static Vector multiplyByScalar(Vector vector, double scalar){
        double[] productElements = new double[vector.getLength()];
        for(int i = 0; i < vector.getLength(); i++){
            productElements[i] = vector.getElement(i) * scalar;
        }
        return new Vector(productElements);
    }

    public static boolean areVectorsСollinear(Vector a, Vector b){
        if(a.getLength() != b.getLength()){
            throw new java.lang.IllegalArgumentException("Vector should be of the same size");
        }
        if(a.getLength() == 0){
            return true;
        }
        double coefficient = 0;
        boolean coefficientSet = false;
        for(int i = 0; i < a.getLength(); i++){
            if(a.getElement(i) < 0.0001 && b.getElement(i) < 0.0001){
                continue;
            }
            else if(a.getElement(i) < 0.0001){
                return false;
            }
            else if(b.getElement(i) < 0.0001){
                return false;
            } else{
                if(coefficientSet){
                    double newCoefficient = a.getElement(i) / b.getElement(i);
                    if(Math.abs(newCoefficient - coefficient) < 0.0001){
                        coefficient = newCoefficient;
                    } else{
                        return false;
                    }
                } else{
                    coefficient = a.getElement(i) / b.getElement(i);
                }
            }
        }
        return true;
    }
    
    public static boolean areVectorsOrthogonal(Vector a, Vector b){
        return VectorActions.dotProduct(a, b) < 0.0001;
    }
}
