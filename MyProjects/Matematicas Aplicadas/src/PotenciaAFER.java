import java.math.BigInteger;
import java.util.Scanner;

public class PotenciaAFER {
	/*
	 * Función iterativa que calcula (x^y)%p in O(log y)
	 */
	static BigInteger power(BigInteger x, BigInteger y, BigInteger p) {
		// Inicializar resultado
		BigInteger res = new BigInteger("1");
		// Actualiza x si es más que
		// o igual a p
		x = x.mod(p);
		while (y.compareTo(new BigInteger("0")) == 1) { // Si y es impar, multiplica x con res
			if (y.and(BigInteger.ONE).equals(BigInteger.ONE)) {
				res = res.multiply(x).mod(p);
			}
			// y debe ser par ahora
			// y = y / 2
			y = y.shiftRight(1);
			x = x.multiply(x).mod(p);
		}
		return res;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		String arr[] = sc.nextLine().split("#");
		
		System.out.println("El resultadocd es " + power(new BigInteger(arr[0]), new BigInteger(arr[1]), new BigInteger(arr[2])));
	}
}
