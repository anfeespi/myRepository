package modelo;

public class Convertir {
	private int decimal;
	private String hexadecimal;
	private String octal;
	private String binario;
	
	public Convertir() {
		decimal = 0;
		hexadecimal = "";
		octal = "";
		binario = "";
	}
	
	public String decToBin() {
		binario="";
		
		int base = 2;
		int aux = decimal;
		int res = 0;
		
		while(aux>=1) {
			res = aux%base;
			aux = aux/base;
			binario = res + binario;
		}
		return binario;
	}
	
	public int binToDec() {
		int base = 2;
		int pot = 0;
		
		for(int i=binario.length()-1; i>=0; i--) {
			if(binario.charAt(i)=='1') {
				decimal = decimal + (int) Math.round(Math.pow(base,  pot));
			}
			pot++;
		}
		return decimal;
	}
	
	public String decToOct() {
		octal="";
		int base = 8;
		int aux = decimal;
		int res = 0;
		while(aux>=1) {
			res = aux%base;
			aux = aux/base;
			octal = res + octal;
		}
		return octal;
	}
	
	public int octToDec() {
		int base = 8;
		int pot = 0;
		
		for(int i=octal.length()-1; i>=0; i--) {
			if(octal.charAt(i)!='0') {
				decimal = decimal + Integer.parseInt(octal.charAt(i)+"") * (int)Math.round(Math.pow(base,  pot));
			}
			pot++;
		}
		return decimal;
	}
	
	public String decToHex() {
		hexadecimal="";
		int base = 16;
		int aux = decimal;
		int res = 0;
		
		while(aux>=1) {
			res = aux%base;
			if(res<10) {
				hexadecimal = res + hexadecimal;
			}
			else if(res==10) {
				hexadecimal = "A" + hexadecimal;
			}
			else if(res==11) {
				hexadecimal = "B" + hexadecimal;
			}
			else if(res==12) {
				hexadecimal = "C" + hexadecimal;
			}
			else if(res==13) {
				hexadecimal = "D" + hexadecimal;
			}
			else if(res==14) {
				hexadecimal = "E" + hexadecimal;
			}
			else if(res==15) {
				hexadecimal = "F" + hexadecimal;
			}
			aux = aux/base;
		}
		
		return hexadecimal;
	}
	
	public int hexToDec() {
		int base = 16;
		int pot = 0;
		
		for(int i=hexadecimal.length()-1; i>=0; i--) {
			if(hexadecimal.charAt(i)!='A' && hexadecimal.charAt(i)!='B' && hexadecimal.charAt(i)!='C' && hexadecimal.charAt(i)!='D' && hexadecimal.charAt(i)!='E' && hexadecimal.charAt(i)!='F' && hexadecimal.charAt(i)!='0') {
				decimal = decimal + Integer.parseInt(hexadecimal.charAt(i)+"") * (int) Math.round(Math.pow(base,  pot));
			}
			else if(hexadecimal.charAt(i)=='A') {
				decimal = decimal + 10 * (int) Math.round(Math.pow(base,  pot));
			}
			else if(hexadecimal.charAt(i)=='B') {
				decimal = decimal + 11 * (int) Math.round(Math.pow(base,  pot));
			}
			else if(hexadecimal.charAt(i)=='C') {
				decimal = decimal + 12 * (int) Math.round(Math.pow(base,  pot));
			}
			else if(hexadecimal.charAt(i)=='D') {
				decimal = decimal + 13 * (int) Math.round(Math.pow(base,  pot));
			}
			else if(hexadecimal.charAt(i)=='E') {
				decimal = decimal + 14 * (int) Math.round(Math.pow(base,  pot));
			}
			else if(hexadecimal.charAt(i)=='F') {
				decimal = decimal + 15 * (int) Math.round(Math.pow(base,  pot));
			}
			pot++;
		}
		
		return decimal;
	}

	public double getDec() {
		return decimal;
	}

	public void setDec(int decimal) {
		this.decimal = decimal;
	}

	public String getHex() {
		return hexadecimal;
	}

	public void setHex(String hexadecimal) {
		this.hexadecimal = hexadecimal;
	}

	public String getOct() {
		return octal;
	}

	public void setOct(String octal) {
		this.octal = octal;
	}

	public String getBin() {
		return binario;
	}

	public void setBin(String binario) {
		this.binario = binario;
	}
	
	
}	
