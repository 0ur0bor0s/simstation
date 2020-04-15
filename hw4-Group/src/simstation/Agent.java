package simstation;

import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

/*
 * Edit history:
 *   Quang-Duy, 03/30: created constructors, getters, checking, suspend, stop, start, resume, update, move, run and join methods
 *   Quang-Duy, 03/31: added comments, out of bounce checking and handling methods, and improved the methods above
 *   Quang-Duy, 04/13: finalized everything such as deleting old code, add global variables, ...
*/

public abstract class Agent implements Serializable, Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Integer WORLD_SIZE = 250; // height & width of the world (& view)
	public static Integer AGENT_SIZE = 5;
	
	transient private Thread thread;
	
	protected Simulation simulation;
	private String name;
	private AgentState state;
	protected Heading heading;
	private int xCordinate;
	private int yCordinate;
	
	/**
	 * Default constructor
	 * Set the name to the name of the agent (birds, bees, shoppers, ...)
	 * Set the initial heading to north
	 * Set the random location to an agent
	 * @param name the name of the agent
	 */
	public Agent(String name, Simulation sim)
	{
		this.simulation = sim;
		this.name = name;
		this.heading = Heading.getRandomDirection();
		this.state = null;
		
		Random gen = new Random();
		this.xCordinate = gen.nextInt(WORLD_SIZE + 1);
		this.yCordinate = gen.nextInt(WORLD_SIZE + 1);
	}
	
			/****** Getter functions ******/
	public Integer getX() { return this.xCordinate; }
	
	public Integer getY() { return this.yCordinate; }
	
	public Heading getHeading() { return this.heading; }
	
	public Simulation getSimulation() { return this.simulation; }
	
			/****** Setter functions ******/
	public void setHeading(Heading heading) { this.heading = heading; }
	
	/**
	 * Get the state of an agent
	 * @return the state of an agent
	 */
	synchronized public AgentState getState() { 
		return this.state; 
	}
	
	/**
	 * Check if the state of an agent is STOPPED
	 * @return true if the state is STOPPED, false otherwise
	 */
	synchronized public boolean isStopped() { 
		return this.state == AgentState.STOPPED; 
	}
	
	/**
	 * Check if the state of an agent is SUSPENDED
	 * @return true if the state if SUSPENDED, false otherwise
	 */
	synchronized public boolean isSuspended() { 
		return this.state == AgentState.SUSPENDED; 
	}
	
	/**
	 * Set the state of an agent to SUSPENDED
	 */
	synchronized public void suspend() { 
		this.state = AgentState.SUSPENDED; 
	}
	
	/**
	 * Set the state of an agent to STOPPED
	 */
	synchronized public void stop() { 
		this.state = AgentState.STOPPED; 
	}
	
	/**
	 * Set the state of an agent to READY
	 * Start the clock in the simulation class
	 * Start and run the thread
	 */
	synchronized public void start()
	{
		state = AgentState.READY;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * Set the state of an agent to READY
	 * Notify the thread that the state has changed from SUSPENDED to READY
	 */
	synchronized public void resume()
	{
		if (!isStopped()) {
			state = AgentState.READY;
			notify();
		}
	}
	
	/**
	 * Updating the status of the program, override in sub-class
	 */
	public abstract void update();
	
	/**
	 * Move the agent a number of steps
	 * @param steps number of steps input by user?!?
	 */
	public void move(int steps)
	{
		switch(heading)
		{
		case SOUTH: this.yCordinate += steps;
					break;
					
		case EAST:  this.xCordinate += steps;
					break;
					
		case WEST:  this.xCordinate -= steps;
					break;
		
		case NORTH: this.yCordinate -= steps;
					break;
					
		default:	break;
		}
		
		if(isOutOfBound())
		{
			outOfBoundHandling(steps);
		}
	}
	
	/**
	 * Helper function to check if the agent's position is outside of the frame
	 * @return
	 */
	public boolean isOutOfBound() 
	{
		if(this.xCordinate < SimulationView.RECTANGLE_X_CORDINATE || 
				this.xCordinate > WORLD_SIZE + SimulationView.RECTANGLE_X_CORDINATE)
			return true;
		else if(this.yCordinate < SimulationView.RECTANGLE_Y_CORDINATE || 
				this.yCordinate > WORLD_SIZE + SimulationView.RECTANGLE_Y_CORDINATE)
			return true;
		
		return false;
	}
	
	/**
	 * Helper function to bring the agent to the opposite side if it moves out of the frame
	 * @param steps numbers of steps the agent moves; from user's input?!?
	 */
	public void outOfBoundHandling(int steps)
	{
		// Number of loop is 1 if steps < WORLD_SIZE
		int numberOfLoop = 1;
		
		// If steps > WORLD_SIZE, find out how many loops of the WORLD_SIZE the turtle have to go
		if(steps > WORLD_SIZE)
			numberOfLoop = steps / WORLD_SIZE;

		
		if (this.yCordinate > (WORLD_SIZE + SimulationView.RECTANGLE_X_CORDINATE))
		{
			this.yCordinate -= (WORLD_SIZE * numberOfLoop);
		}
		else if (this.yCordinate < SimulationView.RECTANGLE_Y_CORDINATE) 
		{
			this.yCordinate += (WORLD_SIZE * numberOfLoop);
		}
		else if (this.xCordinate > (WORLD_SIZE + SimulationView.RECTANGLE_X_CORDINATE))
		{
			this.xCordinate -= (WORLD_SIZE * numberOfLoop);
		}
		else if(this.xCordinate < SimulationView.RECTANGLE_X_CORDINATE)
		{
			this.xCordinate += (WORLD_SIZE * numberOfLoop);
		}
	}

	/**
	 * Override the run method of the Runnable interface
	 * Repeatedly calls the abstract update method
	 */
	@Override
	public void run() {
		thread = Thread.currentThread();
		while(!isStopped()) {
			state = AgentState.RUNNING;
			update();
			simulation.changed();
			try {
				Thread.sleep(100);
				synchronized(this) {
					while(isSuspended()) { wait(); }
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public void join() throws InterruptedException {
		if (thread != null) 
			thread.join();
	}
}
