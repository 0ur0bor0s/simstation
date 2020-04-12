package plague;

/*
 * Edit history:
 *   Ben Foley, 04/05: created
 */

import mvc.Model;
import mvc.View;
import simstation.Simulation;
import simstation.SimulationFactory;

public class PlagueFactory extends SimulationFactory {
    @Override
    public Model makeModel() {
        PlagueSimulation plagueSim = new PlagueSimulation();
        plagueSim.populate();
        return plagueSim;
    }

    public View getView(Model m) {
        PlagueSimulation s = (PlagueSimulation) m;
        return new PlagueView(s);
    }
}