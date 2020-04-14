package Flocking;

import java.util.Random;
import simstation.*;

public class FlockingSimulation extends Simulation 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public FlockingSimulation() {
		super();
	}
	
	@Override
	public void populate()
	{
		Random ran = new Random();
		for(int i = 0; i < Bird.POPULATION; i++)
		{
			this.agents.add(new Bird(this, "Bird " + (i+1), ran.nextInt(Bird.MAX_SPEED + 1) + Bird.MIN_SPEED));
		}
	}
}
