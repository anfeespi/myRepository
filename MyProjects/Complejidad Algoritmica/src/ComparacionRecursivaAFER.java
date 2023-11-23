
public class ComparacionRecursivaAFER {
	public static int[] y1;
	public static int[] y2;
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		y1 = new int[101];
		y2 = new int[101];
		System.out.println(recursiveMethod(-50, ""));
		long endTime = System.nanoTime();
		System.out.println("Tiempo empleado: "+ ((double)(endTime - startTime)/1000000000) + " segundos");
	}
	
	public static String recursiveMethod(int i, String s){
		if(i>50) return s;
		
		int y1 = (int) (6 - Math.pow(i, 2));
		int y2 = 4 - i;
		
		
		
		if(y1 > y2) {
			s += "\nY1 es mayor a Y2, n=" + i;
			return recursiveMethod(i+1, s);
		}
		else if(y2 > y1){
			 s += "\nY2 es mayor a Y1, n=" +i;
			 return recursiveMethod(i+1, s);
		}
		else{
			s += "\nSon iguales, n ="+i;
			return recursiveMethod(i+1, s);
		}
	}

}
