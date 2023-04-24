package modelo;

import java.util.ArrayList;

public class Descomponer {

	private int n;
	private ArrayList<Integer> descomposicion;
	private int[] primos;
	
	public Descomponer() {
		n = 0; 
		descomposicion = new ArrayList<Integer>();
		primos = new int[]{2,3,5,7,11,13,17,19,23};
	}
	
	public void factoresPrimos() {
		descomposicion.clear();
		int a = n;
		int i=0;
		while(true) {
			if(a==1) break;
			else if(a%primos[i]==0) {
				descomposicion.add(primos[i]);
				a = a/primos[i];
				i = 0;
			}
			else i++;
		}
	}

	public String imprimirArreglo() {
		String res = descomposicion.toString();
		return res;
	}
	

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	

	public int[] getPrimos() {
		return primos;
	}

	public void setPrimos(int[] primos) {
		this.primos = primos;
	}

	public ArrayList<Integer> getdescomposicion() {
		return descomposicion;
	}

	public void setdescomposicion(ArrayList<Integer> descomposicion) {
		this.descomposicion = descomposicion;
	}
	
	
	
}
