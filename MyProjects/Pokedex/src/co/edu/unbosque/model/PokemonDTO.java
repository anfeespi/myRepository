package co.edu.unbosque.model;

public abstract class PokemonDTO {
	private String name;
	private int id;
	private String height;
	private String weight;
	private String types;
	private String gender;
	private String generation;
	private String[] habilities;
	
	public PokemonDTO() {
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
	 */
	public PokemonDTO(String name, int id, String height, String weight, String types, String gender,
			String[] habilities) {
		super();
		this.name = name;
		this.id = id;
		this.height = height;
		this.weight = weight;
		this.types = types;
		this.gender = gender;
		this.habilities = habilities;
	}



	public abstract String sayGeneration();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the types
	 */
	public String getTypes() {
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(String types) {
		this.types = types;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the habilities
	 */
	public String[] getHabilities() {
		return habilities;
	}

	/**
	 * @param habilities the habilities to set
	 */
	public void setHabilities(String[] habilities) {
		this.habilities = habilities;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the habilities
	 */
	public String[] getHability() {
		return habilities;
	}

	/**
	 * @param hability the habilities to set
	 */
	public void setHability(String habilities[]) {
		this.habilities = habilities;
	}
	
	
}
