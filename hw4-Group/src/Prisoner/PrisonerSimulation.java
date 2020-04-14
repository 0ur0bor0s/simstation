package Prisoner;

import java.util.Random;

import Plague.Corona;
import simstation.*;

public class PrisonerSimulation extends Simulation 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static Integer CLOCK_TICK_POP_UP = 100;
	
	public PrisonerSimulation() {
		super();
		notificationPopUp(true, CLOCK_TICK_POP_UP);
	}
	
	@Override
	public void populate()
	{
		Random ran = new Random();
		for(int i = 0; i < 10; i++)
		{
			this.agents.add(new Prisoner(this, "Prisoner", ran.nextInt(Prisoner.MAX_SPEED + 1) + Prisoner.MIN_SPEED, new AlwaysCheatStrat()));
		}
		
		for(int i = 0; i < 10; i++)
		{
			this.agents.add(new Prisoner(this, "Prisoner", ran.nextInt(Prisoner.MAX_SPEED + 1) + Prisoner.MIN_SPEED, new AlwaysCoopStrat()));
		}
		
		for(int i = 0; i < 10; i++)
		{
			this.agents.add(new Prisoner(this, "Prisoner", ran.nextInt(Prisoner.MAX_SPEED + 1) + Prisoner.MIN_SPEED, new LastOpCoopStrat()));
		}
		
		for(int i = 0; i < 10; i++)
		{
			this.agents.add(new Prisoner(this, "Prisoner", ran.nextInt(Prisoner.MAX_SPEED + 1) + Prisoner.MIN_SPEED, new RandomStrat()));
		}
	}
	
	public double getAverageFitness(CooperationStrat strat) 
	{
		int totalFitness = 0;
		int count = 0;
		
		for(int i = 0; i < this.agents.size(); i++)
		{
			Prisoner prisoner = (Prisoner)this.agents.get(i);
			if(prisoner.getStrat().getClass() == strat.getClass())
			{
				totalFitness += prisoner.getFitness();
				count++;
			}
			
		}
		
		if(count != 0)
			return totalFitness / count;
		else 
			return -1;
	}
	
	/**
	 * Get the stats of the agents
	 */
	@Override
	public String[] getStats() 
	{	
		String[] stats = new String[6];
		stats[0] = "#agents = " + this.agents.size();
		stats[1] = "clock = " + this.clock;
		stats[2] = "Average fitness for cheater's strategy = " + getAverageFitness(new AlwaysCheatStrat());
		stats[3] = "Average fitness for cooperator's strategy = " + getAverageFitness(new AlwaysCoopStrat());
		stats[4] = "Average fitness for random's strategy = " + getAverageFitness(new RandomStrat());
		stats[5] = "Average fitness for reciprocator's strategy = " + getAverageFitness(new LastOpCoopStrat());
		return stats;
	}
	
	
}
