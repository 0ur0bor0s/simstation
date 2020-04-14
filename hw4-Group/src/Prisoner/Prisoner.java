package Prisoner;

import simstation.*;

public class Prisoner extends Agent 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Integer NEIGHBOR_RANGE = 20;
	public static Integer MAX_SPEED = 20;
	public static Integer MIN_SPEED = 5;

	CooperationStrat strategy;
	private boolean isCooperated;
	private int speed;
	private boolean isLastOpponentCooperated;
	private int fitness;

	public Prisoner(Simulation sim, String name, int speed, CooperationStrat strategy)
	{
		super(name, sim);
		this.fitness = 0;
		this.speed = speed;
		this.isLastOpponentCooperated = false;
		this.heading = Heading.getRandomDirection();
		this.strategy = strategy;
		this.isCooperated = cooperate();
	}

	@Override
	public void update()
	{
		Prisoner neighbor = (Prisoner)simulation.getNeighbor(this, NEIGHBOR_RANGE);
		this.isCooperated = strategy.cooperate(this.isLastOpponentCooperated);

		if(neighbor != null) {
			if(neighbor.isCooperated == false && this.isCooperated == false) //both cheating
			{
				this.fitness++;
				this.isLastOpponentCooperated = false;
			}
			else if(neighbor.isCooperated == true && this.isCooperated == false) //one cheat one cooperate
			{
				this.fitness += 5;
				this.isLastOpponentCooperated = true;
			}
			else if(neighbor.isCooperated == false && this.isCooperated == true) //one cheat one cooperate
			{
				neighbor.fitness += 5;
				this.isLastOpponentCooperated = false;
			}
			else if(neighbor.isCooperated == true && this.isCooperated == true) //both cooperating
			{
				this.fitness += 3;
				this.isLastOpponentCooperated = true;
			}
		}
		/*
		if(this.isCooperated)
		{
			if(neighbor.isCooperated) {
				this.fitness += 3;
				neighbor.fitness += 3;
			} else {
				neighbor.fitness += 5;
			}
		} 
		else 
		{
			if(neighbor.isCooperated) {
				neighbor.fitness += 5;
			} else {
				this.fitness += 1;
				neighbor.fitness += 1;
			}
		}
		 */

		this.heading = Heading.getRandomDirection();
		super.move(this.speed);
		this.simulation.changed();
	}

	public boolean cooperate() {
		return strategy.cooperate(this.isLastOpponentCooperated);
	}

	public CooperationStrat getStrat() { return this.strategy; }

	public boolean isCooperated() { return this.isCooperated; }

	public int getFitness() { return this.fitness; }
}
