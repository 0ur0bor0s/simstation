package Prisoner;

/*
 *3/30 created LastOpStrat cooperate if last prionser cooeprated.- Anmol Singh
*/

public class LastOpCoopStrat extends CooperationStrat {

	@Override
	public boolean cooperate(boolean isLastOpponentCooperated) {
		return isLastOpponentCooperated == true;
	}
}
