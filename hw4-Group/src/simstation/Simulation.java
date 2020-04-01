package simstation;

/*
 * Edit history:
 *   Quang-Duy, 03/30: created constructors, getters, start, stop, suspend, resume and stats methods
 *   Quang-Duy, 03/31: added comments and improved the methods above
*/

import java.util.ArrayList;

/*
 * Edit history:
 *   Quang-Duy, 03/30: created
*/

import mvc.*;

public class Simulation extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Agent> agents;
	protected String name;
	protected Long clock;
	
	/**
	 * Default constructor
	 * Set the empty array list to variable agents
	 * Set the name to "Simulation"
	 * Set the clock to zero
	 * @param name "Simulation"
	 */
	public Simulation(String name) {
		agents = new ArrayList<>();
		this.name = name;
		clock = 0l;
	}

	/**
	 * Passed the name "Simulation" to the default constructor
	 */
	public Simulation() { this("Simulation"); }

	/* Don't know what this is. Assuming this is a copy constructor
	public void copy(Model other) {
		super.copy(other);
		state = ((Simulation)other).state;
		clock = ((Simulation)other).clock;
		changed();
		setUnsavedChanges(false);
	}
	*/
	
	/****** Getter functions ******/
	public ArrayList<Agent> getAgents() {
		return this.agents;
	}
	
	synchronized public Long getClock() { 
		return this.clock; 
	}
	
	synchronized public String getName() { 
		return this.name; 
	}

	/**
	 * Set the clock to zero and call the start method of agents
	 */
	public void start() 
	{
		this.clock = 0l;
		
		for(int i = 0; i < agents.size(); i++)
		{
			this.agents.get(i).start();
		}
	}
	
	/**
	 * Call the stop method of agents
	 */
	public void stop() 
	{
		for(int i = 0; i < agents.size(); i++) {
			this.agents.get(i).stop();
		}
	}
	
	/**
	 * Call the suspend method of agents
	 */
	public void suspend()
	{
		for(int i = 0; i < agents.size(); i++) {
			this.agents.get(i).suspend();
		}
	}
	
	/**
	 * Call the resume method of agents
	 */
	public void resume() 
	{
		for(int i = 0; i < agents.size(); i++) {
			this.agents.get(i).resume();
		}
	}
	
	/**
	 * Print the stats of the agents
	 */
	public void stats() {
		String[] stats = new String[2];
		stats[0] = "#agents = " + this.agents.size();
		stats[1] = "clock = " + this.clock;
		Utilities.inform(stats);
	}
}


