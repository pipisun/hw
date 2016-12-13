package group2.lesson2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Prog2_8Test {

	@Test
	public void testMinimum() {
		int[] arrayOfInts = new int[]{2, -21, 3, 45, 0, 12, 18, 6, 3, 1, 0, -22};
		int min = Prog2_8.min(arrayOfInts);
		
		boolean bolIsMin = true;
		for(int i=0;i<arrayOfInts.length;i++)
		{
			if(arrayOfInts[i] < min)
			{
				bolIsMin = false;
				break;
			}
		}
		assertTrue(bolIsMin);
	}

}
