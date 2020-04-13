package walker;


import mvc.Utilities;
import plague.PlagueSimulation;
import simstation.*;
import java.lang.Math.*;

public class Drunk extends Agent{
	 private int speed;
	 
	public Drunk(Simulation simulation, String name, Heading heading) {
        super(simulation, name, heading);
        this.speed = Utilities.rng.nextInt(10)+1;
    }
	/*
	 * return speeed
	 */
	public int getSpeed() {
        return this.speed;
    }
	@Override
	public void update() {
		
		/*
		 * move in the random direciotn and speed
		 */
		int randInt = Utilities.rng.nextInt(4);
        switch (randInt) {
            case 0: setHeading(Heading.NORTH); break;
            case 1: setHeading(Heading.EAST); break;
            case 2: setHeading(Heading.SOUTH); break;
            case 3: setHeading(Heading.WEST); break;
        }
        this.speed = Utilities.rng.nextInt(10)+1;
		this.move(speed);
		
	}

}
