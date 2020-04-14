package Flocking;

import mvc.*;
import simstation.*;

public class FlockingSimulationPanel extends SimulationPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FlockingSimulationPanel(SimFactory factory)
	{
		super(factory);
		
	}
	
	public static void main(String[] args) {
		SimFactory factory = new FlockingSimulationFactory();
		SimulationPanel panel = new SimulationPanel(factory);
		panel.display();
	}
}
