package Drunk;

/*
 * 4/2 Created Person class, adding Constructor 
 * 4/3 Added Update - Anmol Singh
 */

/*
 * Edit history:
 *   Anmol, 04/02: created constructors, and update method
 */

import mvc.Utilities;
import simstation.*;

public class Person extends Agent 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Integer POPULATION = 50;
	public static Integer MAX_SPEED = 10;
	public static Integer MIN_SPEED = 2;
	
	public Person(Simulation sim, String name)
	{
		super(name, sim);
		this.heading = Heading.getRandomDirection();
	}
	
	public void update()
	{
		this.heading = Heading.getRandomDirection();
		super.move(Utilities.rng.nextInt(MAX_SPEED + 1) + MIN_SPEED);
		this.simulation.changed();
	}
}
