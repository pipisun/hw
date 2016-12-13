package group2.lesson6;

import java.util.Arrays;

public class DivideSort_SUN {

	int len;
	int mid;
	String sleft, sright;
	String result;
	Merge mergeObj = new Merge();
	public static void main(String[] args) {
		String s = "zwxuabfkafutbbbb";
		DivideSort_SUN ds = new DivideSort_SUN();
		System.out.println(ds.divideSort(s));
	}
	
	public String divideSort(String s) {
		if(s.length() == 1 || s.length() == 0)
			return s;
		else
		{
			len = s.length();
			mid = len / 2;
			
			sleft = s.substring(0, mid-1);
			sright = s.substring(mid, len-1);
			char[] csleft = sleft.toCharArray();
			char[] csright = sright.toCharArray();
			Arrays.sort(csleft);
			Arrays.sort(csright);
			result = mergeObj.merge(String.valueOf(csleft), String.valueOf(csright));
		}
		return result;
	}

}
