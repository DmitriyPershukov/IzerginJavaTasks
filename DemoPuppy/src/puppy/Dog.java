package puppy;

public class Dog extends Animal{
    public Dog(String name){
        super(name);
    }
    
    @Override
    public boolean equals(Object other){
        if (this == other){
            return true;
        }
        if(other != null && other.getClass() == this.getClass()){
            return this.getName().equals(((Animal)other).getName());
        } else{
            return false;
        }
    }
    
    public void printName(){
        System.out.println(this.getName());
    }
    
    public void bark(){
        System.out.println(this.getName() + " гавкает.");
    }
    
    public void jump(){
        System.out.println(this.getName() + " прыгает.");
    }
    
    public void run(){
        System.out.println(this.getName() + " бегает.");
    }
    
    public void bite(){
        System.out.println(this.getName() + " кусает.");
    }
}
