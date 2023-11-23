package co.edu.unbosque.EntreColPlusBack.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;

import co.edu.unbosque.EntreColPlusBack.model.Genero;
import co.edu.unbosque.EntreColPlusBack.model.Pelicula;

public class DatReader {
	private ArrayList<Pelicula> p;
	private ArrayList<Genero> g;
	
	public ArrayList<Pelicula> getP() {
		return p;
	}

	public ArrayList<Genero> getG() {
		return g;
	}

	public void readDat(String file) {
		p = new ArrayList<>();
		g = new ArrayList<>();
		ArrayList<String> genders = new ArrayList<String>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("::");
				
				int number = Integer.parseInt(parts[0]);
				String title = parts[1];
				String year = (title.split("\\(")[title.split("\\(").length-1]).replaceAll("\\)",  "");
				
				Year y = Year.of(Integer.parseInt(year));
				title = title.split("\\(")[0];
				
				Pelicula aux = new Pelicula(number, title, y);
				
				
				String line_g = parts[2];
				line_g = line_g.replace('|', ',');
				String[] genero = line_g.split(",");
				
				for (int i = 0; i < genero.length; i++) {
					if(genders.contains(genero[i])) {
						for (int j = 0; j < genders.size(); j++) {
							if(genders.get(j).equals(genero[i])) {
								aux.getGeneros().add(g.get(j));
								break;
							}
						}
					}else {
						g.add(new Genero((g.size()+1), genero[i]));
						aux.getGeneros().add(g.get(g.size()-1));
						genders.add(genero[i]);					
					}
				}
				p.add(aux);
			}
		} catch (IOException e) {
			System.out.println("Error en la lectura del .dat");
			e.printStackTrace();
		}
	}

}



