package starsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StarSystem {
    private String name;
    private List<Planet> planets;
    private List<Star> stars;
    
    public StarSystem(String name){
        this.name = name;
        this.stars = new ArrayList<>();
        this.planets = new ArrayList<>();
    }
    
    public StarSystem(String name, Star star){
        this.name = name;
        this.stars = new ArrayList<>();
        this.stars.add(star);
        this.planets = new ArrayList<>();
    }
    
    public StarSystem(String name, Star star, Planet... planets){
        this.name = name;
        this.stars = new ArrayList<>();
        this.stars.add(star);
        setPlanets(planets);
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public String getName(){
        return this.name;
    }
    
    final public void setPlanets(Planet... planets){
        this.planets = new ArrayList<>(Arrays.asList(planets));
    }
    
    public void addPlanet(Planet planet){
        if(!this.planets.contains(planet)){
            this.planets.add(planet);
        } 
    }
    
    public boolean removePlanet(Planet planet){
        return this.planets.remove(planet);
    }
    
    public void setStars(Star... stars){
        this.stars = new ArrayList<>(Arrays.asList(stars));
    }
    
    public void addStar(Star star){
        if(!this.stars.contains(star)){
            this.stars.add(star);
        } 
    }
    
    public boolean removeStar(Star star){
        return this.stars.remove(star);
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if(other != null && other.getClass() == this.getClass()){
            return this.name.equals(((StarSystem)other).getName());
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
    
    public void printPlanetNumber(){
        System.out.println("Количество планет: " + this.planets.size());
    }
    
    public void printName(){
        System.out.println(this.name);
    }
}
