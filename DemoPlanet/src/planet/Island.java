package planet;

public class Island {
    private String name;

    public Island(String name) {
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
            return this.name.equals(((Island)other).getName());
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
}
