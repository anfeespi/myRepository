package co.edu.unbosque.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadAndUpdateFile {
	
	private String[] types = {"acero", "agua", "bicho", "dragon", "electrico", "fantasma", "fuego", "hielo", "lucha", "normal",
			"planta", "psiquico", "roca", "siniestro", "tierra", "veneno", "volador", "hada"};
	private ArrayList<ArrayList<String>>[] habilities;
	private ArrayList<String> pokemons;
	private ArrayList<String> pokemons_anothergen;
	private PrintWriter pw;
	private Scanner sc;
	private StringBuilder sb = new StringBuilder();
	
	public ReadAndUpdateFile() {
		pokemons = new ArrayList<>();
		pokemons_anothergen = new ArrayList<>();
		habilities = new ArrayList[18];
		readPokemons();
		readHabilities();
	}
	
	public void readHabilities() {
		int it = 0;
		for (String type : types) {
			habilities[it] = new ArrayList<>();
			try {
				sc = new Scanner(new FileReader("src/texts/hab_tipo_"+type+".txt"));
				ArrayList<String> aux = new ArrayList<>();
				while(sc.hasNext()) {
					aux.add(sc.nextLine());
				}
				habilities[it].add(aux);
				it++;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void readPokemons() {
		try {
			sc = new Scanner(new FileReader("src/texts/pokemons.txt"));
			while(sc.hasNext()) {				
				pokemons.add(sc.nextLine());
			}
			sc = new Scanner(new FileReader("src/texts/pokemons_anothergen.txt"));
			while(sc.hasNext()) {				
				pokemons_anothergen.add(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	//Se sobrescribe el archivo cuando se salga de atrapar, eliminar o entrenar
	public boolean addPokemons(PokemonAnotherGenDTO aux) {
		sb = new StringBuilder();
		sb.append(aux.getName()+";");
		sb.append(aux.getId()+";");
		sb.append(aux.getWeight()+";");
		sb.append(aux.getHeight()+";");
		sb.append(aux.getTypes()+";");
		for (int i = 0; i < aux.getHabilities().length; i++) {
			if (i == aux.getHabilities().length-1) {				
				sb.append(aux.getHabilities()[i]+"_;");
			} else {				
				sb.append(aux.getHabilities()[i]+"_");
			}
		}
		for (String hab : aux.getHabilities()) {			
		}
		sb.append(aux.getGender()+";");
		sb.append(aux.getGeneration()+";");
		sb.append(aux.getUrl_pokeball());
		pokemons_anothergen.add(sb.toString());
		return true;
	}
	
	public void deletePokemons(String pokename) {
		for (int i = 0; i < pokemons_anothergen.size(); i++) {
			if(pokemons_anothergen.get(i).contains(pokename)) {				
				pokemons_anothergen.remove(i);
				break;
			}
		}
	}
	
	public void updatePokemons(PokemonDTO pokemon) {
		if (pokemon instanceof PokemonGenVDTO) {
			for (int i = 0; i < pokemons.size(); i++) {
				if (pokemons.get(i).contains(pokemon.getName())) {
					String pok_aux = "";
					String aux = "";
					for (int j = 0; j < pokemon.getHabilities().length; j++) {
						if (j == 0) {
							aux += pokemon.getHabilities()[j];
							
						}else {							
							aux = aux+"_"+pokemon.getHabilities()[j];
						}
					}
					String[] aux2 = pokemons.get(i).split(";");
					for (int j = 0; j < aux2.length; j++) {
						if (j == 5) {	
							aux2[j] = aux;
						}
						pok_aux += aux2[j]+";";
					}
					
					pokemons.set(i, pok_aux.substring(0, pok_aux.length()-1));
				}
			}
		} else if (pokemon instanceof PokemonAnotherGenDTO) {
			for (int i = 0; i < pokemons_anothergen.size(); i++) {
				if (pokemons_anothergen.get(i).contains(pokemon.getName())) {
					String pok_aux = "";
					String aux = "";
					for (int j = 0; j < pokemon.getHabilities().length; j++) {
						if (j == 0) {
							aux += pokemon.getHabilities()[j];
							
						}else {							
							aux = aux+"_"+pokemon.getHabilities()[j];
						}
					}
					String[] aux2 = pokemons_anothergen.get(i).split(";");
					for (int j = 0; j < aux2.length; j++) {
						if (j == 5) {	
							aux2[j] = aux;
						}
						pok_aux += aux2[j]+";";
					}
					
					pokemons_anothergen.set(i, pok_aux.substring(0, pok_aux.length()-1));
				}
			}
		}
	}
	
	public void updateFile() {
		try {
			pw = new PrintWriter("src/texts/pokemons.txt");
			for (String pok : pokemons) {
				pw.println(pok);
			}
			pw.close();
			pw = new PrintWriter("src/texts/pokemons_anothergen.txt");
			for (String pok : pokemons_anothergen) {
				pw.println(pok);
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the types
	 */
	public String[] getTypes() {
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(String[] types) {
		this.types = types;
	}

	/**
	 * @return the habilities
	 */
	public ArrayList<ArrayList<String>>[] getHabilities() {
		return habilities;
	}

	/**
	 * @param habilities the habilities to set
	 */
	public void setHabilities(ArrayList<ArrayList<String>>[] habilities) {
		this.habilities = habilities;
	}

	/**
	 * @return the pokemons
	 */
	public ArrayList<String> getPokemons() {
		return pokemons;
	}

	/**
	 * @param pokemons the pokemons to set
	 */
	public void setPokemons(ArrayList<String> pokemons) {
		this.pokemons = pokemons;
	}

	/**
	 * @return the pokemons_anothergen
	 */
	public ArrayList<String> getPokemons_anothergen() {
		return pokemons_anothergen;
	}

	/**
	 * @param pokemons_anothergen the pokemons_anothergen to set
	 */
	public void setPokemons_anothergen(ArrayList<String> pokemons_anothergen) {
		this.pokemons_anothergen = pokemons_anothergen;
	}
	
	
}
