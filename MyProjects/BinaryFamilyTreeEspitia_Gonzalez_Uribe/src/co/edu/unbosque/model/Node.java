package co.edu.unbosque.model;

public class Node {
	private Node left;
	private Node right;
	private MemberDTO member;
	
	public Node() {
		// TODO Auto-generated constructor stub
	}
	
	public Node(Node left, Node right, MemberDTO member) {
		super();
		this.left = left;
		this.right = right;
		this.member = member;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public MemberDTO getMember() {
		return member;
	}

	public void setMember(MemberDTO member) {
		this.member = member;
	}
	
}
