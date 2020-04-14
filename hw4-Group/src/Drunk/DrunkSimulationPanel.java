package Drunk;

import mvc.*;
import simstation.*;

public class DrunkSimulationPanel extends SimulationPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrunkSimulationPanel(SimFactory factory)
	{
		super(factory);
		
	}
	
	public static void main(String[] args) {
		SimFactory factory = new DrunkSimulationFactory();
		SimulationPanel panel = new DrunkSimulationPanel(factory);
		panel.display();
	}
}
