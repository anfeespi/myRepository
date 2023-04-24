package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * 
 * DAO de persona
 * @author Andres Espitia
 * @author Diego Forero
 *
 */
public class PersonDAO implements CRUDInterface{
	/**
	 * Lista de personas
	 */
	private ArrayList<PersonDTO> plist;
	/**
	 * Manejo de archivos
	 */
	private FileHandler fh;
	
	/**
	 * Constructor
	 */
	public PersonDAO() {
		plist = new ArrayList<>();
		fh = new FileHandler("persons.csv");
		loadInfo();
	}
	
	@Override
	public void loadInfo() {
		String content = fh.readFile();
		String[] rows = content.split("\n");
		for (String s : rows) {
			String[] colums = s.split(",");
			plist.add(new PersonDTO(colums[0], Integer.parseInt(colums[1]), colums[2], colums[3]));
		}
	}
	
	@Override
	public String saveInfo(ArrayList<PersonDTO> list) {
		String content = "";
		for (PersonDTO p : list) {
			content += p.toString()+"\n";
		}
		return content;
	}
	
	@Override
	public void addPerson(PersonDTO p) {
		plist.add(new PersonDTO(p.getName(), p.getAge(), p.getFood(), p.getColor()));
		fh.writeFile(saveInfo(plist));
	}

	@Override
	public boolean updatePerson(String name, int aux_age) {
		for (int i = 0; i < plist.size(); i++) {
			if (plist.get(i).getName().equals(name)) {
				plist.get(i).setAge(aux_age);
				fh.writeFile(saveInfo(plist));
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deletePerson(String name) {
		for (int i = 0; i < plist.size(); i++) {
			if (plist.get(i).getName().equals(name)) {
				plist.remove(i);
				fh.writeFile(saveInfo(plist));
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the plist
	 */
	public ArrayList<PersonDTO> getPlist() {
		return plist;
	}

	/**
	 * @param plist the plist to set
	 */
	public void setPlist(ArrayList<PersonDTO> plist) {
		this.plist = plist;
	}
	
}
