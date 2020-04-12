package plague;

/*
 * Edit history:
 *   Ben Foley, 04/05: created
 */

import mvc.Utilities;
import simstation.Heading;
import simstation.Simulation;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 5; // % chance of infection
    public static int RESISTANCE = 0; // % chance of resisting infection
    private static final int NUM_PEOPLE = 50;

    @Override
    public void populate() {
        for (int i=1; i<=NUM_PEOPLE; i++) {
            String name = "Person " + i;
            Heading heading = Heading.NORTH;
            int randInt = Utilities.rng.nextInt(4);
            switch (randInt) {
                case 0: heading = Heading.NORTH; break;
                case 1: heading = Heading.EAST; break;
                case 2: heading = Heading.SOUTH; break;
                case 3: heading = Heading.WEST; break;
            }
            Person newPerson = new Person(this, name, heading);
            this.agents.add(newPerson);
        }
    }
}