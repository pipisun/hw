package group2.lesson8.prgo8_2;


public class MyStringLinkedList {
	Node header;
	
	MyStringLinkedList(){
		header = new Node(null,null, null);
	}
	public void add(String item){
		Node n = new Node(header.next,header,item);
		if(header.next != null){
			header.next.previous = n;
		}		
		header.next = n;
		
	}
	
	class Node {
		String value;
		Node next;
		Node previous;
		Node(Node next, Node previous, String value){
			this.next = next;
			this.previous = previous;
			this.value = value;
		}
	}
	
	
	//inserts a new Node contain data so that its position in the list is now pos
	void insert(String data, int pos){
      
	}
 
	
	//attempts to remove the first Node that contains data; 
	//if successful, returns true; otherwise, false.
	boolean remove(String data){
		Node node = findItem(data);
		deleteNode(node);
		return false;
	}
	
	public Node findItem(String data) {
		if (header == null)
			return null;
		else {
			Node temp = header;
			while (temp != null)
				if (data.equals(temp.value))
					return temp;
				else
					temp = temp.next;
			return null;
		}
	}
	
	public void deleteNode(Node n) {
		if (header != null && n != null) {
			if (n.next == null && n.previous == null) {
				// only one node
				header = null;
				n = null;
				System.out.println("I am here 1");

			} else if (n.previous == null) {
				// remove first node
				n.next.previous = null;
				header = n.next;
				n = null;
				System.out.println("I am here 2");
			} else if (n.next == null) {
				// remove last node
				n.previous.next = null;
				n = null;
				System.out.println("I am here 3");
			} else {
				// general case
				n.next.previous = n.previous;
				n.previous.next = n.next;
				n = null;
				System.out.println("I am here 4");
			}

		}

	}
}

