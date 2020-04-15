package Prisoner;

/*
 * 4/2 Created PrisonerSimulationFactory Constructor and Class - Anmol Singh
 */

import mvc.*;
import simstation.*;

public class PrisonerSimulationFactory extends SimulationFactory
{
	public PrisonerSimulationFactory()
	{
		super();
	}
	
	public Model makeModel()
	{
		return new PrisonerSimulation();
	}
}
