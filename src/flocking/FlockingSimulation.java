package flocking;

/*
 * Edit history:
 *   Ben Foley, 04/05: created
 */

import mvc.Utilities;
import simstation.Heading;
import simstation.Simulation;

public class FlockingSimulation extends Simulation {
    private static final int NUM_BIRDS = 50;

    @Override
    public void populate() {
        for (int i=1; i<=NUM_BIRDS; i++) {
            String name = "Bird " + i;
            Heading heading = Heading.NORTH;
            int randInt = Utilities.rng.nextInt(4);
            switch (randInt) {
                case 0: heading = Heading.NORTH; break;
                case 1: heading = Heading.EAST; break;
                case 2: heading = Heading.SOUTH; break;
                case 3: heading = Heading.WEST; break;
            }
            Bird newBird = new Bird(this, name, heading);
            this.agents.add(newBird);
        }
    }
}
