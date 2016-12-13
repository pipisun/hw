package group2.lesson7.prog7_3;

import java.util.Arrays;

public class MyStringList {

	private String[] strArray;

	private int size;

	private static final int DEFAULT_CAPACITY = 2;

	public MyStringList() {
		this.strArray = new String[DEFAULT_CAPACITY];
	}

	private void resize(int newCapacity) {
//		System.out.println("Resizing...");
		String[] array = new String[newCapacity];
		System.arraycopy(strArray, 0, array, 0, strArray.length);
		strArray = array;
	}

	public void add(String str) {
		if (size == strArray.length) {
			resize(size * 2);
		}
		strArray[size] = str;
		size++;
	}

	public String get(int i) {
		if (i < 0 || i >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return strArray[i];
	}

	public boolean find(String s) {
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i].equals(s)) {
				return true;
			}
		}
		return false;
	}

	public boolean remove(String s) {
		boolean boo = false;

		String[] array = new String[strArray.length];
		int num = 0;
		for (int i = 0; i < strArray.length; i++) {
			if (strArray[i] != null && strArray[i].equals(s)) {
				strArray[i] = null;
				size--;
				boo = true;
			} else {
				array[num] = strArray[i];
				num++;
			}
		}
		if (boo) {
			strArray = array;
		}
		return boo;

	}

	public String toString() {
		String[] array = new String[size];
		System.arraycopy(strArray, 0, array, 0, size);
		return Arrays.toString(array);
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		MyStringList l = new MyStringList();
		l.add("Bob");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Steve");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Susan");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Mark");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.add("Dave");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.remove("Mark");
		System.out.println("The list of size " + l.size() + " is " + l);
		l.remove("Bob");
		System.out.println("The list of size " + l.size() + " is " + l);
	}
}
