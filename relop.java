import java.util.Scanner;

public class relop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (Integer.compare(a, b) == 0) System.out.println("=");
			else if (Integer.compare(a, b) < 0) System.out.println("<"); 
			else System.out.println(">"); 
		}
	}

}
