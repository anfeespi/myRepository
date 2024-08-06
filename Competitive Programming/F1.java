import java.io.BufferedInputStream;
import java.util.Scanner;

public class F1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		while (sc.hasNextInt()) {
			int uebfa = sc.nextInt();
			if ((uebfa >= 0 && uebfa < 8) || (uebfa < 0 && ((uebfa * -1) % 2 == 0)))
				System.out.println("Underflow!");
			if (uebfa == 8)
				System.out.println("40320");
			if (uebfa == 9)
				System.out.println("362880");
			if (uebfa == 10)
				System.out.println("3628800");
			if (uebfa == 11)
				System.out.println("39916800");
			if (uebfa == 12)
				System.out.println("479001600");
			if (uebfa == 13)
				System.out.println("6227020800");
			if (uebfa > 13 || (uebfa < 0 && ((uebfa * -1) % 2 == 1)))
				System.out.println("Overflow!");
		}
		sc.close();
	}
}