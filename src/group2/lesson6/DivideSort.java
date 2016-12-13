package group2.lesson6;

public class DivideSort {

	int mid;
	int len;
	String sleft = "";
	String sright = "";
	char ch,ch2;
	StringBuilder ret = new StringBuilder();
	
	public DivideSort(String s) {
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "dfderxgziy";
		DivideSort ds = new DivideSort(s);
		String result = ds.divideSort(s);
//		System.out.println(result);
	}
	
	public String divideSort(String s) {
		if(s.length() == 1 || s.length() == 0)
			return s;
		
		len = s.length();
		mid = len / 2;
//		ch = s.charAt(mid);
//		ch2 = s.charAt(0);
			
		sleft = divideSort(s.substring(0, mid-1));
		
		
		System.out.println(sleft);
//		System.out.println(sright);
		
		Merge mergeObj = new Merge();
		String result = mergeObj.merge(sleft, sright);
		return result;
	}
}
