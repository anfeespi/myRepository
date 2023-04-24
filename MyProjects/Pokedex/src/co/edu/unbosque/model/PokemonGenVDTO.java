package co.edu.unbosque.model;

public class PokemonGenVDTO extends PokemonDTO{
	
	public PokemonGenVDTO() {
		super();
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
	public PokemonGenVDTO(String name, int id, String height, String weight, String types, String gender,
			String[] habilities) {
		super(name, id, height, weight, types, gender, habilities);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String sayGeneration() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
