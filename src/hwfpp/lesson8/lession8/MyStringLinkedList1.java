package hwfpp.lesson8.lession8;

public class MyStringLinkedList1 {

	Node header;

	MyStringLinkedList1() {
		header = new Node(null, null, null);
	}

	// adds to the front of the list
	public void add(String item) {
		Node n = new Node(header.next, header, item);
		if (header.next != null) {
			header.next.previous = n;
		}
		header.next = n;

	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node next = header.next;
		while (next != null) {
			sb.append(next.toString() + ", ");
			next = next.next;
		}
		return sb.toString();
	}

	class Node {
		String value;
		Node next;
		Node previous;

		Node(Node next, Node previous, String value) {
			this.next = next;
			this.previous = previous;
			this.value = value;
		}

		public String toString() {
			return value == null ? "null" : value;
		}
	}

	public static void main(String[] args) {
		MyStringLinkedList1 list = new MyStringLinkedList1();
		list.add("Bob");
		list.add("Harry");
		list.add("Steve");
		System.out.println(list);
	}
}
