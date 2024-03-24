package demoplanet;

import planet.Continent;
import planet.Island;
import planet.Ocean;
import planet.Planet;
        
public class DemoPlanet {

    public static void main(String[] args) {
        Ocean o1 = new Ocean("Атлантический океан");
        Island i1 = new Island("Мадагаскар");
        Continent c1 = new Continent("Северная Америка");
        Continent c2 = new Continent("Евразия");
        Continent c3 = new Continent("Южная Америка");
        Planet p1 = new Planet("Земля");
        p1.setOceans(o1);
        p1.setIslands(i1);
        p1.setContinents(c1, c2);
        p1.addContinent(c3);
        p1.printName();
        p1.printNumberOfContinents();
        c1.printName();
        c2.printName();
        c3.printName();
    }
    
}
