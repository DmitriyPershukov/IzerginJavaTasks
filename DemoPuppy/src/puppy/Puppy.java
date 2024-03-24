package puppy;

public class Puppy extends Dog{
    public Puppy(String name){
        super(name);
    }
    
    @Override
    public boolean equals(Object other){
        if (this == other){
            return true;
        }
        if(other != null && other.getClass() == this.getClass()){
            return this.getName().equals(((Puppy)other).getName());
        } else{
            return false;
        }
    }
}
