package Prisoner;

public class AlwaysCheatStrat extends CooperationStrat {

	@Override
	public boolean cooperate(boolean isLastOpponentCooperated) {
		return false;
	}

}
