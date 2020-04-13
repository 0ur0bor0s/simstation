package simstation;

/*
 * Edit history:
 *   Quang-Duy, 03/30: created and completed all the buttons as well as the layout of the buttons
 *   Ben Foley, 04/05: few minor edits
*/

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import flocking.FlockingFactory;
import mvc.*;
import plague.PlagueFactory;
import plague.PlagueSimulation;
import plague.PlagueView;
import prison.*;
import walker.*;

public class SimulationPanel extends AppPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JButton start;
	private final JButton suspend;
	private final JButton resume;
	private final JButton stop;
	private final JButton stats;
	
	public SimulationPanel(AppFactory factory) {
		super(factory);
		SimulationView view = new SimulationView((Simulation)model);
		// Custom plague view
		//SimulationView view = new PlagueView((PlagueSimulation)model);

		this.setLayout(new GridLayout(1, 2));
		
		this.start = new JButton("Start");
		this.start.addActionListener(this);
		
		this.suspend = new JButton("Suspend");
		this.suspend.addActionListener(this);
		
		this.resume = new JButton("Resume");
		this.resume.addActionListener(this);
		
		this.stop = new JButton("Stop");
		this.stop.addActionListener(this);
		
		this.stats = new JButton("Stats");
		this.stats.addActionListener(this);
		
		JPanel mathPanel = new JPanel();
		mathPanel.setLayout(new GridLayout(5, 1));
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.add(start);
		mathPanel.add(panel);
		
		panel = new JPanel();
		panel.add(suspend);
		mathPanel.add(panel);
		
		panel = new JPanel();
		panel.add(resume);
		mathPanel.add(panel);
		
		panel = new JPanel();
		panel.add(stop);
		mathPanel.add(panel);
		
		panel = new JPanel();
		panel.add(stats);
		mathPanel.add(panel);
		
		buttonPanel.add(mathPanel, "North");
		this.add(buttonPanel, "West");
		this.add(view, "East");
	}
	
	public static void main(String[] args) {
		//walker
		AppPanel panel = new SimulationPanel(new DrunkFactory());
		//prison
		//AppPanel panel = new SimulationPanel(new PrisonFactory());
		// flocking
		//AppPanel panel = new SimulationPanel(new FlockingFactory());
		// Plague
		//AppPanel panel = new SimulationPanel(new PlagueFactory());
		panel.display();
	}
}