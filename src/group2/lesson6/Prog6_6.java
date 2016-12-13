package group2.lesson6;

public class Prog6_6 {

	private String firstSmallest = "";
	private String secondSmallest = "";
	private int unicodeMin;
	private int unicodeMinSecond;

	public String secondSmallest(String str) {
		char firstChar = str.charAt(0);
		int unicode = (int) firstChar;
		String newStr = String.valueOf(firstChar);
		if ("".equals(firstSmallest)) {
			unicodeMin = (int) firstChar;
			firstSmallest = newStr;
		} else if ("".equals(secondSmallest)) {
			if (unicode < unicodeMin) {
				unicodeMinSecond = unicodeMin;
				secondSmallest = firstSmallest;
				unicodeMin = unicode;
				firstSmallest = newStr;
			} else if (unicode > unicodeMin) {
				unicodeMinSecond = unicode;
				secondSmallest = newStr;
			}
		} else {
			if (unicode < unicodeMin) {
				unicodeMinSecond = unicodeMin;
				secondSmallest = firstSmallest;
				unicodeMin = unicode;
				firstSmallest = newStr;
			} else if (unicode < unicodeMinSecond) {
				unicodeMinSecond = unicode;
				secondSmallest = newStr;
			}
		}
		// System.out.println("unicodeMin:" + unicodeMin + " firstSmallest:" + firstSmallest);
		// System.out.println("unicodeMinSecond:" + unicodeMinSecond + "  secondSmallest:" + secondSmallest);
		if (str.length() > 1) {
			secondSmallest(str.substring(1));
		}
		return secondSmallest;
	}

	public static void main(String[] args) {

		Prog6_6 p = new Prog6_6();
		String secondSmallest = p.secondSmallest("daxwutvvmn");
		System.out.println(secondSmallest);
	}
}
