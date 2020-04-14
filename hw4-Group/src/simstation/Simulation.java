package simstation;

/*
 * Edit history:
 *   Quang-Duy, 03/30: created constructors, getters, start, stop, suspend, resume and stats methods
 *   Quang-Duy, 03/31: added comments and improved the methods above
 *   Quang-Duy, 10/04: fixed the clock from simulation to 
 */

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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

	protected ArrayList<Agent> agents;
	private Timer timer;
	protected String name;
	protected Integer clock;
	private boolean notifyStats;
	private int popUpStatsTimer;

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
		clock = 0;
		timer = new Timer();
		this.notifyStats = false;
	}

	/**
	 * Passed the name "Simulation" to the default constructor
	 */
	public Simulation() { this("Simulation"); }

	/****** Getter functions ******/
	public ArrayList<Agent> getAgents() {
		return this.agents;
	}

	synchronized public Integer getClock() { 
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
		if(!this.agents.isEmpty())
			this.agents.clear();

		if(timer != null)
			timer.cancel();

		this.clock = 0;
		startTimer();

		populate();

		for(int i = 0; i < agents.size(); i++)
		{
			this.agents.get(i).start();
		}
		changed();
	}


	/**
	 * Call the stop method of agents
	 */
	public void stop() 
	{
		for(int i = 0; i < agents.size(); i++) {
			this.agents.get(i).stop();
		}
		stopTimer();
	}

	/**
	 * Call the suspend method of agents
	 */
	public void suspend()
	{
		if(this.agents.get(0).getState() == AgentState.STOPPED)
		{
			Utilities.error("Simulation has stopped");
			return;
		}

		stopTimer();
		for(int i = 0; i < agents.size(); i++) {
			this.agents.get(i).suspend();
		}
	}

	/**
	 * Call the resume method of agents
	 */
	public void resume() 
	{
		if(this.agents.get(0).getState() == AgentState.STOPPED)
		{
			Utilities.error("Simulation has stopped");
			return;
		}

		if(timer != null)
			timer.cancel();

		startTimer();
		for(int i = 0; i < agents.size(); i++) {
			this.agents.get(i).resume();
		}
	}

	/**
	 * Get the stats of the agents
	 */
	public String[] getStats() {
		String[] stats = new String[2];
		stats[0] = "#agents = " + this.agents.size();
		stats[1] = "clock = " + this.clock;
		return stats;
	}

	public void populate() {}

	/**
	 * Get the neighbor of an agent. If there is no neighbor, return null
	 * @param agent the agent
	 * @param range the qualified range to be a neighbor
	 * @return the neighbor or itself
	 */
	synchronized public Agent getNeighbor(Agent agent, int range)
	{
		for(int i = 0; i < this.agents.size(); i++)
		{
			if(agent != agents.get(i)) {
				if(getDistance(agent, this.agents.get(i)) < range)
					return this.agents.get(i);
			}
		}
		return null;
	}

	/**
	 * Get the distance between two agents
	 * @param agent1 the first agent
	 * @param agent2 the second agent
	 * @return the distance between two agents
	 */
	private double getDistance(Agent agent1, Agent agent2)
	{
		double x = agent1.getX() - agent2.getX();
		double y = agent1.getY() - agent2.getY();

		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	private void startTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new ClockUpdater(), 1000l, 1000l);
	}

	private void stopTimer() {
		timer.cancel();
		timer.purge();
	}

	private class ClockUpdater extends TimerTask {
		public void run() {
			clock++;
			if(notifyStats) {
				if(clock % popUpStatsTimer == 0) {
					Utilities.inform(getStats());
				}
			}
			//changed();
		}
	}

	public void notificationPopUp(boolean notifyStats, int popUpStatsTimer) {
		this.notifyStats = notifyStats;
		this.popUpStatsTimer = popUpStatsTimer;
	}
}


