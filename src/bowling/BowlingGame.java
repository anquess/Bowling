package bowling;

public class BowlingGame {

	private int score_;
	private int shotCounts_;
	private int oldPins_;
	public boolean spare_;
	public boolean strike1st_;
	public boolean strike2nd_;
	public boolean double1st_;
	public boolean double2nd_;


	public BowlingGame(){
		shotCounts_	= 1;
		score_		= 0;
		oldPins_ 	= 0;
		spare_		= false;
		strike1st_	= false;
		strike2nd_	= false;
		double1st_	= false;
		double2nd_	= false;

	}

	public void recordShot(int pins) {
		calcStrikeBonus(pins);
		calcSpareBonus(pins);

		score_ 		+= pins;

		judgeSpare(pins);
		judgeStrike(pins);

		oldPins_	 = pins;
		shotCounts_++;
	}
	private void judgeStrike(int pins) {
		if((pins == 10)&&(shotCounts_ % 2 == 1)){
			if(strike2nd_){
				double1st_ = true;
				double2nd_ = true;
			}else{
			strike1st_ = true;
			strike2nd_ = true;
			}
			shotCounts_++;
		}
	}
	private void judgeSpare(int pins) {
		if((oldPins_ + pins == 10)&&(shotCounts_ % 2 == 0)){
			spare_ = true;
		}
	}
	private void calcStrikeBonus(int pins) {
		if((strike1st_)&&(strike2nd_)){
			score_	+= pins;
			strike1st_ = false;
		}else if(strike2nd_){
			score_	+= pins;
			strike2nd_ = false;
		}
		if((double1st_)&&(double2nd_)){
			score_	+= pins;
			double1st_ = false;
		}else if(double2nd_){
			score_	+= pins;
			double2nd_ = false;
		}

	}

	private void calcSpareBonus(int pins) {
		if(spare_){
			score_	+= pins;
			spare_ = false;
		}
	}

	public int getScore() {
		return score_;
	}

}
