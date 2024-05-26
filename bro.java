import java.util.Scanner;

public class bro {

	public static void main(String[] args) {
		String one = "one";
		String two = "two";
		String three = "three";
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < t; i++) {
			int u = 0; 
			int d = 0; 
			int th = 0;
			String a = sc.nextLine();
			if (a.length() == 3) {
				for (int j = 0; j < 3; j++) {
					if (a.charAt(j) == one.charAt(j)) u++;
					if (a.charAt(j) == two.charAt(j)) d++;
				}
				if (u >= 2) System.out.println(1);
				if (d >= 2) System.out.println(2);
			} else {				
				for (int j = 0; j < 5; j++) {
					if (a.charAt(j) == three.charAt(j)) th++;
				}
				if (th >= 4) System.out.println(3);
			}
		}
	}

}
