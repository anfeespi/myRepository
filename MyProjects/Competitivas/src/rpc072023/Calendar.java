
import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		int m = sc.nextInt();
		int y = sc.nextInt();
		int n = sc.nextInt();
		
		int dd = sc.nextInt();
		int mm = sc.nextInt();
		int yy = sc.nextInt();
		
		int ans = n;
		
		while(true) {
			if(yy==y && mm==m && dd==d) {
				break;
			}
			
			if(d+1>30){
				d = 1;
				m++;
			}else {
				d++;
			}
			
			if(m>12){
				m = 1;
				y++;
			}
			
			if(ans+1>7) {
				ans = 1;
			}else {
				ans++;				
			}
		}
		
		System.out.println(ans);
	}

}
