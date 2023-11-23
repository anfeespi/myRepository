import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrimosAFER {
	
	public static int sundaram(int n) {
		int c = 1;
		int n_new = ((n-1)/2);
		boolean[] marked = new boolean[n_new+1];

		String route = "src/";
		String file_name = "salida1.out";
		
		File file = new File(route+file_name); 
		
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(2 + "\n");
			
			for (long i = 1; i <= n_new; i++) {
				
				for (long j = i; j <= n_new && (i + j + 2 * i * j)<=n_new; j++) {
					marked[(int) (i + j + 2 * i * j)] = true;					
				}
				
				if(!marked[(int)i]) {
					bw.write((2*i+1)+"\n");
					c++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	
	public static void main(String[] args) {
		long b_time = System.currentTimeMillis();
		System.out.println("Ejecución iniciada en: " + b_time);
		System.out.println("Buscando números primos...");
		int n = 1000000000;
		int c = sundaram(n);
		
		System.out.println("Tiempo empleado: "+((System.currentTimeMillis()-b_time)/1000)+" segundos");
		System.out.println("Números primos encontrados: "+c);
	}
}
