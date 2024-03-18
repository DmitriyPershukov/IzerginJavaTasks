package state;

import java.util.ArrayList;
import java.util.Arrays;

public class District {
    private String name;
    private City administrativeCenter;
    private ArrayList<City> cities;
    private int area;
    
    public District(String name){
        this.name = name;
    }
    
    public District(String name, City administrativeCenter){
        this.name = name;
        this.administrativeCenter = administrativeCenter;
        cities.add(administrativeCenter);
    }
    
    public District(String name, City administrativeCenter, City... cities){
        this.name = name;
        this.administrativeCenter = administrativeCenter;
        this.cities = new ArrayList<>(Arrays.asList(cities));
        if(!this.cities.contains(this.administrativeCenter)){
            this.cities.add(administrativeCenter);
        }
    }
    
    public District(String name, City administrativeCenter, int area, City... cities){
        this.name = name;
        this.administrativeCenter = administrativeCenter;
        this.area = area;
        this.cities = new ArrayList<>(Arrays.asList(cities));
        if(!this.cities.contains(this.administrativeCenter)){
            this.cities.add(administrativeCenter);
        }
    }
    
    public void setArea(int newArea){
        this.area = newArea;
    }
    
    public int getArea(){
        return this.area;
    }
    
    public void addCity(City city){
        if(!this.cities.contains(city)){
            this.cities.add(city);
        } else{
            throw new java.lang.IllegalArgumentException("District already contains this city.");
        }
    }
    
    public ArrayList<City> getCities(){
        return (ArrayList<City>)this.cities.clone();
    }
    
    public boolean removeCity(City city){
        return this.cities.remove(city);
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setAdministrativeCenter(City newAdministrativeCenter){
        this.administrativeCenter = newAdministrativeCenter;
    }
    
    public City getAdministrativeCenter(){
        return this.administrativeCenter;
    }
    
    @Override
    public boolean equals(Object other){
        if(other instanceof District){
            return this.name.equals(((District)other).getName());
        } else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
    @Override
    public int hashCode(){
        return this.name.hashCode();
    }
}
