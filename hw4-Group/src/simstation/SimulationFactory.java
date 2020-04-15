package simstation;

/*
 * Edit history:
 *   Quang-Duy, 03/30: created
 *   Quang-Duy, 04/12: added getView method
*/

import mvc.*;

public class SimulationFactory implements SimFactory {

	public Model makeModel() { return new Simulation(); }

	public String[] getEditCommands() {
		return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};
	}

	public Command makeEditCommand(Model model, String type) {
		if (type == "Start") return new StartCommand(model);
		else if (type == "Stop") return new StopCommand(model);
		else if (type == "Suspend") return new SuspendCommand(model);
		else if (type == "Resume") return new ResumeCommand(model);
		else if (type == "Stats") return new StatsCommand(model);
		return null;
	}

	public String getTitle() { return "Sim Station"; }

	public String[] getHelp() {
		return  new String[]{"Start: starts simulation", "Suspend: suspends simulation", "Resume: resumes simulation", "Stop: stops simulation"};
	}

	public String about() { return "Sim Station version version 1.0. Copyright 2020 by Quang-Duy Tran, Ben Foley and Anmol Deep Singh"; }

	@Override
	public View getView(Model model) {
		return new SimulationView(model);
	}

}