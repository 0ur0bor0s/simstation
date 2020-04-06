package flocking;

import simstation.*;

/*
 * Edit history:
 *   Ben Foley, 04/05: created
 */

public class Bird extends Agent {
    private int speed;

    /**
     * Default constructor
     * Set the name to the name of the agent (birds, bees, shoppers, ...)
     * Set the initial heading to north
     * Set the random location to an agent
     *
     * @param name the name of the agent
     */
    public Bird(String name) {
        super(name);
    }

    @Override
    public void update() {

    }
}
