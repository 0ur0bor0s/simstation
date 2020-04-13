package walker;

import mvc.Model;
import simstation.SimulationFactory;

public class DrunkFactory extends SimulationFactory {
	
	public String getTitle() { return "Drunk Walker Sim Station"; }
	/*
	 * create model that 
	 */
	public Model makeModel() {
		DrunkSimulation sim = new DrunkSimulation();
		sim.populate();
		return sim;
	}
}
