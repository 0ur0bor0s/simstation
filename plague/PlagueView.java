package plague;

import mvc.Model;
import simstation.Agent;
import simstation.Simulation;
import simstation.SimulationView;

import java.awt.*;

public class PlagueView extends SimulationView {

    public PlagueView(Simulation simulation) {
        super(simulation);
    }

    @Override
    public void paintComponent(Graphics gc) {
        Graphics2D g2 = (Graphics2D) gc;
        Simulation simulation = (Simulation)model;
        Color oldColor = gc.getColor();

        g2.setStroke(new BasicStroke(3));
        g2.drawRect(RECTANGLE_X_CORDINATE, RECTANGLE_Y_CORDINATE, Agent.WORLD_SIZE, Agent.WORLD_SIZE);
        g2.setStroke(new BasicStroke());

        for (Agent agent : simulation.getAgents()) {
            Person person = (Person) agent;
            // GREEN if infected, else RED
            if (person.getIsInfected()) {
                g2.setColor(Color.GREEN);
            } else {
                g2.setColor(Color.RED);
            }
            g2.fillRect(person.getX(), person.getY(), Agent.AGENT_SIZE, Agent.AGENT_SIZE);
        }

        g2.setColor(oldColor);
    }
}
