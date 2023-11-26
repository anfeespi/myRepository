package co.edu.unbosque.util;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 * Clase para enviar correos
 * @author Andres Espitia
 * @author Diego Forero
 * @author Esteban Mejia
 * @author Camilo Uribe
 */
public class SendEmail {
	/**
	 * Correo electronico
	 */
	private static String emailFrom ="redthread107@gmail.com";
	/**
	 * Contraseña de seguridad
	 */
	private static String passwordFrom="whhvjejrvtgfibvc";
	/**
	 * Asunto
	 */
	private static String subject;
	/**
	 * Contenido
	 */
	private static String content;
	/**
	 * Propiedades
	 */
	private static Properties prop;
	/**
	 * Sesion
	 */
	private static Session session;
	/**
	 * Correo
	 */
	private static MimeMessage email;
	
	/**
	 * Metodo para enviar el correo
	 * @param addressee
	 * @param username
	 */
	public static boolean sendEmail(String addressee, String username) {
		prop= new Properties();
		subject= "BIENVENIDO A RED THREAD!";
		content = "<h1> ¡HOLA "+username+"!"+"</h1>"+"<br> Conecta con tu <b> hilo rojo </b> y descubre el camino hacia tu destino";
		prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		prop.setProperty("mail.smtp.starttls.enable", "true");
		prop.setProperty("mail.smtp.port", "587");
		prop.setProperty("mail.smtp.user", emailFrom);
		prop.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		prop.setProperty("mail.smtp.auth", "true");
		
		session = Session.getDefaultInstance(prop);
		
		try {
	
			email= new MimeMessage(session);
			email.setFrom(new InternetAddress(emailFrom));
			email.setRecipient(Message.RecipientType.TO, new InternetAddress(addressee));
			BodyPart text= new MimeBodyPart();
			text.setContent(content,"text/html");
			BodyPart img = new MimeBodyPart();
			img.setDataHandler(new DataHandler(new FileDataSource("src/co/edu/unbosque/util/media/GUIImgs/iconpdf.jpeg")));
			MimeMultipart part = new MimeMultipart();
			part.addBodyPart(text);
			part.addBodyPart(img);
			email.setSubject(subject);
			email.setContent(part);
			Transport t = session.getTransport("smtp");
			t.connect(emailFrom, passwordFrom);
			t.sendMessage(email, email.getRecipients(Message.RecipientType.TO));
			t.close();
			return true;
			
		} catch (AddressException e) {
			return false;
		} catch (MessagingException e) {
			return false;
		}
	}
}
