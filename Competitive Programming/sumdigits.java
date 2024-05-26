import java.util.Scanner;

public class sumdigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {			
			String num = sc.nextLine();
			if (num.equals("0")) break;
			
			while(true) {				
				if (num.length() == 1) {
					System.out.println(num);
					break;
				} else if (num.length() == 2) {				
					num = Integer.parseInt(num.charAt(0)+"") + Integer.parseInt(num.charAt(1)+"") + ""; 
				} else {				
					int aux = Integer.parseInt(num.charAt(0)+"") + Integer.parseInt(num.charAt(1)+"");
					
					for (int i = 2; i < num.length(); i++) {
						aux += Integer.parseInt(num.charAt(i)+"");
					}
					num = aux+"";
				}
			}
			
		}
	}

}
