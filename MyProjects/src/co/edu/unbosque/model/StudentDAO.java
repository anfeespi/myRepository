package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * 
 * DAO de estudiante
 * @author Andres Espitia
 * @author Diego Forero
 *
 */
public class StudentDAO extends PersonDAO implements CRUDInterface{
	/**
	 * Lista de personas
	 */
	private ArrayList<PersonDTO> slist;
	/**
	 * Manejo de archivos
	 */
	private FileHandler fh;
	/**
	 * Constructor
	 */
	public StudentDAO() {
		fh = new FileHandler("students.prog1");
		loadInfo();
	}

	@Override
	public void loadInfo() {
		slist = new ArrayList<PersonDTO>();
		fh = new FileHandler("students.prog1");
		String content = fh.readFile();
		String[] rows = content.split("\n");
		for (String s : rows) {
			String[] colums = s.split(",");
			slist.add(new StudentDTO(colums[0], Integer.parseInt(colums[1]), colums[2], colums[3], Integer.parseInt(colums[4])));
		}
	}

	@Override
	public String saveInfo(ArrayList<PersonDTO> list) {
		String content = "";
		StudentDTO aux;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof StudentDTO) {
				aux = (StudentDTO) list.get(i);
				content += aux.toString()+"\n";
			}
		}
		return content;
	}

	@Override
	public void addPerson(PersonDTO p) {
		StudentDTO aux = (StudentDTO) p;
		slist.add(new StudentDTO(aux.getName(), aux.getAge(), aux.getFood(), aux.getColor(), aux.getMissing_subjects()));
		fh.writeFile(saveInfo(slist));
	}

	@Override
	public boolean updatePerson(String name, int aux_age) {
		for (int i = 0; i < slist.size(); i++) {
			if (slist.get(i) instanceof StudentDTO && slist.get(i).getName().equals(name)) {
				slist.get(i).setAge(aux_age);
				fh.writeFile(saveInfo(slist));
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deletePerson(String name) {
		for (int i = 0; i < slist.size(); i++) {
			if (slist.get(i) instanceof StudentDTO && slist.get(i).getName().equals(name)) {
				slist.remove(i);
				fh.writeFile(saveInfo(slist));
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the slist
	 */
	public ArrayList<PersonDTO> getSlist() {
		return slist;
	}

	/**
	 * @param slist the slist to set
	 */
	public void setSlist(ArrayList<PersonDTO> slist) {
		this.slist = slist;
	}

	
	
}
