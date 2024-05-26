
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Natatorium {
	
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Read the surface area C
	        long C = scanner.nextLong();

	        // Read the number of primes M
	        int M = scanner.nextInt();

	        // Read the list of primes
	        long[] primes = new long[M];
	        for (int i = 0; i < M; i++) {
	            primes[i] = scanner.nextLong();
	        }

	        // Use a HashSet for fast lookup of primes
	        Set<Long> primeSet = new HashSet<>();
	        for (long prime : primes) {
	            primeSet.add(prime);
	        }

	        // Find the pair of primes
	        for (long prime : primes) {
	            if (C % prime == 0) {
	                long neededPrime = C / prime;
	                if (neededPrime != prime && primeSet.contains(neededPrime)) {
	                    // Print the pair in ascending order
	                    if (prime < neededPrime) {
	                        System.out.println(prime + " " + neededPrime);
	                    } else {
	                        System.out.println(neededPrime + " " + prime);
	                    }
	                    return;
	                }
	            }
	        }

	        // If no valid pair is found, though according to the problem statement, there should always be a valid pair
	        System.out.println("No valid pair found");
	    }
	}



