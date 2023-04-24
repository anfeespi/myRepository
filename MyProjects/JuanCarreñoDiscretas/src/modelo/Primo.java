package modelo;

public class Primo {
	private int n;
	
	public Primo() {
		n = 0;
	}
	
	public boolean esPrimo() {
		for(int i=2; i<n; i++) {
			if((n%i)==0) {
				return false;
			}
		}
		return true;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

}
