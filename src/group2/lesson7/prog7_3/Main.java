package group2.lesson7.prog7_3;

import java.util.Scanner;

import group2.lesson7.prog7_3.employeeinfo.Employee;

public class Main {
	Employee[] emps = null;
	public static void main(String[] args) {
		new Main();
	}
	Main(){
		emps = new Employee[3];
		emps[0] = new Employee("Jim Daley", 2000, 9, 4);
		emps[1] = new Employee("Bob Reuben", 1998, 1, 5);
		emps[2] = new Employee("Susan Randolph", 1997, 2,13);
		
		emps[0].createNewChecking(10500);
		emps[0].createNewSavings(1000);
		emps[0].createNewRetirement(9300);
		emps[1].createNewChecking(34000);
		emps[1].createNewSavings(27000);
		emps[2].createNewChecking(10038);
		emps[2].createNewSavings(12600);
		emps[2].createNewRetirement(9000);
		
		System.out.println("A. See a report of all accounts.");
		System.out.println("B. Make a deposit.");
		System.out.println("C. Make a withdrawal.");
		System.out.print("Make a selection(A/B/C): ");
		Scanner sc = new Scanner(System.in);
		String answer = sc.next().toUpperCase();
		switch(answer) {
			case "A" :
				String info = getFormattedAccountInfo();
				System.out.println(info);
				break;
			case "B" :
				doDepositOrWithdrawal("Deposit");
				break;
			case "C" :
				doDepositOrWithdrawal("Withdrawal");
				break;
		}
	}
	
	private void doDepositOrWithdrawal(String strOpr)
	{
		Scanner input = new Scanner(System.in);
		for(int i=0;i<emps.length;i++) {
			String str = i + ". " + emps[i].getName();
			System.out.println(str);
		}
		System.out.print("Select an employee: (type a number)");
		int selectEmp = input.nextInt();
		Employee e = null;
		switch(selectEmp) {
			case 0:
				String[] names1 = emps[0].getNamesOfAccounts();
				for(int i=0;i<names1.length;i++)
					System.out.println(i + ". " + names1[i]);
				e = emps[0];
				break;
			case 1:
				String[] names2 = emps[1].getNamesOfAccounts();
				for(int i=0;i<names2.length;i++)
					System.out.println(i + ". " + names2[i]);
				e = emps[1];
				break;
			case 2:
				String[] names3 = emps[2].getNamesOfAccounts();
				for(int i=0;i<names3.length;i++)
					System.out.println(i + ". " + names3[i]);
				e = emps[2];
				break;
		}
		System.out.print("Select an account: (type a number)");
		int selectAcct = input.nextInt();
		
		if(strOpr.equals("Deposit"))
			System.out.print("Deposit amount: ");
		else if(strOpr.equals("Withdrawal"))
			System.out.print("Withdrawal amount: ");
		
		double amount = input.nextDouble();
		switch(selectAcct) {
			case 0:
				if(strOpr.equals("Deposit"))
					e.deposit(0, amount);
				else if(strOpr.equals("Withdrawal"))
					e.withdraw(0, amount);
				break;
			case 1:
				if(strOpr.equals("Deposit"))
					e.deposit(1, amount);
				else if(strOpr.equals("Withdrawal"))
					e.withdraw(0, amount);
				break;
			case 2:
				if(strOpr.equals("Deposit"))
					e.deposit(2, amount);
				else if(strOpr.equals("Withdrawal"))
					e.withdraw(2, amount);
				break;
		}
		
		String strFormat = "";
		if(strOpr.equals("Deposit"))
			strFormat = String.format("$%.1f has been deposited in the %s account of %s", amount, e.getNamesOfAccounts()[selectAcct], e.getName());
		else if(strOpr.equals("Withdrawal"))
			strFormat = String.format("$%.1f has been withdrawn in the %s account of %s", amount, e.getNamesOfAccounts()[selectAcct], e.getName());
		System.out.println(strFormat);
	}
	
	String getFormattedAccountInfo(){
		//loop through employees array and get formatted
		//account info for each employee, and assemble into a string
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<emps.length;i++)
		{
			sb.append(emps[i].getFormattedAcctInfo());
			sb.append("\n");
		}
		
		String strFormat = sb.toString();
		return strFormat;
	}
}
