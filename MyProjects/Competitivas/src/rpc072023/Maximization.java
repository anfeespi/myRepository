

import java.util.Arrays;
import java.util.Scanner;

public class Maximization {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		
		char[] arr = n.toCharArray();
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[arr.length-1-i]);			
		}
		System.out.println();
	}
}
