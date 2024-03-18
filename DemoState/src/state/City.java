package state;

public class City {
    private String name;
    
    public City(String name){
        this.name = name;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public String getName(){
        return this.name;
    }
    
    @Override
    public boolean equals(Object other){
        if(other instanceof City){
            return this.name.equals(((City)other).getName());
        } else{
            return false;
        }
    }
    
    @Override
    public int hashCode(){
        return this.name.hashCode();
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
