package Plague;

import mvc.Utilities;
import simstation.*;

public class Corona extends Agent 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int VIRULENCE = 50; // % chance of infection
	public static int RESISTANCE = 2; // % chance of resisting infection
	public static Integer NEIGHBOR_RANGE = 10;
	public static Integer MAX_SPEED = 20;
	public static Integer MIN_SPEED = 5;
	public static Integer POPULATION = 50;

	private boolean isInfected;
	private int speed;

	public Corona(Simulation sim, String name, int speed)
	{
		super(name, sim);

		if(Utilities.rng.nextInt(50) + 1 < 5) //New agent has 10% of being infected initially
			this.isInfected = true;
		else
			this.isInfected = false;
		this.heading = Heading.getRandomDirection();
		this.speed = speed;
	}

	@Override
	public void update()
	{
		Corona neighbor = (Corona)simulation.getNeighbor(this, NEIGHBOR_RANGE);
		if(neighbor != null) {
			if(neighbor.isInfected == true)
			{
				if(Utilities.rng.nextInt(101) >= VIRULENCE)
				{
					this.isInfected = true;

					if(this.isInfected == true)
					{
						if(Utilities.rng.nextInt(101) < RESISTANCE)
							this.isInfected = false;
					}
				}
			}
		}
		super.setHeading(Heading.getRandomDirection());
		super.move(this.speed);
		this.simulation.changed();
	}


	public boolean isInfected() { return this.isInfected; }
}