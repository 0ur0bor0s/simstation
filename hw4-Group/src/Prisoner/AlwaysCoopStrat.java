package Prisoner;

public class AlwaysCoopStrat extends CooperationStrat {

	@Override
	public boolean cooperate(boolean isLastOpponentCooperated) {
		return true;
	}

}
