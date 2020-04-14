package Flocking;

import simstation.*;

public class Bird extends Agent 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Integer POPULATION = 50;
	public static Integer NEIGHBOR_RANGE = 40;
	public static Integer MAX_SPEED = 20;
	public static Integer MIN_SPEED = 5;
	
	private int speed;
	
	public Bird(Simulation sim, String name, int speed)
	{
		super(name, sim);
		this.speed = speed;
		this.heading = Heading.getRandomDirection();
	}
	
	public void update()
	{
		Bird neighbor = (Bird)simulation.getNeighbor(this, NEIGHBOR_RANGE);
		
		if(neighbor != null) {
			this.speed = neighbor.speed;
			this.heading = neighbor.heading;
		}
		super.move(speed);
		
		this.simulation.changed();
	}
}
