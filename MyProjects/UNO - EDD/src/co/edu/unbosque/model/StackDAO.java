package co.edu.unbosque.model;

/**
 * Sirve para pila de descarte, la de robar y el mazo para repartir cartas
 * 
 * @author andre
 *
 */
public class StackDAO {
	private Node top;
	private Node begin;

	public StackDAO (){
        top = null;
        begin = null;
    }

	public String[] showAll() {
		Node temp = begin;
		String[] imp = new String[size()];
		int i = 0;
		while ((temp != null)) {
			imp[i] = temp.getData().toString();
			temp = temp.getNext();
			i++;
		}
		if (imp != null)
			return imp;
		else
			return null;
	}

	public String showAllAndPop() {
		String imp = "";
		int tam = size();
		for (int i = 0; i < tam; i++) {
			imp += pop().toString() + "\n";
		}
		if (imp != "")
			return imp;
		else
			return "There isn't cards!! \n";
	}

	public int size() {
		int n = 0;
		Node temp = begin;
		while ((temp != null)) {
			n++;
			temp = temp.getNext();
		}
		return n;
	}

	public boolean isEmpty() {
		return (top == null);
	}

	public void makeEmpty() {
		top = null;
		begin = null;
	}

	public void push(Object o) {
		Node actual;
		if (isEmpty()) {
			actual = new Node(o, null);
			top = actual;
			begin = actual;
		} else {
			actual = new Node(o, null);
			top.setNext(actual);
			top = actual;
		}
	}

	public Object pop() {
		Object imp = null;
		if (isEmpty()) {
			System.out.println("ERROR: The stack is empty!");
		} else {
			imp = top.getData();
			Node temp;
			Node previous;
			previous = temp = begin;
			while ((temp.getNext() != null)) {
				previous = temp;
				temp = temp.getNext();
			}
			if (begin == temp) {
				begin = null;
				top = null;
			} else {
				previous.setNext(null);
				top = previous;
			}
		}
		return imp;
	}

	public String peek() {
		if (isEmpty()) {
			System.out.println("ERROR: The stack is empty!");
			return "";
		} else
			return top.getData().toString();
	}

	public Node getTop() {
		return top;
	}

	public void setTop(Node top) {
		this.top = top;
	}

	public Node getBegin() {
		return begin;
	}

	public void setBegin(Node begin) {
		this.begin = begin;
	}
	
	
}
