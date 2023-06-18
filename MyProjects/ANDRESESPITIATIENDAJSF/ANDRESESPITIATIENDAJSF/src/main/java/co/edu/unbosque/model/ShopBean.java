package co.edu.unbosque.model;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class ShopBean {
	private boolean condition = false;
	private String error_message = "Sin errores todavia";
	private String article;
	private int quantity;
	private int value;
	private String names;
	private String last_names;
	private String type;
	private ArrayList<String> cards;
	private String number;
	private String confirm_number;
	private int total_value;
	private Date dt = new Date();
	private String date = new SimpleDateFormat("dd-MM-yyyy").format(dt);
	private String ip;
	
	public ShopBean(){
		cards = new ArrayList<String>();
		cards.add("Visa");
		cards.add("MasterCard");
		cards.add("AmericanExpress");
		condition = false;
	}
	
	public String validate() {
		if(!number.equals(confirm_number)) {
			System.out.println("numeros");
			this.error_message = "Oh no, el número de tarjeta no coincide";
			this.condition = true;
			return "";
		}
		else if(names.equals("")) {
			System.out.println("nombres");
			this.error_message = "Podrias incluir tu nombre?";
			this.condition = true;
			return "";
		}
		else if(last_names.equals("")) {
			System.out.println("apellidos");
			this.error_message = "Podrias incluir tu apellido?";
			this.condition = true;
			return "";
		}
		else if(type.equals("")) {
			System.out.println("tarjeta");
			this.error_message = "Selecciona un tipo de tarjeta!!";
			this.condition = true;
			return "";
		}
		else if(number.equals("")) {
			System.out.println("tarjeta");
			this.error_message = "Ingresa el numero de tu tarjeta!!";
			this.condition = true;
			return "";
		}
		else if(number.equals("")) {
				System.out.println("tarjeta");
				this.error_message = "Confirma el numero de tu tarjeta!!";
				this.condition = true;
				return "";
		}
		this.number = number.substring(14);
		return "receipt";			
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLast_names() {
		return last_names;
	}

	public void setLast_names(String last_names) {
		this.last_names = last_names;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public ArrayList<String> getCards() {
		return cards;
	}

	public void setCards(ArrayList<String> cards) {
		this.cards = cards;
	}

	public int getTotal_value() {
		total_value = value*quantity;
		return total_value;
	}

	public void setTotal_value(int total_value) {
		this.total_value = total_value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIp() {
		try {
			return InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getConfirm_number() {
		return confirm_number;
	}

	public void setConfirm_number(String confirm_number) {
		this.confirm_number = confirm_number;
	}

	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean error) {
		this.condition = error;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	
	
	
	
	
}
