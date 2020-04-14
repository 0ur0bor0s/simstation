package Plague;

import java.util.Random;
import simstation.*;

public class PlagueSimulation extends Simulation 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlagueSimulation() {
		super();
	}
	
	@Override
	public void populate()
	{
		Random ran = new Random();
		for(int i = 0; i < Corona.POPULATION; i++)
		{
			this.agents.add(new Corona(this, "Bird", ran.nextInt(Corona.MAX_SPEED) + Corona.MIN_SPEED));
		}
	}
	
	/**
	 * Get the stats of the agents
	 */
	@Override
	public String[] getStats() {
		double count = 0;
		for(int i = 0; i < this.agents.size(); i++) {
			Corona agent = (Corona)this.agents.get(i);
			if(agent.isInfected())
				count++;
		}
		
		String[] stats = new String[3];
		stats[0] = "#agents = " + this.agents.size();
		stats[1] = "clock = " + this.clock;
		stats[2] = "% infected = " + Math.floor((count/this.agents.size())*100);
		return stats;
	}
}
