package Prisoner;

public class LastOpCoopStrat extends CooperationStrat {

	@Override
	public boolean cooperate(boolean isLastOpponentCooperated) {
		return isLastOpponentCooperated == true;
	}
}
