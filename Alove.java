import java.util.Scanner;
import java.util.Arrays;

public class Alove
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n[] = new String[3];
		
		n[0] = sc.next();
		n[1] = sc.next(); 
		n[2] = sc.next();
		
		String x[] = new String[6];
		
		int pos = 0;
		for(int i = 0; i < 3; i++){
		    for(int j = 0; j < 3; j++){
		        for(int k = 0; k < 3; k++){
		            if(i != j && j != k && i != k){
		                x[pos] = n[i]+n[j]+n[k];
		                pos++;
		            }
		        }
		    }
		}
		
		Arrays.sort(x);
		
		System.out.println(x[5]);
	}
}
