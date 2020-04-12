package flocking;

import mvc.Utilities;
import simstation.*;
import java.lang.Math.*;

/*
 * Edit history:
 *   Ben Foley, 04/05: created
 */

public class Bird extends Agent {
    private int speed;
    private static final double UPDATE_RADIUS = 1.0;

    /**
     * Default constructor
     * Set the name to the name of the agent (birds, bees, shoppers, ...)
     * Set the initial heading to north
     * Set the random location to an agent
     *
     * @param name the name of the agent
     */
    public Bird(FlockingSimulation simulation, String name, Heading heading) {
        super(simulation, name, heading);
        // speed value from 1-100
        this.speed = Utilities.rng.nextInt(10)+1;
    }

    public int getSpeed() {
        return this.speed;
    }

    @Override
    public synchronized void update() {
        // check radius
        FlockingSimulation currentSim = (FlockingSimulation) this.getSimulation();
        for (Agent agent : currentSim.getAgents()) {
            // calculate distance
            double distance = Math.sqrt((agent.getX()-this.getX())^2+(agent.getY()-this.getY())^2);
            if (distance <= UPDATE_RADIUS) {
                this.setHeading(agent.getHeading());
                Bird bird = (Bird) agent;
                this.speed = bird.getSpeed();
            }
        }
        // update place
        this.move(speed);
    }
}
