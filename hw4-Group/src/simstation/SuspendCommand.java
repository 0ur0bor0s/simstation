package simstation;

/*
 * Edit history:
 *   Quang-Duy, 03/30: created
*/

import mvc.*;

public class SuspendCommand extends Command {
	public SuspendCommand(Model model) { super(model); }
	
	public void execute() {
		if (model != null && model instanceof Simulation) {
			Simulation sim = (Simulation)model;
			sim.suspend();
		}
	}
}
