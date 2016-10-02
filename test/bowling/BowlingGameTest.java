package bowling;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class BowlingGameTest {

	BowlingGame sut;

	// setup
	@Before
	public void setUp(){
		sut = new BowlingGame();
	}

	@DataPoints
	public static Fixture[] PARAMs = {
			new Fixture("全投球ガターで0を返す",null,0,20,0),
			new Fixture("全投球1で20を返す",null,1,20,20),
			new Fixture("2_5_5_1ガターで13",
					new int[]{2,5,5,1},0,16,13),
			new Fixture("スペアテスト3_7_4_ガターで18",
					new int[]{3,7,4},0,17,18),
			new Fixture("ストライクテスト10_3_3_1ガターで23",
					new int[]{10,3,3,1},0,15,23),
			new Fixture("ストライクテスト10_10_3_1ガターで41",
					new int[]{10,10,3,1},0,14,41),
	};

	@Theory
	public void パラメータによる投球テスト2(Fixture param) {
		// exercise
		if(param.shotPins_ != null){
			for(int pins:param.shotPins_){
				sut.recordShot(pins);
//				System.out.println(sut.getScore());
//				System.out.println("strike1" + sut.strike1st_);
//				System.out.println("strike2" + sut.strike2nd_);
//				System.out.println("spare" + sut.spare_);
			}
		}

		manyShot(param.pins_,param.times_);

		int actual		= sut.getScore();
		int expected	= param.expected_;

		// verify
		assertThat(param.msg_,actual,is(expected));
	}

	private void manyShot(int pins,int times) {
		for(int i=0;i<times;i++){
			sut.recordShot(pins);
		}
	}

	static class Fixture{
		String	msg_;
		int		shotPins_[];
		int		pins_;
		int		times_;
		int		expected_;
		Fixture(String msg,int[] shotPins,int pins,int times,int expected){
			msg_		= msg;
			shotPins_	= shotPins;
			pins_		= pins;
			times_		= times;
			expected_	= expected;
		}
	}

}
