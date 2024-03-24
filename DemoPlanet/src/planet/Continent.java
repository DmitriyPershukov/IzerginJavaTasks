package planet;

public class Continent {
    private String name;

    public Continent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String newName){
        this.name = newName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if(other != null && other.getClass() == this.getClass()){
            return this.name.equals(((Continent)other).getName());
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
        System.out.println("Материк: " + this.name);
    }
}