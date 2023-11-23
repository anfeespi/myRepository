import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Primos {
	public static void main(String[] args) {		
		long b_time = System.currentTimeMillis();
		System.out.println("Programa iniciado a las: " + LocalDateTime.now()+"\n Buscando números primos...");
		String route = "src/";
		String file_name = "salida1.out";
		
		File file = new File(route + file_name);
		
		boolean[] res = sieveEratostenes(1000000000);
		
		int c = 0;
		
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (int i = 0; i < res.length; i++) {
				if(res[i]) {
					bw.write(i + "\n");
					c++;
				}
			}

			bw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Programa finalizado a las: " + LocalDateTime.now());
		System.out.println("Tiempo empleado: "+((System.currentTimeMillis()-b_time))/1000+" segundos");
		System.out.println("Numeros primos encontrados: " + c);
	}

	public static boolean[] sieveEratostenes(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		for (int p = 2; p * p <= n; p++) {
			if (prime[p]) {
				for (int i = p * p; i <= n; i += p) {
					prime[i] = false;
				}
			}
		}
		return prime;
	}
	
}
