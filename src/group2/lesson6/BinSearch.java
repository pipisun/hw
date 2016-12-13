package group2.lesson6;

public class BinSearch {

	int m;
	char ch;
	boolean bolFound = false;
	public boolean search(String s, char c)
	{
		if(s == null || s.equals(""))
			return bolFound;
		
		m =  s.length() / 2;
		ch = s.charAt(m);
		
		if(c == ch)
			return true;
		else if(c < ch)
			return search(s.substring(0,m-1), c);
		else if(c > ch)
			return search(s.substring(m+1), c);
		
		return bolFound;
	}

}
