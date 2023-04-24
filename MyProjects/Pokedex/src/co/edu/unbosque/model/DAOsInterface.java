package co.edu.unbosque.model;

public interface DAOsInterface {	
	public abstract void createPokemonGenV(String name, int id, String weight, String height, String types, String[] habilities);
	public abstract PokemonAnotherGenDTO createPokemonAnotherGen(String name, int id, String weight, String height, String types, String[] habilities, String gender, String generation, String pokeball);
	public abstract boolean createNewPokemon(PokemonDTO pokeaux);
	public abstract boolean deletePokemon(PokemonDTO pokeaux);
	public abstract void trainPokemon(String pokenameaux, String[] new_habilities);
	public abstract String showPokemon(PokemonDTO pokeaux);
}
