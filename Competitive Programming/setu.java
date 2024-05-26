import java.util.Scanner;

public class setu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		int money = 0;
		for (int i = 0; i < t; i++) {
			String str = sc.nextLine();
			if (str.contains("donate")) money += Integer.parseInt(str.split(" ")[1]);
			else System.out.println(money);
		}
	}
}
