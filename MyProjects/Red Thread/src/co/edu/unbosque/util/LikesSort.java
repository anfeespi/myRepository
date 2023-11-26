package co.edu.unbosque.util;

import java.util.Comparator;

import co.edu.unbosque.model.UserDTO;

/**
 * Clase para ordenar por likes
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class LikesSort implements Comparator<UserDTO> {

	@Override
	public int compare(UserDTO o1, UserDTO o2) {
		if (o1.getLikes() < o2.getLikes()) {
			return 1;
		} else if (o1.getLikes() > o2.getLikes()) {
			return -1;
		} else {
			return 0;
		}
	}
}
