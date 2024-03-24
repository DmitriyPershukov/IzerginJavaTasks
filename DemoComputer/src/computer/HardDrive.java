package computer;

public class HardDrive {
    private String name;
    private int sizeGB = 0;

    public HardDrive(String name, int sizeGB) {
        this.name = name;
        this.sizeGB = sizeGB;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String newName){
        this.name = newName;
    }
    
    public void setSizeGB(int sizeGB){
        this.sizeGB = sizeGB;
    }
    
    public int getSizeGB(){
        return this.sizeGB;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other){
            return true;
        }
        if(other != null && other.getClass() == this.getClass()){
            return this.name.equals(((HardDrive)other).getName());
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
    
    public boolean virusCheck(){
        return false;
    }
    
    public void printSize(){
        System.out.println("Размер жесткого диска " + this.sizeGB + " ГБ.");
    }
}
