package prison;

import mvc.Utilities;
import simstation.*;
//import java.lang.Math.*;

public class Prisoner extends Agent {
	/*
	 * fitness to hold fitness values 
	 */
	private int fitness;
	private Strategy strat;
	public Prisoner(Simulation simulation, String name, Heading heading) {
		super(simulation, name, heading);
		fitness = 0;
		this.strat = Strategy.FOLLOW;
		// TODO Auto-generated constructor stub
	}
	public Prisoner(Simulation simulation, String name, Heading heading, Strategy input) {
		super(simulation, name, heading);
		fitness = 0;
		setStrategy(input);
	}
	public int getFit() {
		return this.fitness;
	}
	public void setX(int input) {
		this.xCordinate = input;
	}
	public void setY(int input) {
		this.yCordinate = input;
	}
	
	public void incFitness(int input) {
		this.fitness +=  input;
	}
	public Strategy getStrategy() {
		
		if(this.strat == Strategy.FOLLOW) {
			int location = this.getSimulation().getAgents().indexOf(this);
			if(location == 0) {
				return Strategy.ALWAYSCOOP;
			}
			else {
				Prisoner p = (Prisoner)this.getSimulation().getAgents().get(location-1);
				return p.getStrategy();
			}
		}
		return this.strat;
	}
	public void setStrategy(Strategy input) {
		this.strat = input;
	}
	public String toString() {
		String output = "Name: "+ this.name +"  Fitness: "+this.fitness;
		return output;
	}
	public boolean cooperate() {
		
		//Strategy test = this.strat;
		
		switch(getStrategy()) {
		case ALWAYSCHEAT: return false; 
		case ALWAYSCOOP: return true;
		case RANDOM: return Utilities.rng.nextBoolean(); 
		case FOLLOW: return false; 
		default: return true;
		}
		
	}
	// etc.
	@Override
	public void update() {
		int numppl = 10;
		
		PrisonSimulation sim = (PrisonSimulation)this.getSimulation();
		
		for(int i = 1; i < 10; i++) {
			 Prisoner p = (Prisoner)(sim.getAgents().get(i));
			 Prisoner p2 = (Prisoner)(sim.getAgents().get(i-1));
			 if(p.cooperate() == p2.cooperate() == true) {
			// if both decide to cooperate
				 p.incFitness(3);
				 p2.incFitness(3);
			 }
			 // if both decide to cheat
			 else if(p.cooperate()==p2.cooperate()== false) {
				 p.incFitness(1);
				 p2.incFitness(1);
			 }
			 // if one of them cheats
			 else if( (p2.cooperate()!=p.cooperate()) ){
				 if(p.cooperate()) {
					 p.incFitness(5);
				 }
				 else {
					 p2.incFitness(5);
				 }
			 }
		}
		
		// TODO Auto-generated method stub
		
	}
}
