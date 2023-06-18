package co.edu.unbosque.model;

public class FamilyDAO {
	private Node root;
	private FamilyDAO copy;

	public FamilyDAO() {
		root = null;
	}

	public boolean exist(String name) {
		return exist(this.root, name);
	}

	public boolean exist(Node n, String name) {
		if (n == null) {
			return false;
		}

		if (n.getMember().getName().equals(name)) {
			return true;
		} else if (n.getLeft() != null && exist(n.getLeft(), name)) {
			return true;
		} else if (n.getRight() != null && exist(n.getRight(), name)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean add(MemberDTO m, String name) {
		if (name.contains("*")) {
			root = new Node(null, null, m);
			return true;
		} else {
			return add(this.root, m, name);
		}
	}

	public boolean add(Node father, MemberDTO m, String name) {
		if (name.equals(father.getMember().getName())) {
			if (father.getLeft() == null) {
				father.setLeft(new Node(null, null, m));
				return true;
			} else if (father.getRight() == null) {
				father.setRight(new Node(null, null, m));
				return true;
			} else {
				return false;
			}
		} else {
			if (father.getLeft() != null && add(father.getLeft(), m, name)) {
				return true;
			} else if (father.getRight() != null && add(father.getRight(), m, name)) {
				return true;
			} else {
				return false;
			}
		}
	}

	public void addByAge(MemberDTO m) {
		Node newn;
		newn = new Node();
		newn.setMember(m);
		newn.setLeft(null);
		newn.setRight(null);
		if (root == null) {
			root = newn;			
		}
		else {
			Node previous = null, r;
			r = root;
			while (r != null) {
				previous = r;
				if (newn.getMember().getAge() < r.getMember().getAge())
					r = r.getLeft();
				else
					r = r.getRight();
			}
			if (newn.getMember().getAge() < previous.getMember().getAge())
				previous.setLeft(newn);
			else
				previous.setRight(newn);
		}
	}

	public String preOrder(Node n) {
		StringBuilder sb = new StringBuilder("");
		if (n != null) {
			sb.append(n.getMember().toString());
			sb.append(preOrder(n.getLeft()));
			sb.append(preOrder(n.getRight()));
		}
		return sb.toString();
	}

	public String inOrder(Node n) {
		StringBuilder sb = new StringBuilder("");
		if (n != null) {
			sb.append(inOrder(n.getLeft()));
			sb.append(n.getMember().toString());
			sb.append(inOrder(n.getRight()));
		}
		return sb.toString();
	}

	public String postOrder(Node n) {
		StringBuilder sb = new StringBuilder("");
		if (n != null) {
			sb.append(postOrder(n.getLeft()));
			sb.append(postOrder(n.getRight()));
			sb.append(n.getMember().toString());
		}
		return sb.toString();
	}
	
	public void iop(Node n) {
		if (n != null) {
			iop(n.getLeft());
			copy.addByAge(n.getMember());
			iop(n.getRight());
		}
	}
	
	public FamilyDAO passTo() {
		copy = new FamilyDAO();
		iop(root);
		return copy;
	}
	
	public int countNodes(Node n) {
		int nodes = 0;
		if (n != null) {
			nodes += countNodes(n.getLeft());
			nodes += countNodes(n.getRight());
			nodes++;
		}
		return nodes;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

}
