package state;

import java.util.Arrays;
import java.util.List;

public class State {
    private String name;
    private City capital;
    private List<Oblast> oblasts;
    
    public State(String name){
        this.name = name;
    }
    
    public State(String name, City capital){
        this.name = name;
        this.capital = capital;
    }
    
    public State(String name, City capital, Oblast... oblasts){
        this.name = name;
        this.capital = capital;
        this.oblasts = Arrays.asList(oblasts);
    }
    
    public void addOblast(Oblast oblast){
        if(!this.oblasts.contains(oblast)){
            this.oblasts.add(oblast);
        } else{
            throw new java.lang.IllegalArgumentException("State already contains this oblast.");
        }
    }
    
    public List<Oblast> getOblasts(){
        return List.copyOf(this.oblasts);
    }
    
    public boolean removeOblast(Oblast oblast){
        return this.oblasts.remove(oblast);
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setCapital(City newCapital){
        this.capital = newCapital;
    }
    
    public City getCapital(){
        return this.capital;
    }
    
    @Override
    public boolean equals(Object other){
        if (this == other){
            return true;
        }
        if(other != null && other.getClass() == this.getClass()){
            return this.name.equals(((State)other).getName());
        } else{
            return false;
        }
    }
    
    public int getArea(){
        return this.oblasts.stream().mapToInt(Oblast::getArea).sum();
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
    @Override
    public int hashCode(){
        return this.name.hashCode();
    }
       
    public void printCapital(){
        System.out.println("Столица: " + this.capital);
    }
    
    public void printNumberOfOblasts(){
        System.out.println("Количество областей: " + this.oblasts.size());
    }
        
    public void printArea(){
        System.out.println("Площадь: " + getArea());
    }
        
    public void printOblastsAdministrativeCenters(){
        System.out.println("Областные центры:");
        for (Oblast oblast: this.oblasts){
            System.out.println(oblast.getAdministrativeCenter().getName());
        } 
    }
}
