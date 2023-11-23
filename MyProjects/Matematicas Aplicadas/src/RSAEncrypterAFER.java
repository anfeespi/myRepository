import java.math.BigInteger;

public class RSAEncrypterAFER {
	public static int C = 232;
	public static int E = 31;
	public static int N = 517;
	
	
	public static void main(String[] args) {
		
		System.out.println("Programa para averiguar el cifrado RSA de las 4 primeras letras del abecedario - Andrés Espitia");
		
		for (int i = 65; i < 69; i++) {
			System.out.println(cifrar(i));
		}
		
	}
	
	public static String cifrar(int ascii) {
		
		BigInteger a = new BigInteger(""+ascii);
		BigInteger cr = (a.pow(E)).mod(new BigInteger(""+N));
		
		return "En encriptado de "+((char)ascii)+" es: "+cr;
		
	}
	
}
