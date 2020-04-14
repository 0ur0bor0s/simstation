package Drunk;

import simstation.*;

public class DrunkSimulation extends Simulation 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrunkSimulation() {
		super();
	}
	
	@Override
	public void populate()
	{
		for(int i = 0; i < Person.POPULATION; i++)
		{
			this.agents.add(new Person(this, "Person " + (i+1) ));
		}
	}
}
