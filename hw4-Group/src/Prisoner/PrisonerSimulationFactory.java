package Prisoner;

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
