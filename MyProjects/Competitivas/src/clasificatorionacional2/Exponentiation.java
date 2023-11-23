

import java.math.BigDecimal;
import java.util.Scanner;

public class Exponentiation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			BigDecimal r = sc.nextBigDecimal();
			int n = sc.nextInt();
			String imp = r.pow(n).stripTrailingZeros().toPlainString();
			
			if(imp.startsWith("0")) imp = imp.substring(1);
			
			System.out.println(imp);
		}
	}

}
