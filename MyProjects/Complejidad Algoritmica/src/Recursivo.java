import java.math.BigInteger;

public class Recursivo {
	public static void main(String[] args) {
		fact(20);
	}
	
	public static BigInteger fact(int n) {
		if(n>0) {
			BigInteger imp = new BigInteger(""+n).multiply(fact(n-1));
			
			System.out.println("Factorial de "+n+": "+imp);		
			return imp;
		}
		return new BigInteger("1");
	}
}
