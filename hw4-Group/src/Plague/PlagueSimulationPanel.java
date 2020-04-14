package Plague;

import mvc.*;
import simstation.*;

public class PlagueSimulationPanel extends SimulationPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlagueSimulationPanel(SimFactory factory)
	{
		super(factory);
	}
	
	public static void main(String[] args) {
		SimFactory factory = new PlagueSimulationFactory();
		SimulationPanel panel = new SimulationPanel(factory);
		panel.display();
	}
}
