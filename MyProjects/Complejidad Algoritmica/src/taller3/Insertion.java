package taller3;

import java.util.Arrays;
import java.util.Scanner;

public class Insertion {
	 static void sort(int arr[])
	    {
	        int n = arr.length;
	        for (int i = 1; i < n; ++i) {
	            int key = arr[i];
	            int j = i - 1;
	            while (j >= 0 && arr[j] > key) {
	                arr[j + 1] = arr[j];
	                j = j - 1;
	            }
	            arr[j + 1] = key;
	        }
	    }
	 
	    public static void main(String args[])
	    {
	    	Scanner sc = new Scanner(System.in);
	    	int tam = sc.nextInt();
	    	
	        int arr[] = new int[tam];
	        
	        for (int i = 0; i < arr.length; i++) {
				arr[i] = (int)(Math.random()*(tam*10)+1);

			}
	        long b_time = System.currentTimeMillis();
	        
	        System.out.println("Arreglo Generado : ");
	        System.out.println(Arrays.toString(arr));
	        
	        sort(arr);
	        
	        System.out.println("Arreglo Ordenado : ");
	        System.out.println(Arrays.toString(arr));
	        System.out.println("Tiempo empleado: "+((System.currentTimeMillis()-b_time))+" Milisegundos");
	        
	    }
}
