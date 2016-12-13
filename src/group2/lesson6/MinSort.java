package group2.lesson6;

public class MinSort {

	private StringBuffer ch = new StringBuffer();
	private String returnStr;

	public String sort(String s) {
		if (s.length() == 1) {
			returnStr = ch.toString() + s;
		} else {
			boolean boo = false;
			String strNew = "";
			for (char i = 'a'; i <= 'z'; i++) {
				int index = s.indexOf(i);
				if (index >= 1) {
					ch.append(i);
					strNew = s.substring(1, index) + s.substring(0, 1) + s.substring(index + 1, s.length());
					boo = true;
					break;
				}
			}
			if (boo) {
				sort(strNew);
			}
		}
		return returnStr;
	}

	public static void main(String[] args) {
		MinSort ms = new MinSort();
		String result = ms.sort("zwxuabfkafutbbbb");
		System.out.println(result);
	}
}
