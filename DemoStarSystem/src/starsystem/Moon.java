package starsystem;

public class Moon{
    private String name;
    
    public Moon(String name){
        this.name = name;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public String getName(){
        return this.name;
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if(other != null && other.getClass() == this.getClass()){
            return this.name.equals(((Moon)other).getName());
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
