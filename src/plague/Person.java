package plague;

import mvc.Utilities;
import simstation.*;
import java.lang.Math.*;

/*
 * Edit history:
 *   Ben Foley, 04/05: created
 */

public class Person extends Agent {
    private boolean isInfected;

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

    @Override
    public synchronized void update() {
        if (!isInfected) {
            // calculate if person will be infected or not
            int infectCalc = Utilities.rng.nextInt(100);
            PlagueSimulation plagueSim = (PlagueSimulation) this.getSimulation();

            // calculate if person is Infected
            if (infectCalc < PlagueSimulation.VIRULENCE) {
                // calculate if person resist infection or not
                int resistCalc = Utilities.rng.nextInt(100);
                if (resistCalc >= PlagueSimulation.RESISTANCE) {
                    this.isInfected = true;
                }
            }
        }
        //this.move(speed);
    }
}