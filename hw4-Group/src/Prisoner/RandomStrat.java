package Prisoner;

/*
 * 4/1 Random Strategy created -Anmol Singh
 */

import mvc.Utilities;

public class RandomStrat extends CooperationStrat {

	@Override
	public boolean cooperate(boolean isLastOpponentCooperated) {
		return (Utilities.rng.nextInt(2) == 1); // Return true if randomly generate number = 1; False otherwise
	}
}
