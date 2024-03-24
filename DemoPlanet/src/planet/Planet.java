package planet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Planet {
    private String name;
    private List<Ocean> oceans;
    private List<Island> islands;
    private List<Continent> continents;

    public Planet(String name) {
        this.name = name;
        oceans = new ArrayList<Ocean>();
        islands = new ArrayList<Island>();
        continents = new ArrayList<Continent>();
    }

    public String getName() {
        return name;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public void setOceans(Ocean... oceans){
        this.oceans = new ArrayList<>(Arrays.asList(oceans));
    }
    
    public void addOcean(Ocean ocean){
        if(this.oceans.contains(ocean)){
            throw new java.lang.IllegalArgumentException("Plant already contains this ocean");
        }
        this.oceans.add(ocean);
    }
    
    public List<Ocean> getOceans(){
        return List.copyOf(this.oceans);
    }
    
    public boolean removeOcean(Ocean ocean){
        return this.oceans.remove(ocean);
    }
    
    public void setIslands(Island... islands){
        this.islands = new ArrayList<>(Arrays.asList(islands));
    }
    
    public void addIsland(Island island){
        if(this.islands.contains(island)){
            throw new java.lang.IllegalArgumentException("Plant already contains this island");
        }
        this.islands.add(island);
    }
    
    public List<Island> getIslands(){
        return List.copyOf(this.islands);
    }
    
    public boolean removeIsland(Island island){
        return this.islands.remove(island);
    }
    
    public void setContinents(Continent... continents){
        this.continents = new ArrayList<>(Arrays.asList(continents));
    }
    
    public void addContinent(Continent continent){
        if(this.continents.contains(continent)){
            throw new java.lang.IllegalArgumentException("Plant already contains this continent");
        }
        this.continents.add(continent);
    }
    
    public List<Continent> getContinents(){
        return List.copyOf(this.continents);
    }
    
    public boolean removeContinent(Continent continent){
        return this.continents.remove(continent);
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
    public String toString() {
        return this.name;
    }
    
    public void printName(){
        System.out.println("Планета: " + this.name);
    }
    
    public void printNumberOfContinents(){
        System.out.println("Количество материков: " + getContinents().size());
    }
}
