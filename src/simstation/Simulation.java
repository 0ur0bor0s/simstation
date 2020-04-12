package simstation;

/*
 * Edit history:
 *   Quang-Duy, 03/30: created constructors, getters, start, stop, suspend, resume and stats methods
 *   Quang-Duy, 03/31: added comments and improved the methods above
*/

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/*
 * Edit history:
 *   Quang-Duy, 03/30: created
 *   Ben Foley, 04/05: added empty populate method
*/

import mvc.*;

public class Simulation extends Model {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected ArrayList<Agent> agents;
	protected String name;
	protected Long clock;

	private Timer timer;

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
		clock = 0L;
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
		//this.clock = 0L;

		for (Agent agent : agents) {
			agent.start();
		}

		this.startTimer();
	}
	
	/**
	 * Call the stop method of agents
	 */
	public void stop() 
	{
		for (Agent agent : agents) {
			agent.stop();
		}
		this.stopTimer();
	}
	
	/**
	 * Call the suspend method of agents
	 */
	public void suspend()
	{
		for (Agent agent : agents) {
			agent.suspend();
		}
		//this.stopTimer();
	}
	
	/**
	 * Call the resume method of agents
	 */
	public void resume() 
	{
		for (Agent agent : agents) {
			agent.resume();
		}
		//this.startTimer();
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

	/**
	 * To be implemented by subclasses
	 */
	public void populate() {}

	private void startTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
	}

	private void stopTimer() {
		timer.cancel();
		timer.purge();
	}

	private class ClockUpdater extends TimerTask {
		public void run() {
			clock++;
			//changed();
		}
	}

}


