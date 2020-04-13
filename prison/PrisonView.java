package prison;

import mvc.Model;
import mvc.Utilities;
//import plague.Person;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationView;

import java.awt.*;

public class PrisonView extends SimulationView {

	public static int NUM_PEOPLE = 10;
	
    public PrisonView(Simulation simulation) {
        super(simulation);
    }
    
    public void paintComponent(Graphics gc) {
    
    	 Graphics2D g2 = (Graphics2D) gc;
         PrisonSimulation simulation = (PrisonSimulation)model;
         Color oldColor = gc.getColor();
         
         g2.setStroke(new BasicStroke(3));
         g2.drawRect(RECTANGLE_X_CORDINATE, RECTANGLE_Y_CORDINATE, Agent.WORLD_SIZE, Agent.WORLD_SIZE);
         g2.setStroke(new BasicStroke());
         
         for (Agent agent : simulation.getAgents()) {
             Prisoner p  = (Prisoner) agent;
            
            switch(p.getStrategy()) {
     		case ALWAYSCHEAT: g2.setColor(Color.RED); break;
     		case ALWAYSCOOP: g2.setColor(Color.GREEN); break;
     		case RANDOM: if(p.cooperate()== true) {
     							g2.setColor(Color.GREEN);
     						}
     						else {
     							g2.setColor(Color.RED);
     						}
     					break;
     		case FOLLOW: g2.setColor(Color.BLACK); break;
     		}
     		
           // g2.setColor(Color.GREEN);
            g2.fillRect(p.getX(), p.getY(), Agent.AGENT_SIZE, Agent.AGENT_SIZE);
         }

         g2.setColor(oldColor);
    }
    
}
