package plague;

/*
 * Edit history:
 *   Ben Foley, 04/05: created
 */

import mvc.Utilities;
import simstation.Heading;
import simstation.Simulation;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
    private static final int NUM_PEOPLE = 50;

    @Override
    public void populate() {
        for (int i=1; i<NUM_PEOPLE; i++) {
            String name = "Person " + i;
            Heading heading = Heading.NORTH;
            int randInt = Utilities.rng.nextInt(4);
            switch (randInt) {
                case 0: heading = Heading.NORTH; break;
                case 1: heading = Heading.EAST; break;
                case 2: heading = Heading.SOUTH; break;
                case 3: heading = Heading.WEST; break;
            }
            // infect first agent
            if (i == 1) {
                Person newPerson = new Person(this, name, heading);
                newPerson.setInfected(true);
                this.agents.add(newPerson);
            } else {
                Person newPerson = new Person(this, name, heading);
                this.agents.add(newPerson);
            }
        }
    }
}