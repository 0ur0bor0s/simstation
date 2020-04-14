package Flocking;

import mvc.*;
import simstation.*;

public class FlockingSimulationFactory extends SimulationFactory
{
	public FlockingSimulationFactory()
	{
		super();
	}
	
	public Model makeModel()
	{
		return new FlockingSimulation();
	}
}
