package demopuppy;

import puppy.Animal;
import puppy.Dog;
import puppy.Puppy;

public class DemoPuppy {

    public static void main(String[] args) {
       Puppy puppy = new Puppy("Джош");
       puppy.printName();
       puppy.bite();
       puppy.bark();
       puppy.run();
       puppy.jump();
    } 
}
