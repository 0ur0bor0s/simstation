package simstation;

/*
 * Edit history:
 *   Quang-Duy, 03/30: created
*/

import mvc.*;

public class ResumeCommand extends Command {

	public ResumeCommand(Model model) {
		super(model);
	}

	public void execute() {
		if (model != null && model instanceof Simulation) {
			Simulation sim = (Simulation)model;
			sim.resume();
		}
	}
}
