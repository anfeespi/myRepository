import java.util.Scanner;

public class Lumberjack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		System.out.println("Lumberjacks:");
		for (int i = 0; i < t; i++) {			
			int[] arr = new int[10];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			boolean cond1 = true;
			boolean cond2 = true;
			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j] < arr[j+1]) {					
					cond1 = false;
					break;
				} 
			}
			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j] > arr[j+1]) {	
					cond2 = false;
					break;
				}				
			}
			if (cond1 || cond2) {
				System.out.println("Ordered");
			} else {
				System.out.println("Unordered");
			}
		}
		
	}

}
