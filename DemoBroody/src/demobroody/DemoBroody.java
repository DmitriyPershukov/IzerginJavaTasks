package demobroody;

import bird.Broody;
import bird.Sparrow;

public class DemoBroody {

    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow("Suzan");
        Broody sparrowBroody = new Broody<Sparrow>(sparrow);
        ((Sparrow)sparrowBroody.getBird()).fly();
        ((Sparrow)sparrowBroody.getBird()).sing();
        sparrowBroody.layEggs();
        sparrowBroody.incubateEggs();
    }   
}
