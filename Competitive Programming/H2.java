import java.util.Scanner;

public class H2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int uebfa = sc.nextInt();
        for (int i = 0; i < uebfa; i++) {
            long num = sc.nextLong();
            int res = 0;
            long aux = reverse(num);
            while (num != aux) {
                res++;
                num = aux + num;
                aux = reverse(num);
            }
            System.out.println(res + " " + num);
        }
    }
    
    public static long reverse(long n) {
        long ans = 0;
        while (n != 0) {
            ans = ans * 10 + n % 10;
            n /= 10;
        }
        return ans;
    }
}
