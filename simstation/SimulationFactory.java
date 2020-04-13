package simstation;

/*
 * Edit history:
 *   Quang-Duy, 03/30: created and completed 
*/

import mvc.*;

public class SimulationFactory implements AppFactory {

	public Model makeModel() { return new Simulation(); }

	/* Don't really know what this do
	public AppPanel makePanel(Model model, ActionListener listener) {
		return new SimulationPanel((Simulation)model, listener);
	}
	*/
	
	public String[] getEditCommands() {
		return new String[]{"Start", "Suspend", "Resume", "Stop","Stats"};
	}

	public Command makeEditCommand(Model model, String type) {
		switch (type) {
			case "Start": return new StartCommand(model);
			case "Stop": return new StopCommand(model);
			case "Suspend": return new SuspendCommand(model);
			case "Resume": return new ResumeCommand(model);
			case "Stats" : return new StatsCommand(model);
			default: return null;
		}
	}

	public String getTitle() { return "Sim Station"; }

	public String[] getHelp() {
		return  new String[]{"start: starts simulation", "suspend: suspends simulation", "resume: resumes simulation", "stop: stops simulation"};
		}
	
	public String about() { return "Sim Station version version 1.0. Copyright 2020 by Quang-Duy Tran, Ben Foley and Anmol Deep Singh"; }

}