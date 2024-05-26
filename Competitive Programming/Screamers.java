

import java.util.Scanner;

public class Screamers {
	
	 private static final int MOD = 1000000007;

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int D = scanner.nextInt();
	        int R = scanner.nextInt();
	        scanner.close();

	        long result = calculateUnlockValue(D, R);
	        System.out.println(result);
	    }

	    private static long calculateUnlockValue(int D, int R) {
	        return sumCoordinates(0, D, R, new int[D], 0) % MOD;
	    }

	    private static long sumCoordinates(int currentDimension, int D, int R, int[] coordinates, long sum) {
	        if (currentDimension == D) {
	            long distanceSquared = 0;
	            for (int i = 0; i < D; i++) {
	                distanceSquared += coordinates[i] * coordinates[i];
	            }
	            if (distanceSquared <= R * R) {
	                long absSum = 0;
	                for (int i = 0; i < D; i++) {
	                    absSum += Math.abs(coordinates[i]);
	                }
	                return absSum % MOD;
	            }
	            return 0;
	        } else {
	            long totalSum = 0;
	            for (int i = -R; i <= R; i++) {
	                coordinates[currentDimension] = i;
	                totalSum += sumCoordinates(currentDimension + 1, D, R, coordinates, sum) % MOD;
	                totalSum %= MOD;
	            }
	            return totalSum;
	        }
	    }
	}


