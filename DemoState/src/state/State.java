package state;

import java.util.ArrayList;
import java.util.Arrays;

public class State {
    private String name;
    private City capital;
    private ArrayList<Oblast> oblasts;
    
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
        this.oblasts = new ArrayList<>(Arrays.asList(oblasts));
    }
    
    public void addOblast(Oblast oblast){
        if(!this.oblasts.contains(oblast)){
            this.oblasts.add(oblast);
        } else{
            throw new java.lang.IllegalArgumentException("State already contains this oblast.");
        }
    }
    
    public ArrayList<Oblast> getOblasts(){
        return (ArrayList<Oblast>)this.oblasts.clone();
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
        if(other instanceof State){
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
    
    public void printInfo(){
        System.out.println("Столица: " + this.capital);
        System.out.println("Количество областей: " + this.oblasts.size());
        System.out.println("Площадь: " + getArea());
        System.out.println("Областные центры:");
        for (Oblast oblast: this.oblasts){
            System.out.println(oblast.getAdministrativeCenter().getName());
        }
    }
}
