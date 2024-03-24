package starsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Planet {
    private String name;
    private List<Moon> moons;
    
    public Planet(String name){
        this.name = name;
        this.moons = new ArrayList<>();
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public String getName(){
        return this.name;
    }
    
        public void setMoons(Moon... moons){
        this.moons = new ArrayList<>(Arrays.asList(moons));
    }
    
    public void addMoon(Moon moon){
        if(!this.moons.contains(moon)){
            this.moons.add(moon);
        } 
    }
    
    public boolean removeMoon(Moon moon){
        return this.moons.remove(moon);
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if(other != null && other.getClass() == this.getClass()){
            return this.name.equals(((Planet)other).getName());
        } else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
