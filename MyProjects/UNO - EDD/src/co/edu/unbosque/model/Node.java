package co.edu.unbosque.model;

public class Node {
	private Object data;
	private Node next;

	public Node(Object data, Node next) {
		this.next = next;
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setDato(Object p) {
		this.data = p;
	}
}
