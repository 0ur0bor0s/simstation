package Prisoner;

/*
 * 3/30 Created AlwayCheatStrat Class - Anmol Singh
 */

public class AlwaysCheatStrat extends CooperationStrat {

	@Override
	public boolean cooperate(boolean isLastOpponentCooperated) {
		return false;
	}

}
