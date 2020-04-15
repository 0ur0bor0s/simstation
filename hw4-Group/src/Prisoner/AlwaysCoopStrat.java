package Prisoner;

/*
 * 3/30 Created AlwayCopp Class - Anmol Singh
 */

public class AlwaysCoopStrat extends CooperationStrat {

	@Override
	public boolean cooperate(boolean isLastOpponentCooperated) {
		return true;
	}

}
