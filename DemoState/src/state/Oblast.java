package state;

import java.util.ArrayList;
import java.util.Arrays;

public class Oblast {
    private String name;
    private City administrativeCenter;
    private ArrayList<District> districts;
    
    public Oblast(String name){
        this.name = name;
    }
    
    public Oblast(String name, City administrativeCenter){
        this.name = name;
        this.administrativeCenter = administrativeCenter;
    }
    
    public Oblast(String name, City administrativeCenter, District... cities){
        this.name = name;
        this.administrativeCenter = administrativeCenter;
        this.districts = new ArrayList<>(Arrays.asList(cities));
    }
    
    public void addDistrict(District district){
        if(!this.districts.contains(district)){
            this.districts.add(district);
        } else{
            throw new java.lang.IllegalArgumentException("Oblast already contains this district.");
        }
    }
    
    public ArrayList<District> getDistricts(){
        return (ArrayList<District>)this.districts.clone();
    }
    
    public boolean removeDistrict(District district){
        return this.districts.remove(district);
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
    
    public int getArea(){
        return this.districts.stream().mapToInt(District::getArea).sum();
    }
    
    @Override
    public boolean equals(Object other){
        if(other instanceof Oblast){
            return this.name.equals(((Oblast)other).getName());
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
