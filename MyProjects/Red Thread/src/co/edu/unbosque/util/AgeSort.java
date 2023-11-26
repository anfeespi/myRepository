package co.edu.unbosque.util;

import java.util.ArrayList;

import co.edu.unbosque.model.UserDTO;

/**
 * Clase para ordenar por edad
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class AgeSort {
	/**
	 * Divide el arreglo
	 * @param list
	 * @param l
	 * @param m
	 * @param r
	 * @return Arreglo organizado
	 */
    public static ArrayList<UserDTO> merge(ArrayList<UserDTO> list, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        ArrayList<UserDTO> L = new ArrayList<>();
        ArrayList<UserDTO> R = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
        	L.add(list.get(l + i));
        }
        for (int j = 0; j < n2; j++) {
        	R.add(list.get(m + 1 + j));
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L.get(i).getAge() <= R.get(j).getAge()) {
                list.set(k, L.get(i));
                i++;
            } else {
            	list.set(k, R.get(j));
                j++;
            }
            k++;
        }
        while (i < n1) {
        	list.set(k, L.get(i));
            i++;
            k++;
        }
        while (j < n2) {
        	list.set(k, R.get(j));
            j++;
            k++;
        }
        return list;
    }
    /**
     * Ordena el arreglo
     * @param list
     * @param l
     * @param r
     * @return Arreglo organizado
     */
    public static ArrayList<UserDTO> sort(ArrayList<UserDTO> list, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(list, l, m);
            sort(list, m + 1, r);
            return merge(list, l, m, r);
        }
        return list;
    }
}