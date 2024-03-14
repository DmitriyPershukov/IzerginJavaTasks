package vector;

public class Vector {
    private double[] elements;
    
    public Vector(double[] values){
        this.elements = new double[values.length];
        System.arraycopy(values, 0, this.elements, 0, values.length);
    }
    
    public static Vector createVectorFromValues(double... values){
        return new Vector(values);
    }
    
    public double getModule(){
        double module = 0;
        for(int i = 0; i < elements.length; i++){
            module += elements[i]*elements[i];
        }
        return Math.sqrt(module);
    }
    
    public double getElement(int index){
        return elements[index];
    }
    
    public int getLength(){
        return elements.length;
    }
    
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < elements.length; i++){
            stringBuilder.append(elements[i]);
            if(i != elements.length - 1){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
