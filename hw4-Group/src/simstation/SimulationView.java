package simstation;

/*
 * Edit history:
 *   Quang-Duy, 03/30: created
 *   Quang-Duy, 03/31: added drawing the rectangle and the agents
 *   Quang-Duy, 04/13: finalized everything such as deleting old code, add global variables, ...
*/

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import mvc.*;

public class SimulationView extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Integer RECTANGLE_X_CORDINATE = 10; // In case if we want to move the frame, this keeps the turtle stay in its world
	public static Integer RECTANGLE_Y_CORDINATE = 10; // In case if we want to move the boundary, this keeps the turtle stay in its world
	
	public SimulationView(Model model) {
		super(model);
	}
	
	public void paintComponent(Graphics gc) 
	{
		Graphics2D g2 = (Graphics2D) gc;
		Simulation simulation = (Simulation)model;
		Color oldColor = gc.getColor();
		
		g2.setColor(Color.RED);
		for(int i = 0; i < simulation.getAgents().size(); i++)
		{
			g2.fillOval(simulation.getAgents().get(i).getX(), simulation.getAgents().get(i).getY(), 
					Agent.AGENT_SIZE, Agent.AGENT_SIZE);
		}
		
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(3));
		g2.drawRect(RECTANGLE_X_CORDINATE, RECTANGLE_Y_CORDINATE, Agent.WORLD_SIZE + Agent.AGENT_SIZE/2, Agent.WORLD_SIZE + Agent.AGENT_SIZE/2);
		
		//Reset the stroke back to default
		g2.setStroke(new BasicStroke());
		//Reset the color back to default
		g2.setColor(oldColor);
	}
}