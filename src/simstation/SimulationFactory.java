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
		return new String[]{"start", "suspend", "resume", "stop"};
	}

	public Command makeEditCommand(Model model, String type) {
		if (type == "start") return new StartCommand(model);
		if (type == "stop") return new StopCommand(model);
		if (type == "suspend") return new SuspendCommand(model);
		if (type == "resume") return new ResumeCommand(model);
		return null;
	}

	public String getTitle() { return "Sim Station"; }

	public String[] getHelp() {
		return  new String[]{"start: starts simulation", "suspend: suspends simulation", "resume: resumes simulation", "stop: stops simulation"};
	}

	public String about() { return "Sim Station version version 1.0. Copyright 2020 by Quang-Duy Tran, Ben Foley and Anmol Deep Singh"; }

}