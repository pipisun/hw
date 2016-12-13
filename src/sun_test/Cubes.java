package sun_test;

class Cubes {
	
/**
 * 
 * Off-by-One Error. The expressions *s.charAt(0) and s.substring(1) will generate exceptions if s is
*  the empty string
 * */
	public void printStr(String s) {
		
		if(s.length()==0)
		{
			return;//Base Case:do nothing
		}
		else
		{
			System.out.println(s.charAt(0));//Print Head
			printStr(s.substring(1));//Print Tail
			
		}
	}
	
	
	public static void main(String args[]){
		Cubes c1=new Cubes();
		c1.printStr("Hello");
	}
}
