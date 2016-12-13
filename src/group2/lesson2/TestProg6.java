package group2.lesson2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProg6 {

	@Test
	public void testRemoveDups() {
		String[] testData = {"horse","dog","cat","horse","dog","dog","cat"}; 
		String[] result = Prog6.removeDups(testData);
		
		boolean bolIsElementExisted = false;
		boolean bolAnyElementExisted = false;
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < testData.length; j++) {
				if(result[i] == testData[j])
				{
					bolIsElementExisted = true;
					break;
				}
			}
			
			bolAnyElementExisted = bolIsElementExisted;	
			if(!bolAnyElementExisted)
				break;
			else
				bolIsElementExisted = false;
		}
		
		boolean bolNoDups = true;
		for(int m = 0; m < result.length-1; m++) {
			for(int n = m + 1; n < result.length;n++) {
				if(result[m] == result[n])
				{
					bolNoDups = false;
					break;
				}
			}
		}
		
		assertTrue(bolAnyElementExisted && bolNoDups);
	}

}
