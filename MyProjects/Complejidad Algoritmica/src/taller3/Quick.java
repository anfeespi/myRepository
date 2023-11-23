package taller3;

import java.util.Arrays;
import java.util.Scanner;

public class Quick {
	static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public static void main(String args[]) {
    	Scanner sc = new Scanner(System.in);
    	int tam = sc.nextInt();
    	
        int arr[] = new int[tam];
        
        for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*(tam*10)+1);

		}
        long b_time = System.currentTimeMillis();
        
        System.out.println("Arreglo Generado : ");
        System.out.println(Arrays.toString(arr));
        
        sort(arr, 0, tam-1);
        
        System.out.println("Arreglo Ordenado : ");
        System.out.println(Arrays.toString(arr));
        System.out.println("Tiempo empleado: "+((System.currentTimeMillis()-b_time))+" Milisegundos");
    }
}
