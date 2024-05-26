import java.util.Scanner;

public class zerosones {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cont = 1;
		while(sc.hasNext()) {
			String str = sc.nextLine();
			int t = sc.nextInt();
			System.out.println("Case "+(cont)+":");
			for (int i = 0; i < t; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if (a > b) {
					int aux = a;
					a = b;
					b = aux;
				}
				char ch = str.charAt(a);
				boolean cond = true;
				for (int j = a+1; j <= b; j++) {
					if (str.charAt(j) != ch) {
						cond = false;
						break;
					}
				}
				if (cond) System.out.println("Yes");
				else System.out.println("No");
			}
			sc.nextLine();
			cont++;
		}
	}

}
