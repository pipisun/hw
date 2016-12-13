package hwfpp.lesson3.prog3_1_code;

import java.text.DateFormat;
import java.util.Date;

public class Util {
	public static String dateAsString(Date d) {
		DateFormat f = DateFormat.getDateInstance(DateFormat.SHORT);
		return f.format(d);
	}
	
}
