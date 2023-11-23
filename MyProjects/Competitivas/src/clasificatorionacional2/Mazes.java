

import java.util.Scanner;

public class Mazes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			String s = sc.next();
			int pos = 0;
			int cant = 0;
			while (pos < s.length()) {
				if (s.charAt(pos) == '!') {
					System.out.println();
				}
				if (Character.isDigit(s.charAt(pos))) {
					cant += Integer.parseInt(s.charAt(pos) + "");
				}
				if (!Character.isDigit(s.charAt(pos)) && s.charAt(pos) != 'b') {
					for (int i = 0; i < cant; i++) {
						System.out.print(s.charAt(pos));
					}
					cant = 0;
				}
				if (!Character.isDigit(s.charAt(pos)) && s.charAt(pos) == 'b') {
					for (int i = 0; i < cant; i++) {
						System.out.print(" ");
					}
					cant = 0;
				}
				pos++;
			}
			System.out.println("");
		}

	}

}
