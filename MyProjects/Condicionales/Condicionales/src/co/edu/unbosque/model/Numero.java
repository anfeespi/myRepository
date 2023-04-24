package co.edu.unbosque.model;

public class Numero {
	
	private int n;
	
	public Numero() {
		n = 0;
	}
	
	public int menor(Numero a) {
		int m = 0;
		if(n < a.n) {
			m = n;
		}
		else {
			m = a.n;
		}
		return m;
	}
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}
