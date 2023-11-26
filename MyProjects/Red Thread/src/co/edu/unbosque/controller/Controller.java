package co.edu.unbosque.controller;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.model.AdminDAOImpl;
import co.edu.unbosque.model.LoginAdminDAOImpl;
import co.edu.unbosque.model.LoginDAOImpl;
import co.edu.unbosque.model.LoginDTO;
import co.edu.unbosque.model.UserDAOImpl;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.UserManDTO;
import co.edu.unbosque.model.UserWomanDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.SendEmail;
import co.edu.unbosque.view.AdminStatisticsFrame;
import co.edu.unbosque.view.AdminUsersFrame;
import co.edu.unbosque.view.CreateProfileFrame;
import co.edu.unbosque.view.CustomProfileFrame;
import co.edu.unbosque.view.IntroFrame;
import co.edu.unbosque.view.LanguageFrame;
import co.edu.unbosque.view.SignInFrame;
import co.edu.unbosque.view.MainFrame;
import co.edu.unbosque.view.MatchesFrame;
import co.edu.unbosque.view.Panes;
import co.edu.unbosque.view.ShowOrDeleteUserFrame;
import co.edu.unbosque.view.LogInFrame;

/**
 * Controlador principal
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class Controller implements ActionListener{
	/**
	 * Ventana de introduccion
	 */
	private IntroFrame ifr;
	/**
	 * Ventana de registro
	 */
	private LogInFrame lif;
	/**
	 * Ventana principal
	 */
	private MainFrame mfr;
	/**
	 * Ventana para editar perfil
	 */
	private CustomProfileFrame cpf;
	/**
	 * Ventana para elegir el idioma
	 */
	private LanguageFrame laf;
	/**
	 * Ventana de inicio de sesion
	 */
	private SignInFrame sif;
	/**
	 * Ventana para crear perfil
	 */
	private CreateProfileFrame crf;
	/**
	 * Ventana de las estadisticas
	 */
	private AdminStatisticsFrame asf;
	/**
	 * Ventana donde se listan los usuarios
	 */
	private AdminUsersFrame auf;
	/**
	 * Ventana donde se muestran o eliminan usuarios
	 */
	private ShowOrDeleteUserFrame sdf;
	/**
	 * Objeto de administradores
	 */
	private AdminDAOImpl admins;
	/**
	 * Cuentas de inicio de sesion administrador
	 */
	private LoginAdminDAOImpl logadmin;
	/**
	 * Usuarios
	 */
	private UserDAOImpl users;
	/**
	 * Logins
	 */
	private LoginDAOImpl login;
	/**
	 * Booleano para mostrar solo una vez la pantalla de intro
	 */
	private boolean show = true;
	/**
	 * Clase de JOptionPane
	 */
	private Panes pan;
	/**
	 * Sesion iniciada en el programa
	 */
	private int session;
	/**
	 * Sesion de administrador
	 */
	private boolean admin_session;
	/**
	 * Posicion entre el arreglo de compatibles
	 */
	private int compatible_n;
	/**
	 * Ventana de matches
	 */
	private MatchesFrame maf;
	/**
	 * Nombre
	 */
	private String name = "";
	/**
	 * Primer apellido
	 */
	private String first_lastname = "";
	/**
	 * Segundo apellido
	 */
	private String second_lastname = "";
	/**
	 * Alias
	 */
	private String alias = "";
	/**
	 * Formato de fecha
	 */
	private SimpleDateFormat format = null;
	/**
	 * Fecha de nacimiento
	 */
	private Date birth = null;
	/**
	 * Correo electronico
	 */
	private String email = "";
	/**
	 * Genero
	 */
	private boolean gender = true;
	/**
	 * Orientacion sexual
	 */
	private String orientation = "";
	/**
	 * Ciudad de origen
	 */
	private String origin = "";
	/**
	 * Ciudad de residencia
	 */
	private String residence = "";
	/**
	 * Contacto
	 */
	private String contact = "";
	/**
	 * Contraseña
	 */
	private String password = "";
	/**
	 * Fotos
	 */
	private ArrayList<String> photos;
	/**
	 * Imagen a mostrar
	 */
	private int imgshow = 0;
	/**
	 * Arreglo de compatibles
	 */
	private ArrayList<UserDTO> com;
	/**
	 * Propiedades
	 */
	private Properties prop;
	/**
	 * lenguaje
	 */
	private int language = 0;
	/**
	 * Constructor
	 */
	public Controller() {
		checkInit();
	}

	/**
	 * Inicializacion de todo
	 */
	private void init() {
		initObjects();
		initIntroFrame();
		prop= FileHandler.loadPropertiesLang(language);
		setActionCommands();
		addListeners();
	}

	/**
	 * Inicializacion de pantalla de introduccion
	 */
	public void initIntroFrame() {
		show=true;
		ifr = new IntroFrame();
		initFrames();
		ifr.setVisible(true);
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(show) {
					if(session!=-1 && admin_session) {
						auf.setVisible(true);
					}else if(session!=-1 && !admin_session){
						chargeMainFrame();
					}else if(session==-1){
						lif.setVisible(true);
					}
					ifr.setVisible(false);
					show = false;
				}
			}
		});

		timer.start();
	}

	/**
	 * Metodo para inicializar las ventanas
	 */
	public void initFrames() {
		mfr = new MainFrame(language);
		lif = new LogInFrame(language);
		laf = new LanguageFrame();
		sif = new SignInFrame(language);
		crf = new CreateProfileFrame(language);
		auf = new AdminUsersFrame(language);
		asf = new AdminStatisticsFrame(language);
		maf = new MatchesFrame(language);
		sdf = new ShowOrDeleteUserFrame(language);
		pan = new Panes();
	}
	
	/**
	 * Verificar idioma 
	 * @return idioma
	 */
	public int checkLanguage() {
		int sel=0;
		if(laf.getLp().getChcLanguage().getSelectedItem().equals("English")) {
			sel=2;
		}else if(laf.getLp().getChcLanguage().getSelectedItem().equals("Spanish")) {
			sel=1;
		}
		return sel;
	}
	
	/**
	 * Verificar idioma inicio
	 */
	public void checkInit() {
		if(readInit()[3]==0) {
			laf = new LanguageFrame();
			laf.setVisible(true);
			laf.getLp().getOk().setActionCommand("OK");
			laf.getLp().getOk().addActionListener(this);
		}else {
			language = readInit()[3];
			init();
		}
	}
	
	/**
	 * Metodo para inicializar los objetos
	 */
	public void initObjects() {
		admins = new AdminDAOImpl();
		logadmin = new LoginAdminDAOImpl();
		for (int i = 0; i < admins.getAdmins().size(); i++) {
			logadmin.getLogins_admins().add(new LoginDTO(admins.getAdmins().get(i).getUsername(), admins.getAdmins().get(i).getPassword(),"What is ur position?", i+""));
		}
		users = new UserDAOImpl();
		login = new LoginDAOImpl();
		session = readInit()[0];
		if(readInit()[1]==0) {
			admin_session = false;			
		}else {
			admin_session = true;						
		}
		compatible_n = readInit()[2];
	}

	/**
	 * Metodo que devuelve las preferencias
	 * @return preferencias
	 */
	public int[] readInit() {
		String content= FileHandler.loadFile("config.init");
		int[] inits = {Integer.parseInt(content.split("\n")[0]), Integer.parseInt(content.split("\n")[1]), Integer.parseInt(content.split("\n")[2]), Integer.parseInt(content.split("\n")[3])};
		return inits;
	}

	public void changeConfig() {
		String admin = "";
		if(admin_session) admin = "1";
		else admin = "0";
		String content = session+"\n"+admin+"\n"+compatible_n+"\n"+language;
		//el resto de preferencias
		//idioma
		FileHandler.writeFile("config.init", content);
	}

	/**
	 * Metodo para asignar comandos a los botones
	 */
	public void setActionCommands() {
		pan.getOk().setActionCommand("OK_PANES");
		lif.getSp().getLogIn().setActionCommand("LOGIN");
		lif.getSp().getSignIn().setActionCommand("SIGNIN");
		lif.getSp().getForgotPassword().setActionCommand("FORGOT");
		mfr.getMp().getBtnProfile().setActionCommand("CUSTOMPROFILE");
		mfr.getMp().getBtnSettings().setActionCommand("SETTINGS_MAIN");
		mfr.getMp().getBtnDislike().setActionCommand("DISLIKE");
		mfr.getMp().getBtnLike().setActionCommand("LIKE");
		mfr.getMp().getBtnSuperlike().setActionCommand("SUPERLIKE");
		mfr.getMp().getBtnLast().setActionCommand("LASTIMG");
		mfr.getMp().getBtnLast_1().setActionCommand("NEXTIMG");
		mfr.getMp().getOp_panel().getMatches().setActionCommand("SHOW_MATCHES");
		mfr.getMp().getOp_panel().getLanguage().setActionCommand("CHANGE_LANGUAGE");
		mfr.getMp().getOp_panel().getLogOut().setActionCommand("LOG_OUT");
		laf.getLp().getOk().setActionCommand("OK");
		sif.getLp().getLogIn().setActionCommand("SIGNIN-C");
		crf.getCpp().getCreate().setActionCommand("CREATE");
		crf.getCpp().getPhoto1().setActionCommand("PHOTO1");
		crf.getCpp().getPhoto2().setActionCommand("PHOTO2");
		crf.getCpp().getPhoto3().setActionCommand("PHOTO3");
		crf.getCpp().getPhoto4().setActionCommand("PHOTO4");
		maf.getMp().getOptions().setActionCommand("SETTINGS_MATCHES");
		maf.getMp().getHome().setActionCommand("HOME");
		maf.getMp().getOp_panel().getMatches().setActionCommand("SHOW_MATCHES");
		maf.getMp().getOp_panel().getLanguage().setActionCommand("CHANGE_LANGUAGE");
		maf.getMp().getOp_panel().getLogOut().setActionCommand("LOG_OUT");
		//
		auf.getAup().getUpdate().setActionCommand("UPDATE_USERS");
		auf.getAup().getOptions().setActionCommand("SETTINGS_ADMIN");
		auf.getAup().getOp_panel().getLanguage().setActionCommand("CHANGE_LANGUAGE");
		auf.getAup().getOp_panel().getStats().setActionCommand("STATS");
		auf.getAup().getOp_panel().getReports().setActionCommand("REPORTS");
		auf.getAup().getOp_panel().getShowDelete().setActionCommand("SHOW_DELETE");
		auf.getAup().getOp_panel().getLogOut().setActionCommand("LOG_OUT");
		asf.getAsp().getUpdate().setActionCommand("UPDATE_STATS");
		asf.getAsp().getOptions().setActionCommand("SETTINGS_ADMIN");
		asf.getAsp().getOp_panel().getShow_users().setActionCommand("SHOW_USERS");
		asf.getAsp().getOp_panel().getLanguage().setActionCommand("CHANGE_LANGUAGE");
		asf.getAsp().getOp_panel().getReports().setActionCommand("REPORTS");
		asf.getAsp().getOp_panel().getShowDelete().setActionCommand("SHOW_DELETE");
		asf.getAsp().getOp_panel().getLogOut().setActionCommand("LOG_OUT");
		sdf.getSdp().getDelete().setActionCommand("DELETE_USER");
		sdf.getSdp().getShow().setActionCommand("SHOW_USER_INFO");
		sdf.getSdp().getOptions().setActionCommand("SETTINGS_ADMIN");
		sdf.getSdp().getOp_panel().getShow_users().setActionCommand("SHOW_USERS");
		sdf.getSdp().getOp_panel().getLanguage().setActionCommand("CHANGE_LANGUAGE");
		sdf.getSdp().getOp_panel().getStats().setActionCommand("STATS");
		sdf.getSdp().getOp_panel().getReports().setActionCommand("REPORTS");
		sdf.getSdp().getOp_panel().getLogOut().setActionCommand("LOG_OUT");
	}

	/**
	 * Metodo para asignar listeners a los botones
	 */
	public void addListeners() {
		pan.getOk().addActionListener(this);
		lif.getSp().getLogIn().addActionListener(this);
		lif.getSp().getSignIn().addActionListener(this);
		lif.getSp().getForgotPassword().addActionListener(this);
		mfr.getMp().getBtnProfile().addActionListener(this);
		mfr.getMp().getBtnSettings().addActionListener(this);
		mfr.getMp().getBtnDislike().addActionListener(this);
		mfr.getMp().getBtnLike().addActionListener(this);
		mfr.getMp().getBtnSuperlike().addActionListener(this);
		mfr.getMp().getBtnLast().addActionListener(this);
		mfr.getMp().getBtnLast_1().addActionListener(this);
		mfr.getMp().getOp_panel().getMatches().addActionListener(this);
		mfr.getMp().getOp_panel().getLanguage().addActionListener(this);
		mfr.getMp().getOp_panel().getLogOut().addActionListener(this);
		laf.getLp().getOk().addActionListener(this);
		sif.getLp().getLogIn().addActionListener(this);
		crf.getCpp().getCreate().addActionListener(this);
		crf.getCpp().getPhoto1().addActionListener(this);
		crf.getCpp().getPhoto2().addActionListener(this);
		crf.getCpp().getPhoto3().addActionListener(this);
		crf.getCpp().getPhoto4().addActionListener(this);
		maf.getMp().getOptions().addActionListener(this);
		maf.getMp().getHome().addActionListener(this);
		maf.getMp().getOp_panel().getMatches().addActionListener(this);
		maf.getMp().getOp_panel().getLanguage().addActionListener(this);
		maf.getMp().getOp_panel().getLogOut().addActionListener(this);
		auf.getAup().getUpdate().addActionListener(this);
		auf.getAup().getOptions().addActionListener(this);
		auf.getAup().getOp_panel().getShow_users().addActionListener(this);
		auf.getAup().getOp_panel().getLanguage().addActionListener(this);
		auf.getAup().getOp_panel().getStats().addActionListener(this);
		auf.getAup().getOp_panel().getReports().addActionListener(this);
		auf.getAup().getOp_panel().getShowDelete().addActionListener(this);
		auf.getAup().getOp_panel().getLogOut().addActionListener(this);
		asf.getAsp().getUpdate().addActionListener(this);
		asf.getAsp().getOptions().addActionListener(this);
		asf.getAsp().getOp_panel().getShow_users().addActionListener(this);
		asf.getAsp().getOp_panel().getLanguage().addActionListener(this);
		asf.getAsp().getOp_panel().getStats().addActionListener(this);
		asf.getAsp().getOp_panel().getReports().addActionListener(this);
		asf.getAsp().getOp_panel().getShowDelete().addActionListener(this);
		asf.getAsp().getOp_panel().getLogOut().addActionListener(this);
		sdf.getSdp().getDelete().addActionListener(this);
		sdf.getSdp().getShow().addActionListener(this);
		sdf.getSdp().getOptions().addActionListener(this);
		sdf.getSdp().getOp_panel().getShow_users().addActionListener(this);
		sdf.getSdp().getOp_panel().getLanguage().addActionListener(this);
		sdf.getSdp().getOp_panel().getStats().addActionListener(this);
		sdf.getSdp().getOp_panel().getReports().addActionListener(this);
		sdf.getSdp().getOp_panel().getLogOut().addActionListener(this);
	}

	/**
	 * Metodo para cargar el metodo principal
	 */
	private void chargeMainFrame() {
		com = users.showCompatibles(session);
		if(com.size()<1) {
			show = true;
			session = -1;
			admin_session = false;
			init();
			lif.setVisible(true);
			pan.showMessage(prop.getProperty("properties.controller.chargemain.error"));
		}else {
			mfr = new MainFrame(language);
			mfr.getMp().getBtnProfile().setActionCommand("CUSTOMPROFILE");
			mfr.getMp().getBtnDislike().setActionCommand("DISLIKE");
			mfr.getMp().getBtnLike().setActionCommand("LIKE");
			mfr.getMp().getBtnSuperlike().setActionCommand("SUPERLIKE");
			mfr.getMp().getBtnSettings().setActionCommand("SETTINGS_MAIN");
			mfr.getMp().getOp_panel().getMatches().setActionCommand("SHOW_MATCHES");
			mfr.getMp().getOp_panel().getLanguage().setActionCommand("CHANGE_LANGUAGE");
			mfr.getMp().getOp_panel().getLogOut().setActionCommand("LOG_OUT");
			mfr.getMp().getBtnLast().setActionCommand("LASTIMG");
			mfr.getMp().getBtnLast_1().setActionCommand("NEXTIMG");
			mfr.getMp().getBtnLast().addActionListener(this);
			mfr.getMp().getBtnLast_1().addActionListener(this);
			mfr.getMp().getBtnProfile().addActionListener(this);
			mfr.getMp().getBtnDislike().addActionListener(this);
			mfr.getMp().getBtnLike().addActionListener(this);
			mfr.getMp().getBtnSuperlike().addActionListener(this);
			mfr.getMp().getBtnSettings().addActionListener(this);
			mfr.getMp().getOp_panel().getMatches().addActionListener(this);
			mfr.getMp().getOp_panel().getLanguage().addActionListener(this);
			mfr.getMp().getOp_panel().getLogOut().addActionListener(this);
			mfr.getMp().getLblNameAge().setText(com.get(compatible_n).getName()+" "+com.get(compatible_n).getLastname1()+" ("+com.get(compatible_n).getAge()+")");
			mfr.getMp().changeImage(com.get(compatible_n).getUrl_photos().get(0));
			mfr.getMp().getLblNameAge().setFont(new Font("Raleway", 0, 30));
			mfr.getMp().getTxtDescription().setText(com.get(compatible_n).getInfo());
			mfr.setVisible(true);			
		}
	}

	/**
	 * Metodo para añadir foto
	 * @return ruta de la foto
	 */
	public String addPhoto() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG, JPEG & PNG", "jpg", "png", "jpeg"); 
		fileChooser.setFileFilter(imgFilter);

		int result = fileChooser.showOpenDialog(crf);

		File dir = new File("src/co/edu/unbosque/util/media/usersImgs/"+alias);
		if (!dir.exists()) {
			if (dir.mkdir()) {
				pan.showMessage(prop.getProperty("properties.controller.addphoto"));
			} else {
				pan.showMessage(prop.getProperty("properties.controller.addphoto.error"));
			}
		}

		if (result != JFileChooser.CANCEL_OPTION) {
			File fileName = fileChooser.getSelectedFile();
			String url = "";

			if ((fileName == null) || (fileName.getName().equals(""))) {
				url = "...";
			} else {
				url = fileName.getAbsolutePath();
			}

			if (fileName != null) {
				String destStr = "src/co/edu/unbosque/util/media/usersImgs/"+alias+"/";
				Path dest = Paths.get(destStr);

				Path orig = Paths.get(url);

				try {
					Path cop = Files.copy(orig, dest.resolve(orig.getFileName()));
					return destStr+cop.getFileName();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return "";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("LOGIN")) {
			if(logadmin.logIn(lif.getSp().getUsername().getText(), lif.getSp().getPassword().getText()) == -1 && login.logIn(lif.getSp().getUsername().getText(), lif.getSp().getPassword().getText()) == -1) {
				pan.showMessage(prop.getProperty("properties.controller.login.error"));
			}else {
				if(logadmin.logIn(lif.getSp().getUsername().getText(), lif.getSp().getPassword().getText()) != -1) {
					lif.setVisible(false);
					admin_session = true;
					session = logadmin.logIn(lif.getSp().getUsername().getText(), lif.getSp().getPassword().getText());
					auf.setVisible(true);
				}else if(login.logIn(lif.getSp().getUsername().getText(), lif.getSp().getPassword().getText()) != -1) {
					lif.setVisible(false);
					admin_session = false;
					session = login.logIn(lif.getSp().getUsername().getText(), lif.getSp().getPassword().getText());
					chargeMainFrame();
				}
			}
			changeConfig();
		}
		if(e.getActionCommand().equals("SIGNIN")) {
			lif.setVisible(false);
			sif.setVisible(true);
		}
		if(e.getActionCommand().equals("FORGOT")) {
			String username = JOptionPane.showInputDialog("Type your username please");
			if (login.securityQuestion(username).equals("")) {
				pan.showMessage(prop.getProperty("properties.controller.login.error"));
			} else {				
				pan.showMessage(login.securityQuestion(username));
			}
			
		}		
		if(e.getActionCommand().equals("CUSTOMPROFILE")) {
			mfr.setVisible(false);
			cpf = new CustomProfileFrame(language);
			cpf.getCopp().getBtnUpdate().setActionCommand("UPDATE");
			cpf.getCopp().getBtnSettings().setActionCommand("SETTINGS_CUSTOM");
			cpf.getCopp().getOp_panel().getMatches().setActionCommand("SHOW_MATCHES");
			cpf.getCopp().getOp_panel().getLanguage().setActionCommand("CHANGE_LANGUAGE");
			cpf.getCopp().getOp_panel().getLogOut().setActionCommand("LOG_OUT");
			cpf.getCopp().getBtnUpdate().addActionListener(this);
			cpf.getCopp().getBtnSettings().addActionListener(this);
			cpf.getCopp().getOp_panel().getMatches().addActionListener(this);
			cpf.getCopp().getOp_panel().getLanguage().addActionListener(this);
			cpf.getCopp().getOp_panel().getLogOut().addActionListener(this);
			cpf.getCopp().replacePlaceholders(users.getUsers().get(session));
			cpf.repaint();
			cpf.setVisible(true);
		}
		if(e.getActionCommand().equals("UPDATE")) {
			cpf.setVisible(false);
			if(!cpf.getCopp().getTxtAlias().getText().equals("")) {
				users.updateUserAlias(session, cpf.getCopp().getTxtAlias().getText());
				login.getLogins().get(session).setAlias(cpf.getCopp().getTxtAlias().getText());
			}
			if(!cpf.getCopp().getTxtCOO().getText().equals("")) {
				users.updateUserOrigin(session, cpf.getCopp().getTxtCOO().getText());
			}
			if(!cpf.getCopp().getTxtEmail().getText().equals("")) {
				users.updateUserEmail(session, cpf.getCopp().getTxtEmail().getText());
			}
			if(!cpf.getCopp().getTxtCOR().getText().equals("")) {
				users.updateUserResidence(session, cpf.getCopp().getTxtCOR().getText());
			}
			if(!cpf.getCopp().getTxtContact().getText().equals("")) {
				users.updateUserContact(session, cpf.getCopp().getTxtContact().getText());
			}
			users.updateUserOrientation(session, cpf.getCopp().getOrientation().getSelectedItem().toString());
			cpf.getCopp().getTxtAlias().setText("");
			cpf.getCopp().getTxtCOO().setText("");
			cpf.getCopp().getTxtEmail().setText("");
			cpf.getCopp().getTxtCOR().setText("");
			cpf.getCopp().getTxtContact().setText("");
			cpf.getCopp().replacePlaceholders(users.getUsers().get(session));
			cpf.repaint();
			mfr.setVisible(true);
		}
		if(e.getActionCommand().equals("SETTINGS_MAIN")) {
			if(!mfr.getMp().getOp_panel().isVisible()) {				
				mfr.getMp().showOptions();
				mfr.getMp().getBtnProfile().setVisible(false);
				mfr.repaint();
			} else {
				mfr.getMp().getOp_panel().setVisible(false);
				mfr.getMp().getBtnProfile().setVisible(true);
				mfr.repaint();
			}
		}
		if(e.getActionCommand().equals("SETTINGS_CUSTOM")) {
			if(!cpf.getCopp().getOp_panel().isVisible()) {				
				cpf.getCopp().showOptions();
				cpf.repaint();
			} else {
				cpf.getCopp().getOp_panel().setVisible(false);
				cpf.repaint();
			}
		}
		if(e.getActionCommand().equals("SETTINGS_MATCHES")) {
			if(!maf.getMp().getOp_panel().isVisible()) {				
				maf.getMp().showOptions();
				maf.getMp().getHome().setVisible(false);
				maf.repaint();
			} else {
				maf.getMp().getOp_panel().setVisible(false);
				maf.getMp().getHome().setVisible(true);
				maf.repaint();
			}
		}
		if(e.getActionCommand().equals("OK")) {
			laf.setVisible(false);
			language = checkLanguage();
			admin_session = false;
			session = -1;
			changeConfig();
			init();
			if(admin_session) {
				auf.setVisible(true);
			} else if (session != -1) {				
				mfr.setVisible(true);
			}
		}
		if(e.getActionCommand().equals("LIKE")) {
			//repaint rey
			users.getUsers().get(session).setLikes_sent(users.getUsers().get(session).getLikes_sent()+1);
			mfr.setVisible(false);
			int idx = 0;
			for (int i = 0; i < users.getUsers().size(); i++) {
				if(users.getUsers().get(i).equals(users.showCompatibles(session).get(compatible_n))) {
					idx = i;
				}
			}

			users.getUsers().get(idx).getLikes_recived().set(session, true);

			if(compatible_n < users.showCompatibles(session).size()-1) {
				compatible_n++;
				chargeMainFrame();
				if(users.getUsers().get(session).getLikes_recived().get(idx)) {
					pan.showMessage(prop.getProperty("properties.controller.matches"));
					users.getUsers().get(session).getMatches_persons().add(idx);
				}
			} else if(compatible_n == users.showCompatibles(session).size()-1){
				mfr.setVisible(true);
				if(users.getUsers().get(session).getLikes_recived().get(idx)) {
					pan.showMessage(prop.getProperty("properties.controller.matches"));
					users.getUsers().get(session).getMatches_persons().add(idx);
				}
				pan.showMessage(prop.getProperty("properties.controller.list.error"));
			}
			FileHandler.writeSerializable(users.getUsers(), "Usuarios.uebfa");

		}
		if(e.getActionCommand().equals("SUPERLIKE")) {
			//repaint rey
			users.getUsers().get(session).setLikes_sent(users.getUsers().get(session).getLikes_sent()+1);
			mfr.setVisible(false);
			int idx = 0;
			for (int i = 0; i < users.getUsers().size(); i++) {
				if(users.getUsers().get(i).equals(users.showCompatibles(session).get(compatible_n))) {
					idx = i;
				}
			}

			users.getUsers().get(idx).getLikes_recived().set(session, true);

			if(compatible_n < users.showCompatibles(session).size()-1) {
				compatible_n++;
				chargeMainFrame();
				if(users.getUsers().get(session).getLikes_recived().get(idx)) {
					pan.showMessage(prop.getProperty("properties.controller.matches"));
					users.getUsers().get(session).getMatches_persons().add(idx);
				}
			} else if(compatible_n == users.showCompatibles(session).size()-1){
				mfr.setVisible(true);
				if(users.getUsers().get(session).getLikes_recived().get(idx)) {
					pan.showMessage(prop.getProperty("properties.controller.matches"));
					users.getUsers().get(session).getMatches_persons().add(idx);
				}
				pan.showMessage(prop.getProperty("properties.controller.list.error"));
			}
			FileHandler.writeSerializable(users.getUsers(), "Usuarios.uebfa");
		}
		if(e.getActionCommand().equals("DISLIKE")) {
			//repaint rey
			mfr.setVisible(false);
			if(compatible_n+1 < users.showCompatibles(session).size()-1) {
				compatible_n++;
				chargeMainFrame();
			}
			else{
				pan.showMessage(prop.getProperty("properties.controller.list.error"));
			}	
		}
		if(e.getActionCommand().equals("LASTIMG")) {
			ArrayList<UserDTO> com = users.showCompatibles(session);
			int img = com.get(compatible_n).getUrl_photos().size();
			if (imgshow ==  0) {
				imgshow = img-1;
			} else {
				imgshow--;
			}
			mfr.getMp().changeImage(com.get(compatible_n).getUrl_photos().get(imgshow));
			mfr.repaint();
		}
		if(e.getActionCommand().equals("NEXTIMG")) {
			ArrayList<UserDTO> com = users.showCompatibles(session);
			int img = com.get(compatible_n).getUrl_photos().size();
			if (imgshow ==  img-1) {
				imgshow = 0;
			} else {
				imgshow++;
			}
			mfr.getMp().changeImage(com.get(compatible_n).getUrl_photos().get(imgshow));
			mfr.repaint();
		}	
		if(e.getActionCommand().equals("SHOW_MATCHES")) {
			maf.setVisible(true);
			maf.getMp().showMatches(users.getUsers().get(session).num_matches(), users.getUsers().get(session).getMatches_persons());
			maf.repaint();
			mfr.setVisible(false);
			if (cpf != null) cpf.setVisible(false);
		}
		if(e.getActionCommand().equals("CHANGE_LANGUAGE")) {
			laf.setVisible(true);
			auf.setVisible(false);
			asf.setVisible(false);
			mfr.setVisible(false);
			if (cpf != null) cpf.setVisible(false);
		}
		if(e.getActionCommand().equals("LOG_OUT")) {
			String content = -1+"\n"+0+"\n"+0+"\n"+language;
			FileHandler.writeFile("config.init", content);
			mfr.setVisible(false);
			if (cpf != null) cpf.setVisible(false);
			maf.setVisible(false);
			auf.setVisible(false);
			asf.setVisible(false);
			sdf.setVisible(false);
			show = true;
			session = -1;
			admin_session = false;
			init();
		}
		if(e.getActionCommand().equals("SIGNIN-C")) {
			name = "";
			first_lastname = "";
			second_lastname = "";
			alias = "";
			format = null;
			birth = null;
			email = "";
			gender = true;
			orientation = "";
			origin = "";
			residence = "";
			contact = "";
			password = "";
			photos = new ArrayList<>();

			name = sif.getLp().getTextName().getText();
			first_lastname = sif.getLp().getFirstLastname().getText();
			second_lastname = sif.getLp().getSecondLastname().getText();
			alias = sif.getLp().getAlias().getText();
			format = new SimpleDateFormat("dd/MM/yyyy"); 
			try {
				birth = format.parse(""+sif.getLp().getDay().getSelectedItem()+"/"+sif.getLp().getMonth().getSelectedItem()+"/"+sif.getLp().getYear().getSelectedItem());
			} catch (ParseException e1) {
				pan.showMessage("Fecha no correspondiente");
				pan.getOk().addActionListener(this);
				e1.printStackTrace();
			}
			email = sif.getLp().getEmail().getText();
			gender = true;
			if(sif.getLp().getGender().getSelectedIndex() == 1) {
				gender = false;
			}
			orientation = (String)sif.getLp().getOrientation().getSelectedItem();
			origin = sif.getLp().getOrigin().getText();
			residence = sif.getLp().getResidence().getText();
			contact = sif.getLp().getContact().getText();
			password = sif.getLp().getPassword().getText();

			if(name.equals("") || first_lastname.equals("") || second_lastname.equals("") || alias.equals("") || email.equals("") || orientation.equals("") || origin.equals("") || residence.equals("") || contact.equals("") || password.equals("")) {
				pan.showMessage(prop.getProperty("properties.controller.signin.error"));//propiedades
				pan.getOk().addActionListener(this);
			} else if(users.userExist(alias)) {
				pan.showMessage(prop.getProperty("properties.controller.signin.username.error"));//propiedades
				pan.getOk().addActionListener(this);
			} else {
				boolean mail = false;
				if (SendEmail.sendEmail(email, alias)) {				
					mail = true;
				} else {				
					pan.showMessage("E-mail not found!");
				}
				if (mail) {					
					sif.setVisible(false);
					if(gender) {
						crf.getCpp().getText2().setText(prop.getProperty("properties.controller.signin.incomes"));//propiedades
					}else {
						crf.getCpp().getText2().setText(prop.getProperty("properties.controller.signin.divorces"));//propiedades
					}
					crf.repaint();
					crf.setVisible(true);			
				}
			}
		}
		if(e.getActionCommand().equals("PHOTO1")) {
			String url1 = addPhoto();
			photos.add(url1);
			try {
				BufferedImage bi = ImageIO.read(new File(url1));
				Image resized = bi.getScaledInstance(crf.getCpp().getPhoto1().getWidth(), crf.getCpp().getPhoto1().getHeight(), Image.SCALE_SMOOTH);
				crf.getCpp().getPhoto1().setIcon(new ImageIcon(resized));
			} catch (Exception err) {
				err.printStackTrace();
			}
			crf.getCpp().getPhoto1().repaint();
			crf.repaint();
		}
		if(e.getActionCommand().equals("PHOTO2")) {
			String url2 = addPhoto();
			photos.add(url2);
			try {
				BufferedImage bi = ImageIO.read(new File(url2));
				Image resized = bi.getScaledInstance(crf.getCpp().getPhoto2().getWidth(), crf.getCpp().getPhoto2().getHeight(), Image.SCALE_SMOOTH);
				crf.getCpp().getPhoto2().setIcon(new ImageIcon(resized));
			} catch (Exception err) {
				err.printStackTrace();
			}
			crf.getCpp().getPhoto2().repaint();
			crf.repaint();
		}
		if(e.getActionCommand().equals("PHOTO3")) {
			String url3 = addPhoto();
			photos.add(url3);
			try {
				BufferedImage bi = ImageIO.read(new File(url3));
				Image resized = bi.getScaledInstance(crf.getCpp().getPhoto3().getWidth(), crf.getCpp().getPhoto3().getHeight(), Image.SCALE_SMOOTH);
				crf.getCpp().getPhoto3().setIcon(new ImageIcon(resized));
			} catch (Exception err) {
				err.printStackTrace();
			}
			crf.getCpp().getPhoto3().repaint();
			crf.repaint();
		}
		if(e.getActionCommand().equals("PHOTO4")) {
			String url4 = addPhoto();
			photos.add(url4);
			try {
				BufferedImage bi = ImageIO.read(new File(url4));
				Image resized = bi.getScaledInstance(crf.getCpp().getPhoto4().getWidth(), crf.getCpp().getPhoto4().getHeight(), Image.SCALE_SMOOTH);
				crf.getCpp().getPhoto4().setIcon(new ImageIcon(resized));
			} catch (Exception err) {
				err.printStackTrace();
			}
			crf.getCpp().getPhoto4().repaint();
			crf.repaint();
		}
		if(e.getActionCommand().equals("CREATE")) {	
			String description = crf.getCpp().getDescription().getText();

			int age = 2022-(int)sif.getLp().getYear().getSelectedItem(); //cambiar
			boolean ok = false;
			if(gender) {
				float incomes = 0;
				try {
					if (!photos.isEmpty()) {						
						incomes = Float.parseFloat(crf.getCpp().getIncome_divorces().getText());
						users.createUser(new UserManDTO(name, first_lastname, second_lastname, alias, orientation, email, gender, birth, age, description, photos, 0, 0, true, 0, origin, residence, contact, incomes), password);
						ok = true;
					} else {
						pan.showMessage("Please upload at least one photo");
					}
				} catch (Exception e2) {
					pan.showMessage("Use the character (.) instead of (,) for the incomes");
				}
			}else {
				if (!photos.isEmpty()) {						
					if (crf.getCpp().getIncome_divorces().getText().toLowerCase().equals("yes") || crf.getCpp().getIncome_divorces().getText().toLowerCase().equals("si") || crf.getCpp().getIncome_divorces().getText().toLowerCase().equals("no")) {					
						if(crf.getCpp().getIncome_divorces().getText().toLowerCase().equals("yes") || crf.getCpp().getIncome_divorces().getText().toLowerCase().equals("si")) {
							ok = true;
							users.createUser(new UserWomanDTO(name, first_lastname, second_lastname, alias, orientation, email, gender, birth, age, description, photos, 0, 0, true, 0, origin, residence, contact, true), password);
						}else {
							ok = true;
							users.createUser(new UserWomanDTO(name, first_lastname, second_lastname, alias, orientation, email, gender, birth, age, description, photos, 0, 0, true, 0, origin, residence, contact, false), password);
						}
					} else {
						pan.showMessage("Please write yes or no (Si o no)");					
					}
				} else {
					pan.showMessage("Please upload at least one photo");
				}
			}
			if (ok) {				
				crf.setVisible(false);
				login.updateData(alias, password, origin);
				session = users.getUsers().size()-1;
				chargeMainFrame();
				changeConfig();
			}
		}
		if(e.getActionCommand().equals("OK_PANES")) {
			pan.setVisible(false);
		}
		if(e.getActionCommand().equals("HOME")) {
			maf.setVisible(false);
			mfr.setVisible(true);
		}
		if(e.getActionCommand().equals("SETTINGS_ADMIN")) {
			if(!auf.getAup().getOp_panel().isVisible()) {				
				auf.getAup().showOptions();
				auf.repaint();
			} else {
				auf.getAup().getOp_panel().setVisible(false);
				auf.repaint();
			}

			if(!asf.getAsp().getOp_panel().isVisible()) {				
				asf.getAsp().showOptions();
				asf.repaint();
			} else {
				asf.getAsp().getOp_panel().setVisible(false);
				asf.repaint();
			}

			if(!sdf.getSdp().getOp_panel().isVisible()) {				
				sdf.getSdp().showOptions();
				sdf.repaint();
			} else {
				sdf.getSdp().getOp_panel().setVisible(false);
				sdf.repaint();
			}
		}
		if(e.getActionCommand().equals("UPDATE_USERS")) {
			if (auf.getAup().getFilters().getSelectedItem().equals(prop.getProperty("properties.admin.users.filters.likes"))) {
				String[] columnNames = {"#", "Name", "Age", "Likes", "Gender", "Orientation"};
				auf.getAup().showByLikes(columnNames, admins.topTen());
				auf.repaint();
			} else if (auf.getAup().getFilters().getSelectedItem().equals(prop.getProperty("properties.admin.users.filters.name"))) {
				String[] columnNames = {"Name", "Lastname", "Username", "Age", "Gender", "Orientation"};
				auf.getAup().showNewSort(columnNames, admins.showUsersByName());
				auf.repaint();
			} else if (auf.getAup().getFilters().getSelectedItem().equals(prop.getProperty("properties.admin.users.filters.lastname"))) {
				String[] columnNames = {"Lastname", "Name", "Username", "Age", "Gender", "Orientation"};
				auf.getAup().showNewSort(columnNames, admins.showUsersByLastName());
				auf.repaint();
			} else if (auf.getAup().getFilters().getSelectedItem().equals(prop.getProperty("properties.admin.users.filters.age"))) {
				String[] columnNames = {"Name", "Lastname", "Username", "Age", "Gender", "Orientation"};
				auf.getAup().showNewSort(columnNames, admins.showUsersByAge());
				auf.repaint();
			} else if (auf.getAup().getFilters().getSelectedItem().equals(prop.getProperty("properties.admin.users.filters.alias"))) {
				String[] columnNames = {"Username", "Name", "Lastname", "Age", "Gender", "Orientation"};
				auf.getAup().showNewSort(columnNames, admins.showUsersByAlias());
				auf.repaint();
			} else if (auf.getAup().getFilters().getSelectedItem().equals(prop.getProperty("properties.admin.users.filters.incomes"))) {
				String[] columnNames = {"Name", "Lastname", "Username", "Age", "Incomes"};
				auf.getAup().showNewSort(columnNames, admins.showByEarnings());
				auf.repaint();
			} else if (auf.getAup().getFilters().getSelectedItem().equals(prop.getProperty("properties.admin.users.filters.women"))) {
				String[] columnNames = {"Name", "Lastname", "Username", "Age"};
				auf.getAup().showNewSort(columnNames, admins.showWomen());
				auf.repaint();
			} else if (auf.getAup().getFilters().getSelectedItem().equals(prop.getProperty("properties.admin.users.filters.men"))) {
				String[] columnNames = {"Name", "Lastname", "Username", "Age"};
				auf.getAup().showNewSort(columnNames, admins.showMen());
				auf.repaint();
			}
		}
		if(e.getActionCommand().equals("UPDATE_STATS")) {
			users.loadSerializable();
			if (asf.getAsp().getFilters().getSelectedItem().equals(prop.getProperty("properties.admin.stadistics.filters.gender"))) {
				int men = 0, women = 0;
				for (UserDTO us : users.getUsers()) {
					if (us instanceof UserManDTO) men++;
					else if (us instanceof UserWomanDTO) women++;
				}
				asf.getAsp().showWomenVsMen(women, men);
				asf.repaint();
			} else if (asf.getAsp().getFilters().getSelectedItem().equals(prop.getProperty("properties.admin.stadistics.orientations"))) {
				int hetero = 0, homo = 0, bi = 0, pan = 0, demi = 0, asex = 0;
				for (UserDTO us : users.getUsers()) {
					switch (us.getOrientation()) {
					case "Heterosexual":
						hetero++;
						break;
					case "Homosexual":
						homo++;
						break;
					case "Asexual":
						asex++;
						break;
					case "Demisexual":
						demi++;
						break;
					case "Bisexual":
						bi++;
						break;
					case "Pansexual":
						pan++;
						break;
					}
				}
				asf.getAsp().showOrientationsStats(hetero, homo, bi, pan, demi, asex);
				asf.getAsp().getcPanel().repaint();
				asf.repaint();
			}
		}
		if(e.getActionCommand().equals("SHOW_USERS")) {
			auf.getAup().getOp_panel().setVisible(false);
			asf.getAsp().getOp_panel().setVisible(false);
			sdf.getSdp().getOp_panel().setVisible(false);
			sdf.setVisible(false);
			asf.setVisible(false);
			auf.setVisible(true);
		}
		if(e.getActionCommand().equals("SHOW_DELETE")) {
			auf.getAup().getOp_panel().setVisible(false);
			asf.getAsp().getOp_panel().setVisible(false);
			sdf.getSdp().getOp_panel().setVisible(false);
			sdf.setVisible(true);
			asf.setVisible(false);
			auf.setVisible(false);
		}
		if(e.getActionCommand().equals("STATS")) {
			auf.getAup().getOp_panel().setVisible(false);
			asf.getAsp().getOp_panel().setVisible(false);
			sdf.getSdp().getOp_panel().setVisible(false);
			asf.setVisible(true);
			auf.setVisible(false);
			sdf.setVisible(false);
		}
		if(e.getActionCommand().equals("REPORTS")) {
			pan.showMessage(admins.generatePDF());
		}
		if(e.getActionCommand().equals("DELETE_USER")) {
			String usernameaux = sdf.getSdp().getAlias().getText();
			if (usernameaux.equals("")) {
				pan.showMessage(prop.getProperty("properties.controller.delete.error"));
			} else {
				if (admins.deleteUser(usernameaux)) {
					for (int i=0; i<users.getUsers().size(); i++) {
						if(users.getUsers().get(i).getAlias().equals(usernameaux)) {							
							login.getLogins().remove(i);
							FileHandler.writeSerializable(login.getLogins(), "YHLQMDLG.uebfa");
						}
					}
					pan.showMessage(usernameaux+prop.getProperty("properties.controller.delete"));
				} else {
					pan.showMessage(prop.getProperty("properties.controller.login.error"));
				}
			}
		}
		if(e.getActionCommand().equals("SHOW_USER_INFO")) {
			String usernameaux = sdf.getSdp().getAlias().getText();
			if (usernameaux.equals("")) {
				pan.showMessage(prop.getProperty("properties.controller.delete.error"));
			} else {
				boolean cond = false;
				for (UserDTO us : users.getUsers()) {
					if (us.getAlias().equals(usernameaux)) {
						cond = true;
						break;
					} 
				}
				if (cond) {
					sdf.getSdp().getInfo().setText(admins.showUserInfo(usernameaux));
					sdf.getSdp().getInfo().repaint();
					sdf.getSdp().getInfo().setEditable(false);
					sdf.repaint();
				} else {
					pan.showMessage(prop.getProperty("properties.controller.login.error"));
				}
			}
		}
	}
}
