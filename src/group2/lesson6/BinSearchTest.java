package group2.lesson6;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinSearchTest {

	@Test
	public void testSearch() {
		BinSearch binSearchOne = new BinSearch();
		boolean bolIsFoundTestOne = binSearchOne.search("abcd", 'c');
		assertTrue(bolIsFoundTestOne);
		
		BinSearch binSearchTwo = new BinSearch();
		boolean bolIsFoundTestTwo = binSearchTwo.search("abcdefg", 'h');
		assertFalse(bolIsFoundTestTwo);
	}

}
