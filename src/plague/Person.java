package plague;

import flocking.Bird;
import flocking.FlockingSimulation;
import mvc.Utilities;
import simstation.*;
import java.lang.Math.*;

/*
 * Edit history:
 *   Ben Foley, 04/05: created
 */

public class Person extends Agent {
    private boolean isInfected;
    private static final double UPDATE_RADIUS = 5;

    /**
     * Default constructor
     * Set the name to the name of the agent (birds, bees, shoppers, ...)
     * Set the initial heading to north
     * Set the random location to an agent
     *
     * @param name the name of the agent
     */
    public Person(PlagueSimulation simulation, String name, Heading heading) {
        super(simulation, name, heading);
        // speed value from 1-100
        this.isInfected = false;
    }

    public boolean getIsInfected() {
        return this.isInfected;
    }

    public void setInfected(boolean b) {
        this.isInfected = b;
    }

    @Override
    public synchronized void update() {
        // NOT INFECTED, check radius for infected agents
        if (!isInfected) {
            PlagueSimulation currentSim = (PlagueSimulation) this.getSimulation();
            for (Agent agent : currentSim.getAgents()) {
                Person otherPerson = (Person) agent;
                // if other agent is infected, check if they are within radius of infection
                if (otherPerson.isInfected) {
                    double distance = Math.sqrt((otherPerson.getX() - this.getX()) ^ 2 + (otherPerson.getY() - this.getY()) ^ 2);
                    // run infection calculation
                    if (distance <= UPDATE_RADIUS) {
                        int infectCalc = Utilities.rng.nextInt(100);
                        // calculate if person is Infected by nearby agent
                        if (infectCalc < PlagueSimulation.VIRULENCE) {
                            // calculate if person resist infection or not
                            this.isInfected = true;
                        }
                    }
                }
            }
        } else {
            // INFECTED, determine whether agent is cured or not
            int cureCalc = Utilities.rng.nextInt(100);
            if (cureCalc < PlagueSimulation.RESISTANCE) {
                // person if cured
                this.isInfected = false;
            }
        }
        // update place and move randomize heading
        this.move(5);
        int randHead = Utilities.rng.nextInt(4);
        switch (randHead) {
            case 0: this.setHeading(Heading.NORTH); break;
            case 1: this.setHeading(Heading.EAST); break;
            case 2: this.setHeading(Heading.SOUTH); break;
            case 3: this.setHeading(Heading.WEST); break;
        }
    }
}