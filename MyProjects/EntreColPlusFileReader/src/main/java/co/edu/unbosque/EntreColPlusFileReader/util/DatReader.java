package co.edu.unbosque.EntreColPlusFileReader.util;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//Aprobado
public class DatReader {
	
	public static void main(String[] args) {

		readDat("src/main/java/co/edu/unbosque/EntreColPlusFileReader/files/movies.dat");

	}
	
	public static void readDat(String file) {
		ArrayList<String> genders = new ArrayList<String>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			
			String line;
			
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("::");
				
				int number = Integer.parseInt(parts[0]);
				String title = parts[1];
				String year = (title.split("\\(")[1]).replaceAll("\\)",  "");
				title = title.split("\\(")[0];
				
				System.out.println("INSERT INTO peliculas VALUES ("+number+", "+title+", "+year+")");
				
				
				String line_genders = parts[2];
				line_genders = line_genders.replace('|', ',');
				String[] genero = line_genders.split(",");
				
				for (int i = 0; i < genero.length; i++) {
					int idx = -1;
					if(genders.contains(genero[i])) {
						for (int j = 0; j < genders.size(); j++) {
							if(genders.get(j).equals(genero[i])) {
								idx = j+1;
								break;
							}
						}
					}else {
						genders.add(genero[i]);
						idx = genders.size();
						System.out.println("INSERT INTO generos VALUES("+genders.size()+","+genero[i]+")");						
					}
					System.out.println("INSERT INTO peliculas_generos("+number+", "+idx+")");
				}
			}
			System.out.println("INSERT INTO generos \nVALUES");
			int pk = 1;
			for (String string : genders) {
				System.out.println("("+pk+", "+string+")");
				pk++;
			}
			
		} catch (IOException e) {
			System.out.println("Error en la lectura del .dat");
			e.printStackTrace();
		}
	}

}



