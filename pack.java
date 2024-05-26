import java.util.Scanner;

public class pack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if (a > 20 || b > 20 || c > 20) {
				System.out.println("Case " + (i+1) + ": bad");
			} else {				
				System.out.println("Case " + (i+1) + ": good");
			}
		}
	}

}
