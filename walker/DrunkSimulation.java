package walker;

import flocking.Bird;
import mvc.Utilities;
import simstation.Heading;
import simstation.Simulation;

public class DrunkSimulation extends Simulation {
	private static final int NUM_DRUNKS = 50;

    @Override
    public void populate() {
        for (int i=1; i<=NUM_DRUNKS; i++) {
            String name = "Drunk " + i;
            Heading heading = Heading.NORTH;
            int randInt = Utilities.rng.nextInt(4);
            switch (randInt) {
                case 0: heading = Heading.NORTH; break;
                case 1: heading = Heading.EAST; break;
                case 2: heading = Heading.SOUTH; break;
                case 3: heading = Heading.WEST; break;
            }
            Drunk d = new Drunk(this, name, heading);
            this.agents.add(d);
        }
    }

}
