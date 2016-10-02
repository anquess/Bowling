package bowling;

import static bowling.Janken.Hand.*;
import static bowling.Janken.Result.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import bowling.Janken.Hand;
import bowling.Janken.Result;


@RunWith(Enclosed.class)
public class JankenTest {

	@RunWith(Theories.class)
	public static class JankenTest2{
		Janken sut;

		@Before
		public void setUp(){
			sut = new Janken();
		}

		@DataPoints
		public static Fixture p[] = {
				new Fixture("グー対チョキ",GU,TYOKI,WIN),
				new Fixture("グー対パー",GU,PA,LOSE),
				new Fixture("グー対グー",GU,GU,LOSE),
		};
//		@DataPoint
//		public static Hand hand2 = TYOKI;

		public static class Fixture{
			String	msg_;
			Hand 	hand1_;
			Hand 	hand2_;
			Result 	result_;

			Fixture(String msg,Hand hand1,Hand hand2,Result result){
				msg_	= msg;
				hand1_ 	= hand1;
				hand2_ 	= hand2;
				result_	= result;
			}
		}

		@Theory
		public void グー対チョキ(Fixture p){
			assertThat(p.msg_,sut.Judge(p.hand1_, p.hand2_), is(p.result_));
		}
	}
	public static class Test2{

		@Test
		public void test2(){
		}
	}


}
