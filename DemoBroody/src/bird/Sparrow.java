package bird;

public class Sparrow extends Bird{
    public Sparrow(String name){
        super(name);
    }
    
    public void fly(){
        System.out.println(super.getName() + " flies.");
    }
    
    public void sing(){
        System.out.println(super.getName() + " sings.");
    }
}
