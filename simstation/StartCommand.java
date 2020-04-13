package simstation;

/*
 * Edit history:
 *   Quang-Duy, 03/30: created
*/

import mvc.*;

public class StartCommand extends Command {

	public StartCommand(Model model) {
		super(model);
	}

	public void execute() {
		if (model != null && model instanceof Simulation) {
			Simulation sim = (Simulation)model;
			sim.start();
		}
	}
}
