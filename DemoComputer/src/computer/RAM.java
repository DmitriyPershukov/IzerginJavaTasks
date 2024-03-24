package computer;

public class RAM {
    private String name;
    
    private int sizeGB;

    public RAM(String name, int sizeGB) {
        this.name = name;
        this.sizeGB = sizeGB;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String newName){
        this.name = newName;
    }

    public int getSizeGB() {
        return sizeGB;
    }

    public void setSizeGB(int sizeGB) {
        this.sizeGB = sizeGB;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if(other != null && other.getClass() == this.getClass()){
            return this.name.equals(((RAM)other).getName());
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
