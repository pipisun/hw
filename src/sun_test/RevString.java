package sun_test;

public class RevString {
	
	public void revStr(String s){
		if(s.length()>0){			//recursive case
			revStr(s.substring(1));//print tail
			System.out.println(s.charAt(0));
		}
	}

	public static void main(String[] args) {
		RevString r1=new RevString();
		r1.revStr("Madam");

	}

}
