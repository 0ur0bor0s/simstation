package prison;

import mvc.Model;
import mvc.View;
import plague.PlagueSimulation;
import plague.PlagueView;
import simstation.SimulationFactory;

public class PrisonFactory extends SimulationFactory {
	
	public String getTitle() { return "Prison Sim Station"; }
	@Override
	public Model makeModel() {
		PrisonSimulation prisonSim = new PrisonSimulation();
		prisonSim.populate();
		return prisonSim;
	}
	/*
	 * return view for the simulation
	 */
	public View getView(Model m) {
        PrisonSimulation s = (PrisonSimulation) m;
        return new PrisonView(s);
    }
}
