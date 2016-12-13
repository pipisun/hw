package group2.lesson4.prog4_2_inst_inner;

public class Top {
	int t = 1;
	Middle mid;
	Middle.Bottom midbot;
	//returns the value in the instance vble of Bottom
	public Top(){
		mid = new Middle();
		midbot = mid.new Bottom();
	}
	int readBottom() {
		return midbot.b;
	}
	class Middle {
		int m = 2;
		//returns sum of instance vble in Top and 
		//instance vble in Bottom
		int addTopAndBottom() {
			int sum = t + readBottom();
			return sum;
		}
		class Bottom {
			int b = 3;
			//returns the product of the instance vbles
			//in all three classes
			int multiplyAllThree() {
				int result = t * mid.m * b;
				return result;
			}
		}
	}
	public static void main(String[] args){
		
		Top top = new Top();
		System.out.println(top.readBottom());
		System.out.println(top.mid.addTopAndBottom());
		System.out.println(top.midbot.multiplyAllThree());
 
	}

}