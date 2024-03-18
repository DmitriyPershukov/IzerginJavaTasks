package demostate;

import state.City;
import state.District;
import state.Oblast;
import state.State;

public class DemoState {
    public static void main(String[] args) {
        City c1 = new City("Челябинск");
        City c2 = new City("Магнитогорск");
        City c3 = new City("Москва");
        District d1 = new District("Челябинский округ", c1, 56);
        District d2 = new District("Магнитогорский округ", c2, 34);
        District d3 = new District("Московский округ", c3, 67);
        Oblast o1 = new Oblast("Челябинская область", c1, d1, d2);
        Oblast o2 = new Oblast("Московская область", c3, d3);
        State s1 = new State("Россия", c3, o1, o2);
        s1.printInfo();
    }   
}
