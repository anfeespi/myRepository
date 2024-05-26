import java.util.Scanner;

public class language {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cont = 1;
		while(true) {
			String str = sc.nextLine();
			if (str.equals("#")) {
				break;
			}
			switch (str) {
			case "HELLO":
				System.out.println("Case "+cont+": ENGLISH");
				break;
			case "HOLA":
				System.out.println("Case "+cont+": SPANISH");
				break;
			case "HALLO":
				System.out.println("Case "+cont+": GERMAN");
				break;
			case "BONJOUR":
				System.out.println("Case "+cont+": FRENCH");
				break;
			case "CIAO":
				System.out.println("Case "+cont+": ITALIAN");
				break;
			case "ZDRAVSTVUJTE":
				System.out.println("Case "+cont+": RUSSIAN");
				break;
			default:
				System.out.println("Case "+cont+": UNKNOWN");
				break;
			}
			cont++;
		}
	}
}
