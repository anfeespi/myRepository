package taller3;

import java.util.Arrays;
import java.util.Scanner;

public class Burbuja {
    static void bubbleSort(int arr[], int n) {
        if (n == 1) {
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        bubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int tam = sc.nextInt();
    	
        int arr[] = new int[tam];
        
        for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*(tam*10)+1);

		}
        long b_time = System.currentTimeMillis();
        
        System.out.println("Arreglo Generado : ");
        System.out.println(Arrays.toString(arr));
        
        
        bubbleSort(arr, arr.length);
        System.out.println("Arreglo Ordenado : ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Tiempo empleado: "+((System.currentTimeMillis()-b_time))+" segundos");
    }
}
