package Prisoner;

/*
 * 4/2 Created Class and Constructor - Anmol Singh
 * 4/5 added main method in PrisonSimulationPanel to test functionanilty - Anmol Singh
 */

import mvc.*;
import simstation.*;

public class PrisonerSimulationPanel extends SimulationPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrisonerSimulationPanel(SimFactory factory)
	{
		super(factory);
	}
	
	public static void main(String[] args) {
		SimFactory factory = new PrisonerSimulationFactory();
		SimulationPanel panel = new SimulationPanel(factory);
		panel.display();
	}
}
