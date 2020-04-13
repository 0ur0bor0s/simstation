package flocking;

/*
 * Edit history:
 *   Ben Foley, 04/05: created
 */

import mvc.Model;
import simstation.SimulationFactory;

public class FlockingFactory extends SimulationFactory {
    @Override
    public Model makeModel() {
        FlockingSimulation flockSim = new FlockingSimulation();
        flockSim.populate();
        return flockSim;
    }
}
