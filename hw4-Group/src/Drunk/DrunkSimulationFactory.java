package Drunk;

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
