package group2.lesson2;

/**
 * Prog2_4
 * The records of a database table Product have been stored in text format using delimiters ¡°:¡± and ¡°,¡± 
 * in the following way: Different rows are separated by ¡°:¡± 
 * and, within a particular record, different column entries are separated by ¡°,¡±. 
 * In each record, the first column is always productId.
 * Write a program (called Prog4) that will read such a text file and extract all the product id¡¯s that occur in the file. 
 * Your program should then output these values to the console in the following form: (this is a typical example)
 * 134A
 * 213A
 * 911C
 * 012E
 * 662Z
 * Since we have not yet discussed how to read a file in Java, a text file is provided for you in this assignment in the form of a separate Java class, called Data. 
 * The records have been stored as a long String in Data, named records. 
 * To access this String within your own program, you can use this line of code:
 * myString = Data.records;
 */
public class Prog2_4 {

	public static void main(String[] args) {
		String myString = Data.records;
		String[] strRecords = myString.split(":");
		
		for (int i = 0; i < strRecords.length; i++) {
			String[] strOneRecord = strRecords[i].split(",");
			System.out.println(strOneRecord[0]);
		}
	}

}
