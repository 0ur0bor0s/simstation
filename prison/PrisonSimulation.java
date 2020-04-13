package prison;

import java.awt.Color;

import mvc.Utilities;
import plague.Person;
import simstation.Agent;
import simstation.Heading;
import simstation.Simulation;

public class PrisonSimulation extends Simulation  {

	public static int NUM_PEOPLE = 10;
	public void stop() {
		runStop();
		super.stop();
	}

	public void runStop() 
	{
		
		//At the end of the program random walk
		
		//intialize random direction
		for (Agent agent : agents) {
			int randHead = Utilities.rng.nextInt(4);
			switch (randHead) {
			case 0: agent.setHeading(Heading.NORTH); break;
			case 1: agent.setHeading(Heading.EAST); break;
			case 2: agent.setHeading(Heading.SOUTH); break;
			case 3: agent.setHeading(Heading.WEST); break;
			}
			randHead = Utilities.rng.nextInt(25);
			agent.move(randHead);
			agent.stop();
		}
		this.stopTimer();
	}

	public void populate() {
		int xcoor = 115;
		int ycoor = 20;
		boolean right = false;
		/*
		 * intialize random location and random strategy
		 */
		for (int i=1; i<= NUM_PEOPLE; i++) {
			String name = "Prisoner " + i;
			Heading heading = Heading.NORTH;
			Strategy input = Strategy.FOLLOW;

			int randInt = Utilities.rng.nextInt(4);
			switch (randInt) {
			case 0: heading = Heading.NORTH; 
			input = Strategy.ALWAYSCHEAT;
			break;
			case 1: heading = Heading.EAST; 
			input = Strategy.ALWAYSCOOP;
			break;
			case 2: heading = Heading.SOUTH; 
			input = Strategy.FOLLOW;
			break;
			case 3: heading = Heading.WEST; 
			input = Strategy.RANDOM;
			break;
			}
			Prisoner newPrisoner = new Prisoner(this, name, heading);
			newPrisoner.setStrategy(input);
			//this.agents.add(newPrisoner);
			
			/* 
			 * format location to allow cell format 
			 */
			if(right == true) {
				right = false;
				newPrisoner.setX(xcoor);
			}
			else if(right == false) {
				right = true;
				newPrisoner.setX(xcoor+50);
			}
			newPrisoner.setY(ycoor);
			this.agents.add(newPrisoner);
			if(i%2 == 0) {
				ycoor+= 50;
			}
			
			
		}// end of constructing prisoners


		

	}
	@Override
	public void stats() {
		String[] stats = new String[5];
		//stats[0] = "#Prisoner = " + this.agents.size();
		
		int acheat, acoop, arandom, afollow;
		acheat = acoop = arandom = afollow = 0;
		int cheatfit, coopfit, randomfit, followfit;
		cheatfit = coopfit = randomfit = followfit =0;
		int current = 0;
		for (Agent agent : this.getAgents()) {
			Prisoner p  = (Prisoner) agent;
			current = p.getFit();
			
			switch(p.getStrategy()) {
			case ALWAYSCHEAT: cheatfit += current;
								acheat++;
								break;
			case ALWAYSCOOP: coopfit += current;
								acoop++;
								break;
			case RANDOM:  randomfit+= current;
							arandom++;
							break;
			case FOLLOW: followfit += current;
							afollow++;
							break;
			}
		}
		if(afollow==0) {
			afollow =1;
		}
		double cheatResult = cheatfit/acheat;
		double coopResult = coopfit/acoop;
		double followResult = followfit/afollow;
		double randomResult = randomfit/arandom;
		
		stats[0] = "# of Cheater "+ acheat +" Avg Fitness: "+cheatResult;
		stats[1] = "# of Cooperators "+ acoop +" Avg Fitness: "+coopResult;
		stats[2] = "# of Random "+ arandom +" Avg Fitness: "+randomResult;
		stats[3] = "# of Follower "+ afollow +" Avg Fitness: "+followResult;
		stats[4] = "clock = " + this.clock;
		Utilities.inform(stats);
	}
}
