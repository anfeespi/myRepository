package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * 
 * DAO de ejecutivo
 * @author Andres Espitia
 * @author Diego Forero
 *
 */
public class ExecutiveDAO extends PersonDAO implements CRUDInterface{
	/**
	 * Lista de personas
	 */
	private ArrayList<PersonDTO> elist;
	/**
	 * Manejo de archivos
	 */
	private FileHandler fh;
	
	/**
	 * Constructor
	 */
	public ExecutiveDAO() {
		fh = new FileHandler("executives.prog1");
		loadInfo();
	}

	@Override
	public void loadInfo() {
		elist = new ArrayList<PersonDTO>();
		fh = new FileHandler("executives.prog1");
		String content = fh.readFile();
		String[] rows = content.split("\n");
		for (String s : rows) {
			String[] colums = s.split(",");
			elist.add(new ExecutiveDTO(colums[0], Integer.parseInt(colums[1]), colums[2], colums[3], colums[4]));
		}
	}

	@Override
	public String saveInfo(ArrayList<PersonDTO> list) {
		String content = "";
		ExecutiveDTO aux;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof ExecutiveDTO) {
				aux = (ExecutiveDTO) list.get(i);
				content += aux.toString()+"\n";
			}
		}
		return content;
	}

	@Override
	public void addPerson(PersonDTO p) {
		ExecutiveDTO aux = (ExecutiveDTO) p;
		elist.add(new ExecutiveDTO(aux.getName(), aux.getAge(), aux.getFood(), aux.getColor(), aux.getPosition()));
		fh.writeFile(saveInfo(elist));
		
	}

	@Override
	public boolean updatePerson(String name, int aux_age) {
		for (int i = 0; i < elist.size(); i++) {
			if (elist.get(i) instanceof ExecutiveDTO && elist.get(i).getName().equals(name)) {
				elist.get(i).setAge(aux_age);
				fh.writeFile(saveInfo(elist));
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deletePerson(String name) {
		for (int i = 0; i < elist.size(); i++) {
			if (elist.get(i) instanceof ExecutiveDTO && elist.get(i).getName().equals(name)) {
				elist.remove(i);
				fh.writeFile(saveInfo(elist));
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the elist
	 */
	public ArrayList<PersonDTO> getElist() {
		return elist;
	}

	/**
	 * @param elist the elist to set
	 */
	public void setElist(ArrayList<PersonDTO> elist) {
		this.elist = elist;
	}
}
