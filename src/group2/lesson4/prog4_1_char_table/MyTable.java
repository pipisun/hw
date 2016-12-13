package group2.lesson4.prog4_1_char_table;

public class MyTable {
	
	private static final int SIZE = 26;
	
	private Entry table[] = new Entry[SIZE];

	class Entry {
		private char c;
		private String s;
		Entry next;

		Entry(char c, String s) {
			this.c = c;
			this.s = s;
		}

		public String getS() {
			return s;
		}

		public void setS(String s) {
			this.s = s;
		}

		public char getC() {
			return c;
		}

		public String toString() {
			return c + "->" + s;
		}
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				str += table[i] + "\n";
			}
		}
		return str;
	}

 
	public void add(char c, String s) {
		int index = (int) c - 97;
		Entry e = table[index];
		if (e != null) {
			while (e.next != null) {
				if (e.c == c) {
					e.s = s;
					return;
				}
				e = e.next;
			}
			Entry entryInOldBucket = new Entry(c, s);
			e.next = entryInOldBucket;
		} else {
			Entry entryInNewBucket = new Entry(c, s);
			table[index] = entryInNewBucket;
		}
	}

	public String get(char c) {
		int index = (int) c - 97;
		Entry e = table[index];

		while (e != null) {
			if (e.c == c) {
				return e.getS();
			}
			e = e.next;
		}
		return null;
	}

	public static void main(String[] args) {
		MyTable t = new MyTable();
		t.add('a', "Andrew");
		t.add('b', "Billy");
		t.add('c', "Charlie");
		String s = t.get('b');
		System.out.println(t);
	}
}