package group2.lesson6;

public class Prog6_5 {

	int count = 0;
	int odd = 0;
	int sumNum = 0;

	public int sum(String str) {
		count++;
		System.out.println(str + "----" + count);
		int firstNum = Integer.valueOf(str.substring(0, 1));
		int LastNum = Integer.valueOf(str.substring(str.length() - 1));
		System.out.println(str);
		if (str.length() == 2) {
			return odd + sumNum + firstNum + LastNum;
		}

		if (str.length() > 2 && str.length() % 2 == 1) {
			str = str.substring(0);
			odd = Integer.valueOf(str.substring(0, 1));
		}
		sumNum = sumNum + firstNum + LastNum + sum(str.substring(1, str.length() - 1));
		return sumNum;
	}

	public static void main(String[] args) {
		Prog6_5 p = new Prog6_5();
		int sumNum = p.sum("00111111");
		System.out.println(sumNum);
	}
}
