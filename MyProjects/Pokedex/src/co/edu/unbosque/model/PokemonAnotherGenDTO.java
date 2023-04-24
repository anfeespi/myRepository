package co.edu.unbosque.model;

public class PokemonAnotherGenDTO extends PokemonDTO{
	
	private String generation;
	private String url_pokeball;
	
	public PokemonAnotherGenDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param generation
	 * @param url_pokeball
	 */
	public PokemonAnotherGenDTO(String generation, String url_pokeball) {
		super();
		this.generation = generation;
		this.url_pokeball = url_pokeball;
	}

	/**
	 * @param name
	 * @param id
	 * @param height
	 * @param weight
	 * @param types
	 * @param gender
	 * @param habilities
	 */
	public PokemonAnotherGenDTO(String name, int id, String height, String weight, String types, String gender,
			String[] habilities) {
		super(name, id, height, weight, types, gender, habilities);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param id
	 * @param height
	 * @param weight
	 * @param types
	 * @param gender
	 * @param habilities
	 * @param generation
	 * @param url_pokeball
	 */
	public PokemonAnotherGenDTO(String name, int id, String height, String weight, String types, String gender,
			String[] habilities, String generation, String url_pokeball) {
		super(name, id, height, weight, types, gender, habilities);
		this.generation = generation;
		this.url_pokeball = url_pokeball;
	}

	@Override
	public String sayGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the generation
	 */
	public String getGeneration() {
		return generation;
	}

	/**
	 * @param generation the generation to set
	 */
	public void setGeneration(String generation) {
		this.generation = generation;
	}

	/**
	 * @return the url_pokeball
	 */
	public String getUrl_pokeball() {
		return url_pokeball;
	}

	/**
	 * @param url_pokeball the url_pokeball to set
	 */
	public void setUrl_pokeball(String url_pokeball) {
		this.url_pokeball = url_pokeball;
	}
	
	

}
