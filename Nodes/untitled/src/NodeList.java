public class NodeList {

	Node start;

	public class Node {

		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}

		public Node() {
		}
	}

	public NodeList() {
	}

	void printList() {
		Node currentNode = start;
		while(currentNode != null) {
			System.out.println(currentNode.value);
			currentNode = currentNode.next;
		}
	}

	void addNode(int value) {
		Node newNode = new Node(value);

		if (start == null) {
			start = newNode;
		} else {
			Node currentNode = start;
			while(currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
		}
	}

	public static void main(String[] args) {

		NodeList lista = new NodeList();

		lista.addNode(5);
		lista.addNode(12);
		lista.addNode(4);
		lista.addNode(6);
		lista.addNode(8);

		lista.printList();

	}
}
