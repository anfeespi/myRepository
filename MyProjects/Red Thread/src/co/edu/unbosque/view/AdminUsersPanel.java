package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * Panel ver los usuarios
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class AdminUsersPanel extends JPanel {
	/**
	 * Logo de la compañia
	 */
	private JLabel icon;
	/**
	 * Opciones
	 */
	private JButton options;
	/**
	 * Texto
	 */
	private JLabel text;
	/**
	 * Filtros
	 */
	private JComboBox<String> filters;
	/**
	 * Filtros
	 */
	private String[] filters_texts; 
	/**
	 * Actualizar informacion
	 */
	private JButton update;
	/**
	 * Panel con la informacion
	 */
	private JScrollPane scrollPane;
	/**
	 * Panel con las opciones
	 */
	private OptionAdminPanel op_panel;
	/**
	 * Fuente principal
	 */
	private Font font;
	/**
	 * Propiedades
	 */
	private Properties prop;
	/**
	 * Constructo
	 */
	public AdminUsersPanel(int lang) {
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		prop= FileHandler.loadPropertiesLang(lang);
		filters_texts = new String[8];
		filters_texts[0]=prop.getProperty("properties.admin.users.filters.likes");
		filters_texts[1]=prop.getProperty("properties.admin.users.filters.name");
		filters_texts[2]=prop.getProperty("properties.admin.users.filters.lastname");
		filters_texts[3]=prop.getProperty("properties.admin.users.filters.age");
		filters_texts[4]=prop.getProperty("properties.admin.users.filters.alias");
		filters_texts[5]=prop.getProperty("properties.admin.users.filters.incomes");
		filters_texts[6]=prop.getProperty("properties.admin.users.filters.women");
		filters_texts[7]=prop.getProperty("properties.admin.users.filters.men");
		initComponents(lang);
}

/**
 * Metodo para inicializar componentes
 */
private void initComponents(int lang) {
	try {
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
	} catch (Exception e) {
		System.out.println(e);
	}
	font = new Font("Raleway", 0, 30);
	setBackground(Color.BLACK);

	icon = new JLabel();
	icon.setBounds(64, 13, 124, 110);
	try {
		BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/RedThreadIcon.png"));
		Image title_resized = bi.getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH);
		icon.setIcon(new ImageIcon(title_resized));
	} catch (Exception e) {
		e.printStackTrace();
	}
	icon.setVisible(true);

	options = new JButton();
	options.setBackground(Color.BLACK);
	options.setBounds(1066, 33, 70, 70);
	options.setIcon(new ImageIcon("src/co/edu/unbosque/util/media/GUIImgs/optionicon.png"));
	options.setVisible(true);

	text = new JLabel(prop.getProperty("properties.admin.users.showuser")); 
	text.setBounds(190, 153, 240, 40);
	text.setFont(font);
	text.setOpaque(false);
	text.setBackground(Color.BLACK);
	text.setForeground(Color.WHITE);
	text.setVisible(true);

	filters = new JComboBox<>(filters_texts);
	filters.setBounds(450, 153, 350, 40);
	filters.setFont(font);
	filters.setVisible(true);

	update = new JButton(prop.getProperty("properties.admin.users.update")); //Usar properties
	update.setFont(font);
	update.setBounds(820, 149, 220, 50);
	update.setVisible(true);

	JScrollPane scrollPane = null;

	op_panel = new OptionAdminPanel(lang);

	add(icon);
	add(options);
	add(text);
	add(filters);
	add(update);
}

/**
 * Mostrar organizado por likes
 * @param columnNames
 * @param matrix
 */
public void showByLikes(String[] columnNames, String[][] matrix) {
	if (scrollPane != null) {
		remove(scrollPane);
	}
	DefaultTableModel dtm = new DefaultTableModel(matrix, columnNames);
	JTable table = new JTable(dtm);
	table.setEnabled(false);
	table.setPreferredScrollableViewportSize(new Dimension(1100, 440));
	scrollPane = new JScrollPane(table);
	scrollPane.setBounds(50, 215, 1100, 200);
	scrollPane.setVisible(true);
	add(scrollPane);   
}

/**
 * Mostrar organizados
 * @param columnNames
 * @param matrix
 */
public void showNewSort(String[] columnNames, String[][] matrix) {
	if (scrollPane != null) {
		remove(scrollPane);
	}
	DefaultTableModel dtm = new DefaultTableModel(matrix, columnNames);
	JTable table = new JTable(dtm);
	table.setEnabled(false);
	table.setPreferredScrollableViewportSize(new Dimension(1100, 440));
	scrollPane = new JScrollPane(table);
	scrollPane.setBounds(50, 215, 1100, 440);
	scrollPane.setVisible(true);
	add(scrollPane);   
}

/**
 * Mostrar opciones
 */
public void showOptions() {
	op_panel.setBounds(826, 33, 240, 240);
	op_panel.setVisible(true);
	add(op_panel, 1);
}

/**
 * @return the options
 */
public JButton getOptions() {
	return options;
}

/**
 * @param options the options to set
 */
public void setOptions(JButton options) {
	this.options = options;
}

/**
 * @return the filters
 */
public JComboBox<String> getFilters() {
	return filters;
}

/**
 * @param filters the filters to set
 */
public void setFilters(JComboBox<String> filters) {
	this.filters = filters;
}

/**
 * @return the update
 */
public JButton getUpdate() {
	return update;
}

/**
 * @param update the update to set
 */
public void setUpdate(JButton update) {
	this.update = update;
}

/**
 * @param scrollPane
 */
public AdminUsersPanel(JScrollPane scrollPane) {
	super();
	this.scrollPane = scrollPane;
}

/**
 * @return the op_panel
 */
public OptionAdminPanel getOp_panel() {
	return op_panel;
}

/**
 * @param op_panel the op_panel to set
 */
public void setOp_panel(OptionAdminPanel op_panel) {
	this.op_panel = op_panel;
}


}
