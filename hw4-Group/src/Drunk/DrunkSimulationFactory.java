package Drunk;

/*
 * 4/2 Created Drunk Simulation Factory using Parent constructors - Singh
 */

import mvc.*;
import simstation.*;

public class DrunkSimulationFactory extends SimulationFactory
{
	public DrunkSimulationFactory()
	{
		super();
	}
	
	public Model makeModel()
	{
		return new DrunkSimulation();
	}
}
