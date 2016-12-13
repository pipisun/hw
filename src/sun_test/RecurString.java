package sun_test;

public class RecurString {
/**
 * print reverse string of String using recusion
 * 
 * */
	public void RecurStr(String s) {
		if(s.length()==1)
			System.out.println(s.charAt(0));//base case
		else{
			System.out.println(s.charAt(s.length()-1));//print last char
			RecurStr(s.substring(0,s.length()-1));
		}
	}
	public static void main(String args[]){
		RecurString rr=new RecurString();
		rr.RecurStr("Hello");
	}

}
