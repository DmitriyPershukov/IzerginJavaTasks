package demostarsystem;

import starsystem.Moon;
import starsystem.Planet;
import starsystem.Star;
import starsystem.StarSystem;

public class DemoStarSystem {

    public static void main(String[] args) {
        Planet p1 = new Planet("Земля");
        Planet p2 = new Planet("Марс");
        Planet p3 = new Planet("Венера");
        Planet p4 = new Planet("Меркурий");
        Star s = new Star("Солнце");
        Moon m1 = new Moon("Луна");
        p1.addMoon(m1);
        StarSystem starSystem = new StarSystem("Солнечная система", s, p1, p2, p3);
        starSystem.addPlanet(p4);
        starSystem.printName();
        starSystem.printPlanetNumber();
    }
    
}
