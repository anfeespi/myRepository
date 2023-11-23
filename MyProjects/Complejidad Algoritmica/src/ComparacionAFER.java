
public class ComparacionAFER {
	
	public static int[] y1;
	public static int[] y2;
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		calculate();
		long endTime = System.nanoTime();
		
		System.out.println("Tiempo empleado: "+ ((double)(endTime - startTime)/1000000000) + " segundos");
	}
	
	public static void calculate() {
		y1 = new int[101];
		y2 = new int[101];
		for (int i = -50; i <= 50; i++) {
			y1[i+50] = (int) (6 - Math.pow(i, 2));
			y2[i+50] = 4 - i;
			if(y1[i+50] == y2[i+50]) {
				System.out.println("Son iguales: " + (i));
			}else if(y1[i+50] > y2[i+50]) {
				System.out.println("Y1 es mayor a Y2: " + (i));
			}else {
				System.out.println("Y2 es mayor a Y1: " + (i));
			}
		}
	}
}
