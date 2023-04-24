package co.edu.unbosque.model;

import java.util.ArrayList;

public class PokemonDAO implements DAOsInterface{
	
	private ArrayList<PokemonDTO> pokemons;
	private StringBuilder sb;
	
	public PokemonDAO() {
		pokemons = new ArrayList<>();
	}

	@Override
	public boolean createNewPokemon(PokemonDTO pokeaux) {
		if (pokemons.add(pokeaux)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deletePokemon(PokemonDTO pokeaux) {
		if (pokemons.remove(pokeaux)) {			
			return true;
		}
		return false;
	}

	@Override
	public void trainPokemon(String pokenameaux, String[] new_habilities) {
		for (PokemonDTO pok : pokemons) {
			if (pokenameaux.equals(pok.getName())) {
				pok.setHabilities(new_habilities);
			}
		}
	}

	@Override
	public String showPokemon(PokemonDTO pokeaux) {
		sb = new StringBuilder();
		sb.append(pokeaux.getName()+";");
		sb.append(pokeaux.getId()+";");
		sb.append(pokeaux.getHeight()+";");		
		sb.append(pokeaux.getWeight()+";");		
		sb.append(pokeaux.getGender()+";");	
		if (pokeaux instanceof PokemonGenVDTO) {	
			sb.append("Generacion IV;");		
		} else if (pokeaux instanceof PokemonAnotherGenDTO) {
			PokemonAnotherGenDTO pokeaux2 = (PokemonAnotherGenDTO)pokeaux;
			sb.append(pokeaux2.getGeneration()+";");
		}
		sb.append(pokeaux.getTypes()+";");
		sb.append(pokeaux.getHabilities());
		return sb.toString();
	}

	@Override
	public void createPokemonGenV(String name, int id, String weight, String height, String types,
			String[] habilities) {
		pokemons.add(new PokemonGenVDTO(name, id, height, weight, types, "Desconocido", habilities));
	}

	@Override
	public PokemonAnotherGenDTO createPokemonAnotherGen(String name, int id, String weight, String height, String types,
			String[] habilities, String gender, String generation, String pokeball) {
		PokemonAnotherGenDTO aux = new PokemonAnotherGenDTO(name, id, height, weight, types, gender, habilities, generation, pokeball);
		pokemons.add(aux);
		return aux;
	}

	/**
	 * @return the pokemons
	 */
	public ArrayList<PokemonDTO> getPokemons() {
		return pokemons;
	}

	/**
	 * @param pokemons the pokemons to set
	 */
	public void setPokemons(ArrayList<PokemonDTO> pokemons) {
		this.pokemons = pokemons;
	}

	
}
