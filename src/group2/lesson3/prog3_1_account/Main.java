package group2.lesson3.prog3_1_account;

import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {
		Employee employee = new Employee("John", "J", 3000, 2016, 2, 1);
		Account chkAcct = new Account(employee, AccountType.CHECKING.toString(), 300);
		Account savAcct = new Account(employee, AccountType.SAVINGS.toString(), 300);
		Account retireAcct = new Account(employee, AccountType.RETIREMENT.toString(), 300);
		
		System.out.println(chkAcct.toString());
		System.out.println(savAcct.toString());
		System.out.println(retireAcct.toString());
	}

}
