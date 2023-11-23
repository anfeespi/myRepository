package maze;

import java.util.Scanner;

public class ADAKING {
	
	public static void main(String[] args) {
		int t;
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while(t-->0) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int k = sc.nextInt();
			
			int imp = 0;
			
			for (int i = 1; i <= 8; i++) {
				for (int j = 1; j <= 8; j++) {
					if(Math.max(Math.abs(i-r), Math.abs(j-c))<=k) {
						imp++;
					}
				}
			}
			
			System.out.println(imp);
		}
	}
	
}
