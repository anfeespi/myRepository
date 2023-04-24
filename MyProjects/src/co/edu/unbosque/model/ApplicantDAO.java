package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * 
 * DAO de aspirante
 * @author Andres Espitia
 * @author Diego Forero
 *
 */
public class ApplicantDAO extends PersonDAO implements CRUDInterface {
	
	/**
	 * Lista de personas
	 */
	private ArrayList<PersonDTO> alist;
	/**
	 * Manejo de archivos
	 */
	private FileHandler fh;
	
	/**
	 * Contructor
	 */
	public ApplicantDAO() {
		fh = new FileHandler("applicants.prog1");
		loadInfo();
	}

	@Override
	public void loadInfo() {
		alist = new ArrayList<PersonDTO>();
		fh = new FileHandler("applicants.prog1");
		String content = fh.readFile();
		String[] rows = content.split("\n");
		for (String s : rows) {
			String[] colums = s.split(",");
			alist.add(new ApplicantDTO(colums[0], Integer.parseInt(colums[1]), colums[2], colums[3], colums[4]));
		}
	}

	@Override
	public String saveInfo(ArrayList<PersonDTO> list) {
		String content = "";
		ApplicantDTO aux;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof ApplicantDTO) {
				aux = (ApplicantDTO) list.get(i);
				content += aux.toString()+"\n";
			}
		}
		return content;
	}

	@Override
	public void addPerson(PersonDTO p) {
		ApplicantDTO aux = (ApplicantDTO) p;
		alist.add(new ApplicantDTO(aux.getName(), aux.getAge(), aux.getFood(), aux.getColor(), aux.getCareer()));
		fh.writeFile(saveInfo(alist));
		
	}

	@Override
	public boolean updatePerson(String name, int aux_age) {
		for (int i = 0; i < alist.size(); i++) {
			if (alist.get(i) instanceof ApplicantDTO && alist.get(i).getName().equals(name)) {
				alist.get(i).setAge(aux_age);
				fh.writeFile(saveInfo(alist));
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deletePerson(String name) {
		for (int i = 0; i < alist.size(); i++) {
			if (alist.get(i) instanceof ApplicantDTO && alist.get(i).getName().equals(name)) {
				alist.remove(i);
				fh.writeFile(saveInfo(alist));
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the alist
	 */
	public ArrayList<PersonDTO> getAlist() {
		return alist;
	}

	/**
	 * @param alist the alist to set
	 */
	public void setAlist(ArrayList<PersonDTO> alist) {
		this.alist = alist;
	}
	
	
}
