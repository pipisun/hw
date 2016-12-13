package group2.lesson7.prog7_3;

import java.util.Arrays;
import group2.lesson7.prog7_3.employeeinfo.*;

public class AccountList {

	private Account[] objAcctArray;

	private int size;

	private static final int DEFAULT_CAPACITY = 2;

	public AccountList() {
		this.objAcctArray = new Account[DEFAULT_CAPACITY];
	}

	private void resize(int newCapacity) {
//		System.out.println("Resizing...");
		Account[] array = new Account[newCapacity];
		System.arraycopy(objAcctArray, 0, array, 0, objAcctArray.length);
		objAcctArray = array;
	}

	public void add(Account act) {
		if (size == objAcctArray.length) {
			resize(size * 2);
		}
		objAcctArray[size] = act;
		size++;
	}

	public Account get(int i) {
		if (i < 0 || i >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return objAcctArray[i];
	}

	public boolean find(String s) {
		for (int i = 0; i < objAcctArray.length; i++) {
			if (objAcctArray[i].equals(s)) {
				return true;
			}
		}
		return false;
	}

	public boolean remove(String s) {
		boolean boo = false;

		Account[] array = new Account[objAcctArray.length];
		int num = 0;
		for (int i = 0; i < objAcctArray.length; i++) {
			if (objAcctArray[i] != null && objAcctArray[i].equals(s)) {
				objAcctArray[i] = null;
				size--;
				boo = true;
			} else {
				array[num] = objAcctArray[i];
				num++;
			}
		}
		if (boo) {
			objAcctArray = array;
		}
		return boo;

	}

	public String toString() {
		Account[] array = new Account[size];
		System.arraycopy(objAcctArray, 0, array, 0, size);
		return Arrays.toString(array);
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
//		AccountList l = new AccountList();
//		l.add("Bob");
//		System.out.println("The list of size " + l.size() + " is " + l);
//		l.add("Steve");
//		System.out.println("The list of size " + l.size() + " is " + l);
//		l.add("Susan");
//		System.out.println("The list of size " + l.size() + " is " + l);
//		l.add("Mark");
//		System.out.println("The list of size " + l.size() + " is " + l);
//		l.add("Dave");
//		System.out.println("The list of size " + l.size() + " is " + l);
//		l.remove("Mark");
//		System.out.println("The list of size " + l.size() + " is " + l);
//		l.remove("Bob");
//		System.out.println("The list of size " + l.size() + " is " + l);
	}
}
