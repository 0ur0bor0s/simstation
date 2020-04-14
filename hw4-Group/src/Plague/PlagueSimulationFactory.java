package Plague;

import mvc.*;
import simstation.*;

public class PlagueSimulationFactory extends SimulationFactory
{
	public PlagueSimulationFactory()
	{
		super();
	}
	
	public Model makeModel()
	{
		return new PlagueSimulation();
	}
	
	public View getView(Model model) 
	{
		return new PlagueView(model);
	}
}
