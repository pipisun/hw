package sun_test;

public class ReplaceStr {
	public static String repStr(String str, char orig, char chg) {
		if (str.length() == 0)
			return (str);
		else if (str.charAt(0) == orig)
			return chg + repStr(str.substring(1), orig, chg);
		else
			return str.charAt(0) + repStr(str.substring(1), orig, chg);
	}

	public static void main(String args[]) {
		ReplaceStr rr = new ReplaceStr();
		System.out.println(ReplaceStr.repStr("Test", 'T', 'B'));

	}
}
