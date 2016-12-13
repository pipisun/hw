package sun_test;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 1;
		short b = a;
		char c = 'a';
		int d = c;
		short e = (short) d;
		System.out.println(b);
		System.out.println(d);
		System.out.println(e);
		char[] ch = {'a'};
		String s = "abc";
		boolean bol = s.startsWith("abc");
		System.out.println(bol);
		
		int[][] abc = {{1,2},{2,3,0}};
		
		
		System.out.println(abc.length+"  "+abc[1].length);
		
		String []  aa = {"horse", null, "cat", "","dog"};
 
		System.out.println("".equals(aa[1]));
 
	}

}
